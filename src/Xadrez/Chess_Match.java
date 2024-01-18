package Xadrez;

import Tabuleiro.Board;

public class Chess_Match {
	
	private Board board;
	
	public Chess_Match() {
		board = new Board(8, 8);
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
}
