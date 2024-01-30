package Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Tabuleiro.Board;
import Tabuleiro.Piece;
import Tabuleiro.Position;
import Xadrez.Pieces.King;
import Xadrez.Pieces.Rook;

public class Chess_Match {
	
	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public Chess_Match() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
	}
	public int getTurn() {
		return turn;
	}
	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	public boolean getCheck() {
		return check;
	}
	public Chess_Piece[][] getPieces() {
		Chess_Piece[][] mat = new Chess_Piece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (Chess_Piece) board.piece(i, j);
			}
		}
		return mat;
	}
	public boolean[][] possibleMoves(Chess_Position sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	public Chess_Piece performChessMove(Chess_Position sourcePosition, Chess_Position targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		
		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new Chess_Exception("You can't put yourself in check");
		}
		check = (testCheck(opponent(currentPlayer))) ? true : false;
		
		nextTurn();
		return (Chess_Piece)capturedPiece;
	}
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if(capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		return capturedPiece;
	}
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		Piece p = board.removePiece(target);
		board.placePiece(p, source);
		
		if (capturedPiece != null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new Chess_Exception("There is no part in the home position");
		}
		if (currentPlayer != ((Chess_Piece)board.piece(position)).getColor()) {
			throw new Chess_Exception("The chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new Chess_Exception("There is no possible moves from the chosen piece");
		}
	}
	private void validateTargetPosition(Position source, Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new Chess_Exception("The chosen piece can't move to target position");
		}
	}
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	private Color opponent(Color color) {
		return(color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	private Chess_Piece king(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((Chess_Piece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (Chess_Piece)p;
			}
		}
		throw new IllegalStateException("There is no " + color + " king on the board");
	}
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChess_Position().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((Chess_Piece)x).getColor() == opponent(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}
	private void placeNewPiece(char column, int row, Chess_Piece piece) {
		board.placePiece(piece, new Chess_Position(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
