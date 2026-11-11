package commands;

import java.util.ArrayList;

/**
 * This abstract class represents what every command looks like/extends
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public abstract class Command {
	// What will determine what calls the command
	protected final String keyword = "";

	// What runs the command
	// Must return the exit status
	// 0 = success
	int run(ArrayList<String> args) {
		throw new UnsupportedOperationException("This command has not yet been created"); 
	}
}
