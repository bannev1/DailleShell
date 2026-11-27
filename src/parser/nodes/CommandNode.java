package parser.nodes;

import java.util.ArrayList;
import tokens.Token;

/**
 * This class represents a binary tree Node except for a command
 * It is almost exactly like its parent class, Node
 * Its `token` instead represents a command/list of WORD tokens
 * 
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class CommandNode extends Node {
	public ArrayList<Token> value;
}
