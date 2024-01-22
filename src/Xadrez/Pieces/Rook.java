package Xadrez.Pieces;

import Tabuleiro.Board;
import Xadrez.Chess_Piece;
import Xadrez.Color;

public class Rook extends Chess_Piece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	@Override
	public String toString() {
		return "T";
	}
}
