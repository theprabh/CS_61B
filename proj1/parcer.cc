#include <stdio.h>
using namespace std;

int main() {
	bool exit = false;
	string command, second, third, fourth, fifth;
	
	while(exit == false) {
		cout << "Please enter a command: ";
		cin >> command >> second >> third >> fourth >> fifth;
		
		switch(command) {
			case "exit" :
				exit = true;
				break;
			case "ls" :
				cout << "Command: ls\n"
		}
		
		switch(second) {
			case "-la" :
				cout << "Options: -la\n";
				break;
			case "<" :
				cout << "File Redirection: >\n";
				break;
			case "|" :
				cout << "Pipe\n";
				break;
			default :
				cout << " ";
		}
		
		switch(third) {
			case "./cs3376" :
				cout << "Arguments: ./cs3376\n";
				break;
			case "junk.txt" :
				cout << "File: junk.txt\n";
				break;
			case "wc" :
				cout << "Command: wc\n";
				break;
			case "sort" :
				cout << "Command: sort\n";
				break;
			default :
				cout << " ";
		}
		
		switch(fourth) {
			case ">" :
				cout << "File Redirection: >\n";
				break;
			case "|" :
				cout << "Pipe\n";
				break;
			default :
				cout << " ";
		}
		
		switch(fifth) {
			case "output.txt" :
				cout << "File: output.txt\n";
				break;
			case "wc" :
				cout << "Command: wc\n";
				break;
			default :
				cout << " ";
		}
	}
	return 0;
}