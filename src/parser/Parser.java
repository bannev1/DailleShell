package parser;

import java.util.ArrayList;

import exceptions.SyntaxError;
import parser.nodes.Node;
import parser.nodes.CommandNode;
import tokens.Token;

/**
 * This program parses the tokenized text and calls upon the correct command
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class Parser {
	private ArrayList<Token> tokens;
	private int index = 0;

	public Parser(ArrayList<Token> tokens) {
		this.tokens = tokens;
	}


	// Converts a single list of tokens (stops at the first semicolon) into an AST
	// Returns the node containing the Abstract Syntax Tree (AST)
	public Node parse() throws SyntaxError {
		// Ensure no semicolon
		if (isOperator(Token.Type.SEMICOLON)) {
			index++;
		}

		// Parse into tree
		Node tree = parseOperators();

		return tree;
	}


	// Returns if the token at index is the specified operator
	private boolean isOperator(Token.Type type) {
		return tokens.get(index).type() == type;
	}


	// Parse commands from tokens at index
	private Node parseCommand() throws SyntaxError {
		ArrayList<Token> command = new ArrayList<>();
		
		// While currently on WORD, add to command
		while (index < tokens.size() && isOperator(Token.Type.WORD)) {
			command.add(tokens.get(index));
			index++;
		}

		// If no WORD tokens meaning no commands, throw syntax error
		if (command.size() == 0) {
			throw new SyntaxError("Missing command in-between operators");
		}

		// Create CommandNode out of command
		CommandNode cmdNode = new CommandNode();
		cmdNode.value = command;

		return cmdNode;
	}

	// Parse operators and create node
	private Node parseOperators() throws SyntaxError {
		// Get command first
		Node left = parseCommand();

		// Determine if operators need parsing
		if (index >= tokens.size()) {
			return left;
		}

		// While on an operator (that's not a semicolon)
		while (index < tokens.size() && (!isOperator(Token.Type.WORD)) && (!isOperator(Token.Type.SEMICOLON))) {
			Token.Type operator = tokens.get(index).type();
			index++;

			// Get the commands after operator
			Node right = parseCommand();

			// Combine both current left and right nodes
			Node parent = new Node();
			parent.value = operator;
			parent.leftNode = left;
			parent.rightNode = right;

			// Allow next operator to add to the parent node
			left = parent;
		}

		return left;
	}
}
