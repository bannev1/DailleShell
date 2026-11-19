package executor;

import java.util.ArrayList;

import exceptions.ArgumentError;
import exceptions.CommandFailed;
import exceptions.CommandNotFoundError;
import exceptions.SyntaxError;
import executor.commands.Registry;
import executor.commands.Result;
import parser.nodes.Node;
import parser.nodes.CommandNode;
import tokens.Token;

public class Executor {
	private Node tree;

	public Executor(Node tree) {
		this.tree = tree;
	}

	// What executes the given Abstract Syntax Tree
	public void execute() throws SyntaxError, CommandNotFoundError, CommandFailed, ArgumentError {
		// Execute program
		executeRecursively(tree);
	}

	// A recursive helper method for execute()
	// It recursively executes each operator
	private Result executeRecursively(Node currNode) throws SyntaxError, CommandNotFoundError, CommandFailed, ArgumentError {
		// If null, raise error
		if (currNode == null) {
			throw new SyntaxError("Missing executable command");
		}
		
		// If just a command
		if (currNode instanceof CommandNode) {
			Result result = executeCommands((CommandNode) currNode);
			
			// Output result
			if (result != null && result.output() != null) {
				IO.println(result.output());
			}
			
			return result;
		}

		Result left;
		Result right;

		// Else if need to parse a tree
		switch (currNode.value) {
			// If hit semicolon
			case Token.Type.SEMICOLON:
				return new Result(0, null);

			// If hit AND
			case Token.Type.AND:
				try {
					left = executeRecursively(currNode.leftNode);
				// If execution failed, consider as boolean false
				} catch (SyntaxError | CommandNotFoundError | CommandFailed err) {
					left = new Result(-1, err.getMessage());
				}
			
				// If left succeded, run right as well
				if (left.execResult() != 0) {
					return left;
				} else {
					try {
						right = executeRecursively(currNode.rightNode);
					// If execution failed, consider as boolean false
					} catch (SyntaxError | CommandNotFoundError | CommandFailed err) {
						right = new Result(-1, err.getMessage());
					}

					return right;
				}

			// If hit OR
			case Token.Type.OR:
				try {
					left = executeRecursively(currNode.leftNode);
				// If execution failed, consider as boolean false
				} catch (SyntaxError | CommandNotFoundError | CommandFailed err) {
					left = new Result(-1, err.getMessage());
				}
			
				// If left succeeded, just return left
				if (left.execResult() == 0) {
					return left;
				} else {
					try {
						right = executeRecursively(currNode.rightNode);
					// If execution failed, consider as boolean false
					} catch (SyntaxError | CommandNotFoundError | CommandFailed err) {
						right = new Result(-1, err.getMessage());
					}

					return right;
				}
			
			// Otherwise throw error
			default:
				throw new SyntaxError("Operator processing resulted in logic error. Unrecognized operator `" + currNode.value.toString() + "`");
		}
	}

	// What executes CommandNode code
	private Result executeCommands(CommandNode cmdNode) throws SyntaxError, CommandNotFoundError, CommandFailed, ArgumentError {
		ArrayList<Token> command = cmdNode.value;

		// Make sure at least one command
		if (command.size() == 0) {
			throw new SyntaxError("Commands Missing");
		}

		// Get keyword of command
		String keyword = command.get(0).text();

		// Get arguments following command
		ArrayList<String> arguments = new ArrayList<>();

		for (int i = 1; i < command.size(); i++) {
			arguments.add(command.get(i).text());
		}

		// Execute Registry
		return Registry.run(keyword, arguments);
	}

}
