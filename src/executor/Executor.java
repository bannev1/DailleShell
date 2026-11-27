package executor;

import java.util.ArrayList;

import exceptions.CommandNotFoundError;
import exceptions.SyntaxError;
import executor.commands.Registry;
import parser.nodes.Node;
import parser.nodes.CommandNode;
import tokens.Token;


public class Executor {
	private Node tree;

	public Executor(Node tree) {
		this.tree = tree;
	}

	
	// What executes the given Abstract Syntax Tree
	public void execute() throws SyntaxError, CommandNotFoundError {
		// Execute program
		String result = executeRecursively(tree);

		// Output result
		IO.println(result);
	}

	// A recursive helper method for execute()
	// It recursively executes each operator
	private String executeRecursively(Node currNode) throws SyntaxError, CommandNotFoundError {
		// If just a command
		if (tree instanceof CommandNode) {
			return executeCommands((CommandNode) tree);
		}
		
		// If hit semicolon
		if (tree.value == Token.Type.SEMICOLON) {
			return null;
		}

		// If is AND or OR, meaning boolean operation
		else if (tree.value == Token.Type.AND || tree.value == Token.Type.OR) {
			boolean result = executeBooleanOperators(tree);

			// Return string equivalent
			return String.valueOf(result);
		} 
		
		// If not just AND or OR, then throw unrecognized operator
		else {
			throw new SyntaxError("Unrecognized operator `" + tree.value.toString() + "`");
		}
	}


	// Helper method which recursively executes boolean operators (AND/OR)
	// Added name `bool` to allow for different operators which don't deal with boolean operations
	private boolean executeBooleanOperators(Node currNode) throws SyntaxError, CommandNotFoundError {
		// If it's a command, execute the CommandNode
		if (currNode instanceof CommandNode) {
			// Execute command
			String result = executeCommands((CommandNode) currNode);

			// If resulted in integer, convert to boolean
			try {
				int intResult = Integer.parseInt(result);
				// As 0 means success, only when the result is 0 does this mean it works
				return intResult == 0;
			} catch (NumberFormatException err) {
				// Otherwise just convert to basic boolean
				return Boolean.parseBoolean(result);
			}
		}

		// Otherwise execute left and right appropriately
		Boolean left = false;
		Boolean right = false;

		if (currNode.leftNode != null) {
			String leftResult = executeRecursively(currNode.leftNode);

			// If resulted in integer, convert to boolean
			try {
				int leftInt = Integer.parseInt(leftResult);
				// As 0 means success, only when the result is 0 does this mean it works
				left = leftInt == 0;
			} catch (NumberFormatException err) {
				// Otherwise just convert to basic boolean
				left = Boolean.parseBoolean(leftResult);
			}
		}

		if (currNode.rightNode != null) {
			String rightResult = executeRecursively(currNode.rightNode);

			// If resulted in integer, convert to boolean
			try {
				int rightInt = Integer.parseInt(rightResult);
				// As 0 means success, only when the result is 0 does this mean it works
				right = rightInt == 0;
			} catch (NumberFormatException err) {
				// Otherwise just convert to basic boolean
				right = Boolean.parseBoolean(rightResult);
			}
		}

		// Determine and apply correct boolean operator
		if (currNode.value == Token.Type.AND) {
			return left && right;
		}

		if (currNode.value == Token.Type.OR) {
			return left || right;
		}

		// Otherwise throw syntax error
		throw new SyntaxError("Boolean operator not recognized");
	}


	// What executes CommandNode code
	private String executeCommands(CommandNode cmdNode) throws SyntaxError, CommandNotFoundError {
		ArrayList<Token> command = cmdNode.value;

		// Make sure at least one command
		if (command.size() == 0) {
			throw new SyntaxError("Commands Missing");
		}

		// Get keyword of command
		String keyword = command.get(0).text();

		command.remove(0);  // Remove keyword for parsing

		ArrayList<String> arguments = new ArrayList<>();

		for (Token token : command) {
			arguments.add(token.text());
		}

		// Execute Registry
		return Registry.run(keyword, arguments);
	}

}
