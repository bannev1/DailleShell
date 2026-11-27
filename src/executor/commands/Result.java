package executor.commands;

public record Result(
		// Result of execution
		// 0 = success
		int execResult,

		// Output of execution
		// Can be null
		String output) {
}
