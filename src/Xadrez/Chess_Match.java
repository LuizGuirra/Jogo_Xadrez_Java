package Xadrez;

import Tabuleiro.Board;
import Tabuleiro.Piece;
import Tabuleiro.Position;
import Xadrez.Pieces.King;
import Xadrez.Pieces.Rook;

public class Chess_Match {
	
	private Board board;
	
	public Chess_Match() {
		board = new Board(8, 8);
		initialSetup();
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
	public Chess_Piece performChessMove(Chess_Position sourcePosition, Chess_Position targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (Chess_Piece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new Chess_Exception("There is no part in the home position");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new Chess_Exception("There is no possible moves from the chosen piece");
		}
	}
	private void placeNewPiece(char column, int row, Chess_Piece piece) {
		board.placePiece(piece, new Chess_Position(column, row).toPosition());
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
