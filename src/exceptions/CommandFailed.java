package exceptions;

public class CommandFailed extends Exception {
	public CommandFailed(String message) {
		super(message);
	}

	public CommandFailed() {
		super();
	}
}
