package executor.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import exceptions.ArgumentError;
import exceptions.SyntaxError;
import executor.State;
import exceptions.CommandFailed;

public class Rename extends Command {
	private static String argumentFormatMsg = "Please provide arguments in the format of 'rename \"<PATH TO DIRECTORY/FILE>\" \"<NEW NAME>\"'";
		// + "\n- The speech marks (\") are required for this command IF there are spaces in the path name or new name"

	@Override
	public String keyword() {
		return "rename";
	}


	@Override
	public Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError {
		// If has arguments, throw exception
		if (args.size() != 2) {
			throw new ArgumentError(argumentFormatMsg);
		}

		// Parse arguments
		String oldPath = args.get(0);
		String newPath = args.get(1);
		
		// Get target/old path
		File original = new File(oldPath);
		if (!original.isAbsolute()) {
			original = new File(State.cwd, oldPath);
		}

		// Access new path
		File destination = new File(newPath);
		if (!destination.isAbsolute()) {
			destination = new File(State.cwd, newPath);
		}

		// Ensure old path exists
		if (!original.exists()) {
			throw new CommandFailed("Old path " + oldPath + " does not exist");
		}

		// Ensure new path doesn't exist
		if (destination.exists()) {
			throw new CommandFailed("New path/name " + newPath + " already exists, can't overwrite");
		}

		// Attempt rename via move
		try {
			Files.move(original.toPath(), destination.toPath());
		} catch (IOException err) {
			// Error raised meaning rename failed
			throw new CommandFailed("Could not rename " + oldPath + " to " + newPath + ":\n\t" + err.getMessage());
		}

		// Return successful result
		return new Result(0, null);
	}
}
