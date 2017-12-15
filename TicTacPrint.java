import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * @author Kevin Trujillo
 * This class implements the ticTacToeGame (which can be run by just using TicTacGame.gameOn and uses
 * command line arguments to read combinations the user might provide. If none are available, none will
 * be used and the program will start with an empty array of combinations. This also prints all the methods 
 * to a file.
 *
 */
public class TicTacPrint {

	/** Creates a new game with array provided.
	 * @param args array combination
	 * @throws FileNotFoundException safety
	 */
	public static void main(String[] args) throws FileNotFoundException {
	String[] combinations = new String[args.length];
	for (int i = 0; i < args.length; i++) {
		combinations[i] = args[i];
	}
	PrintWriter out = new PrintWriter("csis.txt");
	TicTacGame.gameOn(combinations,out);
	out.close();
	}

}
