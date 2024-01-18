package Xadrez;

import Tabuleiro.Board;
import Tabuleiro.Piece;

public class Chess_Piece extends Piece{
	
	private Color color;

	public Chess_Piece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	
}
