package Xadrez;

import Tabuleiro.Board;
import Tabuleiro.Piece;
import Tabuleiro.Position;

public abstract class Chess_Piece extends Piece{
	
	private Color color;

	public Chess_Piece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	protected boolean isThereOpponentPiece(Position position) {
		Chess_Piece p = (Chess_Piece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}
