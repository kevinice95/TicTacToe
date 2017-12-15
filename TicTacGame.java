import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author Kevin Trujillo
 * This class presents the interface for the game and uses all the methods in TicTacToe to provide the user a playable game
 * note that if game is run twice, it will present a NoSuchElementException.
 *
 */
public class TicTacGame {

	/** Runs the game
	 * @param args
	 */
	public static void main(String[] args) {
	gameOn();
	} 
	/**
	 * Starts a new game without a combination array needed
	 */
	public static void gameOn() {
		Scanner scan = new Scanner(System.in);
		int again;
		String winner;
		TicTacToe game = new TicTacToe();
		do {	
		game.resetGame();	
		do {
		if (game.returnTurn() == "X") {
			game.printBoard();
		}
		game.getTurn();	
		}while (!game.hasWon() && !game.isDraw());
		winner = game.getWinner();
	  if (winner == "X") {
		  System.out.println("You won!");
			game.printBoard();
		  game.memorize();
	  } if (winner == "O") {
		  System.out.println("the computer won!");
			game.printBoard();
	  }  if (winner == null) {
		  System.out.println("Game is a tie");
		  game.printBoard();
	  }
	  System.out.println("To play again write 1");
	  again = scan.nextInt();
		} while (again == 1);
		System.out.println("Thanks for playing");
		scan.close();
		game.showCombs();
		} 
	
	/** Creates a new game with the String array wanted as initial combination
	 * @param array is the combination that the user provides
	 */
	public static void gameOn(String[] array) {
		Scanner scan = new Scanner(System.in);
		int again;
		String winner;
		TicTacToe game = new TicTacToe(array);
		do {	
		game.resetGame();	
		do {
		if (game.returnTurn() == "X") {
			game.printBoard();
		}
		game.getTurn();	
		}while (!game.hasWon() && !game.isDraw());
		winner = game.getWinner();
	  if (winner == "X") {
		  System.out.println("You won!");
			game.printBoard();
		  game.memorize();
	  } if (winner == "O") {
		  System.out.println("the computer won!");
			game.printBoard();
	  }  if (winner == null) {
		  System.out.println("Game is a tie");
		  game.printBoard();
	  }
	  System.out.println("To play again write 1");
	  again = scan.nextInt();
		} while (again == 1);
		System.out.println("Thanks for playing");
		scan.close();
		} 
	
	/** Starts a new game with combination and output file provided
	 * @param array is the array of combinations wanted
	 * @param out is where all the output will be directed
	 */
	public static void gameOn(String[] array, PrintWriter out) {
		Scanner scan = new Scanner(System.in);
		int again;
		String winner;
		TicTacToe game = new TicTacToe(array);
		do {	
		game.resetGame(out);	
		do {
		if (game.returnTurn() == "X") {
			out.println("Your turn");
			game.printBoard(out);
			game.printBoard();
		} else {
			out.println("Computer's turn");
			game.printBoard(out);	
			
		}
		game.getTurn(out);	
		}while (!game.hasWon() && !game.isDraw());
		winner = game.getWinner();
	  if (winner == "X") {
		  out.println("You won!");
		  System.out.println("You won!");
			game.printBoard(out);
			game.printBoard();
		  game.memorize();
	  } if (winner == "O") {
		  out.println("the computer won!");
		  System.out.println("the computer won!");
			game.printBoard(out);
			game.printBoard();
	  }  if (winner == null) {
		  out.println("Game is a tie");
		  game.printBoard(out);
		  game.printBoard();
	  }
	  out.println("To play again write 1");
	  System.out.println("To play Again write 1");
	  again = scan.nextInt();
		} while (again == 1);
		out.println("You wrote " + again + ", Thanks for playing");
		out.println("Here are the losing combinations stored in this game");
		game.showCombs(out);
		scan.close();
		out.close();
		} 
	
	}



