package tictactoe;

import tictactoe.core.Game;
import tictactoe.core.InvalidMoveException;

public class Main {

	public static void main(String[] args) throws InvalidMoveException {
		Game g = new Game();
		g.play();
	}
	
}
