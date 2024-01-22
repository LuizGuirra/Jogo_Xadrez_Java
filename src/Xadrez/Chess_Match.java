package Xadrez;

import Tabuleiro.Board;
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
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
