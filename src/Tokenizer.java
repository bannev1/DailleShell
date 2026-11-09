import java.util.ArrayList;
import exceptions.SyntaxError;

/**
 * This program helps convert plain text into tokens
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class Tokenizer {
	// Given text, converts into a list of tokens
	public static ArrayList<Token> tokenize(String line) throws SyntaxError {
		ArrayList<Token> results = new ArrayList<>();  // Stores results
		
		String prev = "";

		// Add whitespace to line so last word gets considered
		line += " ";

		// Go through each character
		for (char currCharacter : line.toCharArray()) {
			switch (currCharacter) {
				// AND
				case '&':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						prev = "";  // Reset

						results.add(word);
					}

					results.add(new Token(Token.Type.AND, "&"));
					break;

				// OR
				case '?':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						prev = "";  // Reset

						results.add(word);
					}

					results.add(new Token(Token.Type.OR, "?"));
					break;
					
					// SEMICOLON
					case ';':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						prev = "";  // Reset
						
						results.add(word);
					}
					
					results.add(new Token(Token.Type.SEMICOLON, ";"));
					break;

				// WORD / Whitespace
				case ' ':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						
						results.add(word);
					}

					prev = "";  // Reset
					break;

				// Not key character or whitespace
				default:
					// Add to store
					prev += String.valueOf(currCharacter);
					break;
			}
		}

		return results;
	}
}
