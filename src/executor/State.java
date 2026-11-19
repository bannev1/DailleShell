package executor;

import java.io.File;

/**
 * This class is used to store the current state of the shell
 * It stores variables, the current directory, etc
 * 
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class State {
	// Where the shell 'is' currently
	// Starts where its launched
	public static File cwd = new File(System.getProperty("user.dir"));

	// Returns path of shell
	public static String path() {
		return cwd.getAbsolutePath();
	}
}
