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

		// Main loop running/processing text
		while (true) {
			IO.print(Config.prompt);

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
		}

		// Print exit code
		IO.println(Config.exitMessage);
	}
}
