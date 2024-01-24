package Xadrez;

import Tabuleiro.BoardException;

public class Chess_Exception extends BoardException{
	private static final long serialVersionUID = 1L;
	
	public Chess_Exception(String msg) {
		super(msg);
	}
}
