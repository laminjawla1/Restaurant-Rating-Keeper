package ui;

import dispatcher.Dispatcher;

import java.util.Scanner;

public class Advance {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("WELCOME! You are using the Advance User Interface");
        while (true) {
            System.out.print("$ ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                // If user wants to quit the program
                if (option == 0) {
                    System.out.println("Thanks for visiting 'Restaurant Rating Keeper'");
                    scanner.close();
                    System.exit(0);
                }
                dispatcher.dispatch(option);
            } catch (NumberFormatException e) {
                System.out.println("Enter a number");
            }
        }
    }
}
