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

int main(int argc, char **argv) {
	string line;  // Stores commands

	// Main loop which processes inputs
	while (true) {
		// Print main pre-command
		cout << "> " << flush;

		// Get command, if fail then exit
		if (!getline(cin, line)) {
			cout << "Exiting...";
			break;
		}
	}
}