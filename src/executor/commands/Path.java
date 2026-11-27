package executor.commands;

import java.util.ArrayList;
import exceptions.ArgumentError;
import exceptions.SyntaxError;
import executor.State;
import exceptions.CommandFailed;

public class Path extends Command {
	@Override
	public String keyword() {
		return "path";
	}


	@Override
	public Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError {
		// If has arguments, throw exception
		if (args.size() > 0) {
			throw new ArgumentError("Unexpected arguments when no arguments needed");
		}

		// Output current path
		IO.println(State.path());

		return new Result(0, State.path());
	}
}
