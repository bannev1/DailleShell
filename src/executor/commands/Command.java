package executor.commands;

import java.util.ArrayList;
import exceptions.ArgumentError;
import exceptions.SyntaxError;
import exceptions.ExitProgram;
import exceptions.CommandFailed;

/**
 * This abstract class represents what every command looks like/extends
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public abstract class Command {
	// What will determine what calls the command
	public abstract String keyword();

	// What runs the command
	public abstract Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError, ExitProgram;
}
