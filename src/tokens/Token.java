package tokens;

/**
 * This program represents what the Token looks like
 * Each token represents keywords, operators or identifiers
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public record Token(Type type, String text) {
	// Different types of commands
	public enum Type {
		WORD,  // Command names, flags, filenames, arguments
		SEMICOLON,
		AND,
		OR
	}
}
