package executor.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import exceptions.ArgumentError;
import exceptions.SyntaxError;
import executor.State;
import exceptions.CommandFailed;

public class Read extends Command {
	private static String argumentFormatMsg = "Please provide arguments in the format of 'read <FILE NAME>'";

	@Override
	public String keyword() {
		return "read";
	}


	@Override
	public Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError {
		// If has arguments, throw exception
		if (args.size() == 0) {
			throw new ArgumentError(argumentFormatMsg);
		}

		// Get path of the to-read item
		String path = "";

		for (int i = 1; i < args.size(); i++) {
			path += args.get(i) + " ";
		}

		path = path.trim();

		// Access file
		File target = new File(path);
		if (!target.isAbsolute()) {
			target = new File(State.cwd, path);
		}
		
		// Make sure file exists
		if (!target.exists()) {
			throw new CommandFailed(path + " not found");
		}
		
		// Make sure file is a file
		if (!target.isFile()) {
			throw new CommandFailed(path + " is not a file");
		}

		// Attempt to open file
		try {
			String contents = Files.readString(target.toPath());
			
			// Return contents of file
			return new Result(0, contents);
		} catch (IOException err) {
			// Throw error if failed to open
			throw new CommandFailed("Could not read " + path + ":\n\t" + err.getMessage());
		}
	}
}
