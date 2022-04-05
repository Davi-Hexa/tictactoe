package tictactoe.core;

import tictactoe.ui.UI;

public class Player {
	private String name;
	private char symbol;


	public Player(String name, char symbol, tictactoe.core.Board board) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.board = board;
	}
	
	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}

	public Board getBoard() {
		return board;
	}

	private Board board;
	
	private Move inputMove() throws InvalidMoveException{
		String moveStr = UI.readInput("jogador "+name +" =>");
		return new Move (moveStr);
	}
	
	public boolean play() throws InvalidMoveException {
		Move move = inputMove();
		return board.play(this, move);
	}
}
