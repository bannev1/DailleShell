package executor.commands;

import java.util.ArrayList;
import exceptions.ArgumentError;
import exceptions.CommandFailed;
import exceptions.ExitProgram;
import exceptions.SyntaxError;

public class Exit extends Command {

	@Override
	public String keyword() {
		return "exit";
	}

	@Override
	public Result run(ArrayList<String> args) throws SyntaxError, CommandFailed, ArgumentError, ExitProgram {
		throw new ExitProgram();
	}
	
}
