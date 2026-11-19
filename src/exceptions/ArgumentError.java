package exceptions;

public class ArgumentError extends Exception {
	public ArgumentError(String message) {
		super(message);
	}

	public ArgumentError() {
		super();
	}
}
