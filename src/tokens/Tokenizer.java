package tokens;

import java.util.ArrayList;

/**
 * This program helps convert plain text into tokens
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class Tokenizer {
	// Final tokenized array
	public ArrayList<Token> tokenizedArray = new ArrayList<>();  // Stores tokenized
	
	// Amount of semicolons in command (i.e, amount of commands)
	private int semicolonAmt = 0;

	// Given text, converts into a list of tokens
	// Adds new commands to old tokenizedArray
	// Returns whether or not a semicolon was entered
	// If there was a semicolon, it returns true
	public boolean tokenize(String line) {
		String prev = "";

		// Add whitespace to line so last word gets considered
		line += " ";

		// If there was a semicolon
		boolean ifSemicolon = false;

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

						tokenizedArray.add(word);
					}

					tokenizedArray.add(new Token(Token.Type.AND, "&"));
					break;

				// OR
				case '?':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						prev = "";  // Reset

						tokenizedArray.add(word);
					}

					tokenizedArray.add(new Token(Token.Type.OR, "?"));
					break;
					
				// SEMICOLON
				case ';':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						prev = "";  // Reset
						
						tokenizedArray.add(word);
					}
					
					ifSemicolon = true;
					semicolonAmt++;
					tokenizedArray.add(new Token(Token.Type.SEMICOLON, ";"));
					break;

				// WORD / Whitespace
				case ' ':
					// If there exists word stored in prev
					if (prev.length() > 0) {
						// Create new token with word
						Token word = new Token(Token.Type.WORD, prev);
						
						tokenizedArray.add(word);
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

		return ifSemicolon;
	}


	// Clear the last command (before first semicolon)
	// Returns that command as an ArrayList<Token>
	public ArrayList<Token> clearPreviousCommand() {
		ArrayList<Token> prevCommand = new ArrayList<>();

		// While haven't yet reached semicolon or end of ArrayList
		while (tokenizedArray.size() != 0) {
			// Determine if hit semicolon, so can end
			if (tokenizedArray.get(0).type() == Token.Type.SEMICOLON) {
				tokenizedArray.remove(0);
				semicolonAmt--;
				break;
			}
			
			prevCommand.add(tokenizedArray.get(0));
			tokenizedArray.remove(0);
		}

		return prevCommand;
	}


	// Determine if there's still a semicolon
	public boolean hasSemicolon() {
		return semicolonAmt > 0;
	}
}
