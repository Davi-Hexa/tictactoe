package tictactoe.core;

import tictactoe.Constants;
import tictactoe.ui.UI;

public class Board {
	
	char[][] matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
	
	//Comando abaixo funciona para limpar a linha do tabuleiro.
	public void clear() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = ' ';
			}
		}
	}
	
	//o comando abaixo serve para dar um print no tabuleiro.
	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				UI.printTextNoLine(String.valueOf(matrix[i][j]));
				if (j < matrix[i].length - 1) {
					UI.printTextNoLine(" | ");
				}
			}
			UI.printNewLine();
			if (i < matrix[i].length -1) {
				UI.printText("---------");
			}
		}
	}
	
	//comando abaixo verifica se o tabuleiro está cheio.
	public boolean isfull() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == ' ') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	//comando abaixo identifia o player
	public boolean play(Player player, Move move) throws InvalidMoveException {
		int i = move.getI();
		int j = move.getJ();
		
		if (i < 0 || j < 0 || i > Constants.BOARD_SIZE || j > Constants.BOARD_SIZE ) {
			throw new InvalidMoveException("Intervalo de jogada é invalido\br");
		}
		if (matrix[i][j] != ' ') {
			throw new InvalidMoveException("Jogada ja realizada!");
		}
		
		matrix[i][j] = player.getSymbol();
		
		
		return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);
	}
	
	//comando abaixo identifica se as linhas sao iguais.
	private boolean checkRows(Player player) {
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (checkRow(i, player)){
				return true;
			}
		}
		return false;
	}
	
	private boolean checkRow(int i, Player player) {
		char symbol = player.getSymbol();
		
		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (matrix[i][j] != symbol) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkCols(Player player) {
		for (int j = 0; j < Constants.BOARD_SIZE; j++) {
			if (checkCol(j, player)){
				return true;
			}
		}
		return false;
	}
	
	private boolean checkCol(int j, Player player) {
		char symbol = player.getSymbol();
		
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if (matrix[i][j] != symbol) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkDiagonal1(Player player) {
		char symbol = player.getSymbol();

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			if(matrix[i][i] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkDiagonal2(Player player) {
		char symbol = player.getSymbol();
		

		for (int i = 2, j = 0; i >= 0; i--, j++) {
			if(matrix[i][j] != symbol) {
				return false;
			}
		}
		
		return true;
	}
	
}



//Coisas que eu fiz agora: eu criei o clear para limpar, o for no clear está marcando as linhas e as colunas do game, ou o i sendo a linha o j
//sendo as colunas; o método print segue uma matriz diferente, ele esta dando print nas linhas e colunas, puxando da class UI criada anteriormente
//for (int j = 0; j < matrix[i].length; j++) {
//UI.printTextNoLine(String.valueOf(matrix[i][j]));
//if (j < matrix[i].length - 1) {
//	UI.printTextNoLine(" | ");
// código acima mostra o comando que foi feito para dar o print nas linhas, em baixo dela no código tem os comandos para tirar imprimir as linhas
