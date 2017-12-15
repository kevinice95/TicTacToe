import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Random;
/**
 * @author Kevin Trujillo
 * This class implements all methods to implement a TicTactoe game. it creates an empty array and is able to prompt the user for move
 * or generate a random combination that is not already in a losing combinations array.
 *
 */
public class TicTacToe {
private final int COLS = 3;
private final int ROWS = 3;
private String[][] tictac;
private int lastI;
//total of 512 different tictactoe combinations
private final int COMBSIZE = 50;
private String[] combinations = new String[COMBSIZE];
private String turn = "X";
Random rand = new Random();
Scanner scan = new Scanner(System.in);
private int random1;
private int random2;
private int x;
private int y;
/**
 * Creates a new tictactoe game with and empty board 
 */
public TicTacToe() {
 this.tictac = new String[ROWS][COLS];
 this.turn = "X";
 this.lastI = 0;
}
/**
 * Creates a new tictactoe game with combinations wanted
 * @param combinations2 is the array with combinations
 */
public TicTacToe(String[] combinations2) {
	 this.tictac = new String[ROWS][COLS];
	 this.turn = "X";
	 for (int i = 0; i < combinations2.length; i++) {
		 combinations[i] = combinations2[i];
	 }
	 this.combinations = combinations;
	 this.lastI = combinations2.length;
}
/**
 * @param board state that can be used to store in combinations
 * @return boardstate to string
 */
public String boardToString(String[][] current) {
String answer =  new String();
for (int i = 0; i < COLS; i++) {
	for (int j = 0; j < ROWS; j++) {
	answer += current[j][i];
	}
}
return answer;
}
/**
 * Changes the turn of the player. Not really useful, but maybe necessary for possible future improvements
 */
public void changeTurn() { 
	if (this.turn == "X") {
		this.turn = "O";	
	} else {
		this.turn = "X";
	}
}
/**
 * Prints the board such that it has a 3x3 format
 */
public void printBoard() {
	for (int i = 0; i < COLS; i++) {
		for (int j = 0; j < ROWS; j++) {
			if (this.tictac[j][i] == null) {
				System.out.print("-");
			} else {
	System.out.print(this.tictac[j][i]);		
			}
		} System.out.println();
}}
/**
 * Checks if current combination is on the list of combinations
 * @param tempBoard is the current state of the board
 * @return if it is in the combinations or not
 */
public boolean hasCombination(String tempBoard) {
for (int i = 0; i < this.lastI; i++) {
	if (tempBoard.equals(this.combinations[i])) {
		return true;
	}
} return false;	
}

/** 
 * Creates temporary board state that will be used to check if it is in combinations
 * @param number1 is the x value
 * @param number2 is the y value
 * @return the board state in string form
 */
public String tempBoardState(int number1,int number2) {
	this.tictac[number1][number2] = this.turn;
	String tempBoard = new String();
	for (int i = 0; i < COLS; i++) {
		for (int j = 0; j < ROWS; j++) {
			if (this.tictac[j][i] == null) {
				tempBoard += " ";
			} else {
		tempBoard += this.tictac[j][i];
			}
		}

} 
this.tictac[number1][number2] = null;	
	return tempBoard;
}

/**
 * This is the most important method. It checks whose turn it is and it either prompts
 * the user for a move (and makes sure it is valid) or it prompts the computer for a move
 */
public void getTurn() {
	int i;
	int j;
	if (this.turn == "X") {
		do {
System.out.println("Write row and col where you want to make move"); 
  i = scan.nextInt();
  j = scan.nextInt();
  i--; j--;
		} while (i > 3 || j > 3 || this.tictac[i][j] != null);
	this.tictac[i][j] = this.turn;
	this.x = i; this.y = j;
	} else {
	this.computerMove();	
	}
	this.changeTurn();
}
/**
 * Creates two random numbers, check if it is a combination or if it is null and then
 * if it is a valid move it makes the move.
 * If all the posibilities mean you lose, it means that the combination itself is losing
 * and it will memorize it.
 */
public void computerMove() {
int N = 0;
do {
	 random1 = rand.nextInt(3);
	 random2 = rand.nextInt(3);
	if ((this.tictac[random1][random2] == null)) {
		if (!this.hasCombination(tempBoardState(random1,random2))) {
			break;
		}
	}
	if (N > 25 && this.tictac[random1][random2] == null) {
		System.out.println("All posibilities equal death, might as well be random");
		this.memorize();
		break;
	}
	N++;
 } while (true);
 	 this.tictac[random1][random2] = this.turn;
 }
/**
 * @return true or false (if a player has won)
 */
public boolean hasWon() {

	// Diagonals
if (this.tictac[0][0] == this.tictac[1][1] && this.tictac[1][1] == this.tictac[2][2] && this.tictac[1][1] != null) {
	return true;
} if (this.tictac[2][0] == this.tictac[1][1] && this.tictac[1][1] == this.tictac[0][2] && this.tictac[1][1] != null) {
	return true;
}
// Horizontal
for (int x = 0; x < ROWS; x++) {
if (this.tictac[0][x] == this.tictac[1][x] && this.tictac[1][x] == this.tictac[2][x] && this.tictac[1][x] != null) {
	return true;
}
}
//Vertical
for (int y = 0; y < COLS; y++) {
if (this.tictac[y][0] == this.tictac[y][1] && this.tictac[y][1] == this.tictac[y][2] && this.tictac[y][1] != null) {
	return true;
}
}
return false;	
}
/** returns the winner or null in case of a draw
 * @return
 */
public String getWinner() {
	if (!this.isDraw()) {
	this.changeTurn();
	return this.turn;
	} else {
		return null;
	}
	
}
/** checks if the board is full and if nobody has won. if so then it is a draw
 * @return true or false
 */
public boolean isDraw() {
	if (this.hasWon()) {
		return false;
	} else {
		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
			if (this.tictac[i][j] == null) {
				return false;
				}
			}
	} return true;} 
}
/**
 * @return current turn
 */
public String returnTurn() {
	return this.turn;
}

/**
 * stores current board state minus opposite player's last move as a losing combination
 */
public void memorize() {
	String combination = this.tempBoardState2(this.x,this.y);
	if (!this.hasCombination(combination)) {
	this.combinations[this.lastI] = combination;
	this.lastI++;
	}
	}
/**
 * @param number1
 * @param number2
 * @return
 */
public String tempBoardState2(int number1,int number2) {
	this.tictac[number1][number2] = null;
	String tempBoard = new String();
	for (int i = 0; i < COLS; i++) {
		for (int j = 0; j < ROWS; j++) {
			if (this.tictac[j][i] == null) {
				tempBoard += "-";
			} else {
		tempBoard += this.tictac[j][i];
			}
		}
} this.tictac[number1][number2] = "X";	
	return tempBoard;
} 
/**
 * prints all combinations in the combinations string. mostly for testing and not for user.
 */
public void showCombs() {
	for (String comb: this.combinations) {
		if (comb != null)
		System.out.println(comb);
	}
}
/**
 * prompts user for who should play first and resets the board.
 */
public void resetGame() {

	System.out.println("1 for playing first and 2 for playing second");
	System.out.println("Any other number will make you the first player");
   int a = scan.nextInt();
	 if (a == 2) {
		this.turn = "O";
	} else {
		this.turn = "X";
	}
	
	for (int i = 0; i < COLS; i++) {
		for (int j = 0; j < ROWS; j++) {
			this.tictac[i][j] = null;
		}
		}
}
/** prints board on a file
 * @param out is where the board is printed
 */
public void printBoard(PrintWriter out) {
	for (int i = 0; i < COLS; i++) {
		for (int j = 0; j < ROWS; j++) {
			if (this.tictac[j][i] == null) {
				out.print("-");
			} else {
	   out.print(this.tictac[j][i]);		
			}
		} out.println();
}}
/** prints combinations on a file
 * @param out where file is written
 */
public void showCombs(PrintWriter out) {
	for (String comb: this.combinations) {
		if (comb != null)
		out.println(comb);
	}
}
/** same as getTurn() but writes output on a file.
 * @param out file where output gets printed
 */
public void getTurn(PrintWriter out) {
	int i;
	int j;
	out.println("Your turn to make a move");
	if (this.turn == "X") {
		do {
     System.out.println("Write row and col where you want to make move"); 
  i = scan.nextInt();
  j = scan.nextInt();
  i--; j--;
		} while (i > 3 || j > 3 || this.tictac[i][j] != null);
		out.println("You moved " + i + " to the right and " + j + " down");
	this.tictac[i][j] = this.turn;
	this.x = i; this.y = j;
	} else {
	this.computerMove();	
	}
	this.changeTurn();}
/**
 * @param out is the file where everything is written
 * resets game by prompting user
 */
public void resetGame(PrintWriter out) {
	System.out.println("1 for playing first and 2 for playing second");
	System.out.println("Any other number will make you the first player");
	out.println("1 for playing first and 2 for playing second");
	out.println("Any other number will make you the first player");
	int a = scan.nextInt();
	
	 if (a == 2) {
		this.turn = "O";
		out.println("Computer plays first");
	} else {
		this.turn = "X";
		out.println("Human plays first");
	}
		for (int i = 0; i < COLS; i++) {
			for (int j = 0; j < ROWS; j++) {
				this.tictac[i][j] = null;
			}
			}
}}

