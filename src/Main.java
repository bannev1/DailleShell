import java.util.ArrayList;

import exceptions.CommandNotFoundError;
import exceptions.SyntaxError;
import executor.Executor;
import parser.Parser;
import parser.nodes.Node;
import tokens.Token;
import tokens.Tokenizer;

/**
 * This program is designed to run the code required to execute Daille Shell
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class Main {

	public static void main (String[] args) {
		String line;

		Tokenizer tokenizer = new Tokenizer();
		ArrayList<Token> userInput = new ArrayList<>();

		// Indicates if is a new command or not
		// Determines which prompt
		boolean newCommand = true;

		// Main loop running/processing text
		while (true) {
			if (newCommand) {
				IO.print(Config.prompt);
			} else {
				IO.print(Config.continueCmd);
			}

			// Read command
			line = IO.readln();

			// Ctrl+D detected
			if (line == null) {
				break;  // Exit code
			}

			// Trim line for whitespace
			line = line.trim();

			// If empty line, continue / move to next line
			if (line.equals("")) {
				continue;
			}

			// Tokenize text
			tokenizer.tokenize(line);
			
			// If no semicolon, continue and wait until semicolon
			if (!tokenizer.hasSemicolon()) {
				newCommand = false;
				continue;
			}
			
			// Otherwise, if command written, run commands
			while (tokenizer.hasSemicolon()) {
				// Get tokenized command
				userInput = tokenizer.clearPreviousCommand();

				try {
					try {
						// Parse the tokenized command 
						Parser parser = new Parser(userInput);
						Node node = parser.parse();
	
						// Use the executor to execute the tree
						Executor executor = new Executor(node);
						executor.execute();
						
					// Print errors
					} catch (SyntaxError err) {
						IO.println(Config.commandNotFound + ": " + err.getMessage());
					} catch (CommandNotFoundError err) {
						IO.println(Config.commandNotFound + ": " + err.getMessage());
					}
				} catch (Exception err) {
					// If caught generic exception likely from executor, print error
					IO.println(Config.genericError + ": " + err.getMessage());

					// Help print stack trace if on debug mode
					if (Config.debug) {
						err.printStackTrace();
					}
				}
			}

			newCommand = true;
		}

		// Print exit code
		IO.println(Config.exitMessage);
	}
}
