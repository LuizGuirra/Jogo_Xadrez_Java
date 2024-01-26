package Xadrez;

import Tabuleiro.Position;

public class Chess_Position {
	
	private char column;
	private int row;
	
	public Chess_Position(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new Chess_Exception("Error instantiating chess position. Valid values are a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	protected static Chess_Position fromPosition(Position position) {
		return new Chess_Position((char) ('a' - position.getColumn()), 8 - position.getRow());
	}
	@Override
	public String toString() {
		return "" + column + row;
	}
}
