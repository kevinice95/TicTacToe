/**
 * @author Kevin Trujillo
 * TicTacTester ensures that TicTacGame is working properly. User should pick first to move and make the 
 * center move.The computer will try all ( in 99.99% of cases) the combinations and think all of them are
 * losing. It will memorize that combination as losing (if all possible permutations of a position are losing,
 * that implies that position is also losing). 
 * 1st game - 1st to move,pick 2-2, Computer should make a move but print that it will lose
 * 2nd game - 1st to move, pick 2-2. Computer should make a corner move. pick 1-1. Computer will have a decent change of drawing
 * Because java throws nextInt exception (there is no catch in any of the whole tictac code), only play
 * one new game at a time since it will throw a NoSuchElementException
 */
import java.util.Scanner;
import java.util.NoSuchElementException;
public class TicTacTester {
static String[] infiniteLoop;
static String[] createResistance;

	public static void main(String[] args) {
		try {
	createResistance = createResistance();
	TicTacGame.gameOn(createResistance);	
	infiniteLoop = createInifinite();	
	
	TicTacGame.gameOn(infiniteLoop);
	} catch (NoSuchElementException e) {
	 System.out.print("Game Failed");
	}
	}

	/** Creates an array that makes any combination in which you choose the center losing for the computer
	 * @return combination array
	 */
	public static String[] createInifinite() {
		String[] infinite = new String[8];	
		infinite[0] = "O   X    ";
		infinite[1] = " O  X    ";
		infinite[2] = "  O X    ";
		infinite[3] = "   OX    ";
		infinite[4] = "    XO   ";
		infinite[5] = "    X O  ";
		infinite[6] = "    X  O ";
		infinite[7] = "    X   O";
       return infinite;	
	}
	
	/** Creates some resistance by making the computer choose a corner move as a first move against center move
	 * @return a String[] of combinations
	 */
	public static String[] createResistance() {
		String[] answer = new String[13];
		// this will make it so it picks a corner move
		answer[0] = "   OX    ";
		answer[1] = "    XO   ";
		answer[2] = " O  X    ";
		answer[3] = "    X  O ";
		answer[4] = "X OOX    ";
		answer[5] = "XOO X    ";
		answer[6] = "XO  XO   ";
		answer[7] = "X  OXO   ";
		answer[8] = "X  OX  O ";
		answer[9] = "X   XOO  ";
		answer[10] = "X   X OO ";
		answer[11] = "X   X O O";
		answer[12] = "X OOX    ";
		return answer;
	}
}
