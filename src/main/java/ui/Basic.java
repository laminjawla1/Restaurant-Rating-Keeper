package ui;

import dispatcher.Dispatcher;
import util.ScannerWrapper;

import static util.Terminal.clearScreen;

public class Basic {
    public static void run() {
        ScannerWrapper scanner = new ScannerWrapper(System.in);
        Dispatcher dispatcher = new Dispatcher();

        clearScreen();
        System.out.println("WELCOME! You are using the Basic User Interface");

        while (true) {
            menu();

            System.out.println("Choose an option: ");
            int option = scanner.nextInt();

            // If user wants to quit the program
            if (option == 0) {
                clearScreen();
                System.out.println("Thanks for visiting 'Restaurant Rating Keeper'");
                scanner.close();
                System.exit(0);
            }
            dispatcher.dispatch(option);
        }
    }

    public static void menu() {
        System.out.println("1. Add Restaurant");
        System.out.println("2. Rate Restaurant");
        System.out.println("3. List top picks by cuisine");
        System.out.println("0. Exit\n");
    }
}
