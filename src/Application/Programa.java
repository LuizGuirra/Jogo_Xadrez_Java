package Application;

import Xadrez.Chess_Match;

public class Programa {

	public static void main(String[] args) {
		
		Chess_Match chessMatch = new Chess_Match();
		UI.printBoard(chessMatch.getPieces());
	}
}
