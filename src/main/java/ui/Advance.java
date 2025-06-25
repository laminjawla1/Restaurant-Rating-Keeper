package ui;

import dispatcher.AdvanceDispatcher;
import dispatcher.BasicDispatcher;
import parser.CommandParser;

import java.util.Scanner;

public class Advance {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        AdvanceDispatcher dispatcher = new AdvanceDispatcher();

        System.out.println("WELCOME! You are using the Advance User Interface. Type 'help' to get started!");
        while (true) {
            System.out.print("$ ");

            try {
                String command = scanner.nextLine();

                if (command.isBlank()) continue;
                // If user wants to quit the program
                if (command.equals("quit") || command.equals("q") || command.equals("exit")) {
                    System.out.println("Thanks for visiting 'Restaurant Rating Keeper'");
                    scanner.close();
                    System.exit(0);
                }
                dispatcher.dispatch(CommandParser.parseCommand(command));
            } catch (NumberFormatException e) {
                System.out.println("Enter a number");
            }
        }
    }
}
