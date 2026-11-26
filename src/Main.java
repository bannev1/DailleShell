import java.util.ArrayList;

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
			}

			newCommand = true;
		}

		// Print exit code
		IO.println(Config.exitMessage);
	}
}
