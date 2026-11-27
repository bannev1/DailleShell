package parser.nodes;

import tokens.Token;

/**
 * This class represents a binary tree Node
 * It contains a reference to its left and right node
 * This is used to represent syntax, representing the Abstract Syntax Tree
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class Node {
	public Token.Type value;
	public Node leftNode;
	public Node rightNode;
}
