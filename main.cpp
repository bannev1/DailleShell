#include <iostream>
#include <string>

/**
 * This program is designed to run the code required to execute Daille Shell
 *
 * Purdue University -- Daille Shell
 *
 * @author Valentina Banner
 */

using namespace std;

// Store configuration for shell
struct Config {
	string prompt = "> ";
	string exitMsg = "Exiting...";
};


int main(int argc, char **argv) {
	Config config;  // Access configuration

	string line;  // Stores commands

	// Main loop which processes inputs
	while (true) {
		// Print main pre-command
		cout << config.prompt << flush;

		// Get command, if fail then exit
		if (!getline(cin, line)) {
			cout << config.exitMsg;
			break;
		}
	}
}