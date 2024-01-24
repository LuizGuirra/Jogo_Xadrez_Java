package Xadrez;

import Tabuleiro.Position;

public class Chess_Position {
	
	private char column;
	private int row;
<<<<<<< HEAD

	public Chess_Position(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
=======
	
	public Chess_Position(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
>>>>>>> 27289cdf84520be6344dc34e3dfcd07ce3cb3cd2
			throw new Chess_Exception("Erro ao instanciar a posição do xadrez. Os valores válidos são de a1 a h8.");
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
<<<<<<< HEAD
		return new Chess_Position((char) ('a' - position.getColumn()), 8 - position.getRow());
=======
		return new Chess_Position((char)('a' - position.getColumn()), 8 - position.getRow());
>>>>>>> 27289cdf84520be6344dc34e3dfcd07ce3cb3cd2
	}
	@Override
	public String toString() {
		return "" + column + row;
	}
}
