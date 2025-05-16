package util;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWrapper {
    Scanner scanner;
    public ScannerWrapper(InputStream is) {
        scanner = new Scanner(is);
    }

    public int nextInt() {
        while (true) {
            try {
                System.out.print("$ ");
                return Integer.parseInt(this.scanner.nextLine());
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    public void close() {
        this.scanner.close();
    }
}
