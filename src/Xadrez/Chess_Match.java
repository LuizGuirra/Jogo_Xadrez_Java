package Xadrez;

import Tabuleiro.Board;
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
	private void placeNewPiece(char column, int row, Chess_Piece piece) {
		board.placePiece(piece, new Chess_Position(column, row).toPosition());
	}
	private void initialSetup() {
		placeNewPiece('a', 8, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
		placeNewPiece('a', 1, new Rook(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(board, Color.BLACK));
	}
}
