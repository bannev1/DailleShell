package exceptions;

public class ExitProgram extends Exception {
	public ExitProgram(String message) {
		super(message);
	}

	public ExitProgram() {
		super();
	}
}
