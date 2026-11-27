package executor.commands;

import java.util.ArrayList;
import exceptions.CommandNotFoundError;
import exceptions.SyntaxError;

public class Registry {
	public static String run(String keyword, ArrayList<String> arguments) throws CommandNotFoundError, SyntaxError {
		// List of all commands
		Command[] commandList = {
			new Go()
		};
		
		// Check built-ins, and prevent case sensing
		for (Command cmd : commandList) {
			if (cmd.keyword() == keyword.trim().toLowerCase()) {
				return cmd.run(arguments);
			}
		}

		// If command not in built-in, then throw command not found
		throw new CommandNotFoundError("`" + keyword + "` not found");
	}
}
