/**
 * This program is designed to store configurations for the shell
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

public class Config {
	// Basic configuration
	public static String prompt = "> ";
	public static String continueCmd = " >   ";
	public static String exitMessage = "Exiting...";
	
	public static boolean debug = true;
	
	// Errors
	public static String commandNotFound = "ERR: Command Not Found";
	public static String syntaxError = "ERR: Syntax Error";
	public static String argumentError = "ERR: Incorrect Command Argument Structure";
	public static String commandFailed = "ERR: Command Execution Failed";
	public static String genericError = "ERR";
}
