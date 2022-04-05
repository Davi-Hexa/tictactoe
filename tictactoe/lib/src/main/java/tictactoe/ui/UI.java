package tictactoe.ui;

import java.util.Scanner;

public class UI {
	static Scanner recebe = new Scanner(System.in);
	
	public static void printText(String text){
		System.out.println(text);
		
	}
	
	public static void printTextNoLine(String text) {
		System.out.print(text);
	}
	public static void printGameTitle() {
		printText("=-=-=-=-=-=-=-=-=-=-=-=");
		printText("|    JOGO DA VELHA    |");
		printText("=-=-=-=-=-=-=-=-=-=-=-=");
		printNewLine();
	}
	
	public static void printNewLine() {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public static String readInput(String text) {
		printTextNoLine(text + " ");
		return recebe.nextLine();
	}
}
