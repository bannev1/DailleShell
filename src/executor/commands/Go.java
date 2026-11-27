package executor.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import exceptions.SyntaxError;
import executor.State;
import exceptions.ArgumentError;
import exceptions.CommandFailed;

public class Go extends Command {
	@Override
	public String keyword() {
		return "go";
	}


	@Override
	public Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError {
		// If no arguments, go to home directory
		if (args.size() == 0) {
			State.cwd = new File(System.getProperty("user.home"));

			return new Result(0, null);
		}

		// Parse directory by compressing to String
		String path = "";

		for (String arg : args) {
			path += arg + " ";
		}

		path = path.trim();

		// Find target
		File target = new File(path);

		// If the path is not a complete path (from top of file system)
		if (!target.isAbsolute()) {
			target = new File(State.cwd, path);
		}

		// If the target isn't a folder or doesn't exist
		if (!target.isDirectory()) {
			throw new CommandFailed(path + " not found or isn't a folder");
		}

		// Try to access
		try {
			State.cwd = target.getCanonicalFile();  // Gets full path
		} catch (IOException err) {
			throw new CommandFailed(path + " could not be opened");
		}

		// Return if success
		return new Result(0, null);
	}
}
