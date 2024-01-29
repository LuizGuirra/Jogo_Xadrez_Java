package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.Chess_Exception;
import Xadrez.Chess_Match;
import Xadrez.Chess_Piece;
import Xadrez.Chess_Position;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Chess_Match chessMatch = new Chess_Match();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.print("Origem: ");
				Chess_Position source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Destino: ");
				Chess_Position target = UI.readChessPosition(sc);
				
				Chess_Piece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch(Chess_Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
