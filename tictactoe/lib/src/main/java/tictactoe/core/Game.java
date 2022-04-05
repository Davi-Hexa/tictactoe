package tictactoe.core;


import tictactoe.Constants;
import tictactoe.ui.UI;

public class Game {
	
	private Board board = new Board();
	private Player[] player = new Player[Constants.SYMBOL_PLAYER.length];
	private int courrentPlayerIndex = 0;
	
	public void play() throws InvalidMoveException {
		UI.printGameTitle();

		
		//para o game nao acabar eu utilizei este metodo aqui
		while (true) {
			
			board.clear();
			
			for (int i = 0; i < player.length; i++) {
				player[i] = createPlayer(i);
			}
			boolean gameEnded = false;
			Player currentPlayer = nextPlayer(); 
			Player winner = null;
			
			while(!gameEnded) {
				board.print();
				
				boolean sequenceFound;
				
				try {
					sequenceFound = currentPlayer.play();
				} catch (InvalidMoveException e) {
					UI.printText("Erro: " +e.getMessage());
					continue;
				}
				if (sequenceFound) {
					gameEnded = true;
					winner = currentPlayer;
				} else if (board.isfull()) {
					gameEnded = true;
				}else {
					currentPlayer = nextPlayer();
				}
			}
			board.print();

			UI.printText("Fim de Game");

			if(winner == null) {
				System.out.println("O Jogo Terminou emapatado");
			}else {
				System.out.println("O jogador "+ winner.getName() + " Venceu o jogo");
			}
			
			
			String continua = UI.readInput("Deseja continuar? [S/N]").strip().toUpperCase();
			if (continua.equals("N")) {
				break;
			}
		}		
	}
	
	
	private Player createPlayer(int valor) {
		String name = UI.readInput("jogador " + (valor + 1));
		char symbol = Constants.SYMBOL_PLAYER[valor];
		Player player = new Player(name, symbol, board);
		
		UI.printText("O Jogaodr " + name + " Vai usar o símbulo " + symbol);
		
		return player;
	}
	
	private Player nextPlayer() {
		courrentPlayerIndex = (courrentPlayerIndex + 1) % player.length;
		return player[courrentPlayerIndex];
	}
}
