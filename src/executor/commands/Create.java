package executor.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import exceptions.ArgumentError;
import exceptions.SyntaxError;
import executor.State;
import exceptions.CommandFailed;

public class Create extends Command {
	private static String argumentFormatMsg = "Please provide arguments in the format of 'create <dir/file> <DIRECTORY/FILE NAME>'"
		+ "\n\t`dir` = create a directory/folder"
		+ "\n\t`file` = create a file";

	@Override
	public String keyword() {
		return "create";
	}


	@Override
	public Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError {
		// If has no arguments, throw exception
		if (args.size() < 2) {
			throw new ArgumentError(argumentFormatMsg);
		}

		// Get path of the to-create item
		String path = "";

		for (int i = 1; i < args.size(); i++) {
			path += args.get(i) + " ";
		}

		path = path.trim();

		// Determine if the path/target already exists
		File target = new File(path);
		if (!target.isAbsolute()) {
			target = new File(State.cwd, path);
		}

		if (target.exists()) {
			throw new CommandFailed(path + " already exists");
		}

		// Create the target
		try {
			switch (args.get(0).toLowerCase()) {
				// If creating a directory
				case "dir":
					// Create folder and check it succeeded
					if (!target.mkdirs()) {
						throw new CommandFailed("Could not create folder " + path);
					}

					break;
					
				case "file":
					try {
						// Try to create file and check if created
						if (!target.createNewFile()) {
							throw new CommandFailed("Could not create file at " + path);
						}
					} catch (IOException err) {
						// If can't create, then throw error
						throw new CommandFailed("Could not create file at " + path + ":\n\t" + err.getMessage());
					}

					break;
					
				default:
					throw new ArgumentError(argumentFormatMsg);
			}
		} catch (IndexOutOfBoundsException err) {
			// If failed to parse arguments, raise exception
			throw new ArgumentError(argumentFormatMsg);
		}

		// Return successful creation
		return new Result(0, "Successfully created " + path);
	}
}
