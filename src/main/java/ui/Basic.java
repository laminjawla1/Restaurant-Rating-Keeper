package ui;

import dispatcher.Dispatcher;
import util.ScannerWrapper;

import java.util.Scanner;

public class Basic {
    public static void run() {
        ScannerWrapper scanner = new ScannerWrapper(System.in);
        Dispatcher dispatcher = new Dispatcher();
        System.out.println("WELCOME! You are using the Basic User Interface");
        while (true) {
            System.out.println("1. Add Restaurant\n2. Rate Restaurant\n3. List top picks by cuisine\n0. Exit");
            System.out.print("\n$ ");

            int option = scanner.nextInt("Enter a number: ");

            // If user wants to quit the program
            if (option == 0) {
                System.out.println("Thanks for visiting 'Restaurant Rating Keeper'");
                scanner.close();
                System.exit(0);
            }
            dispatcher.dispatch(option);
        }
    }
}
