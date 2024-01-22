package Xadrez.Pieces;

import Tabuleiro.Board;
import Xadrez.Chess_Piece;
import Xadrez.Color;

public class King extends Chess_Piece{

	public King(Board board, Color color) {
		super(board, color);
	}
	@Override
	public String toString() {
		return "R";
	}
}
