package util;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerWrapper {
    Scanner scanner;
    public ScannerWrapper(InputStream is) {
        scanner = new Scanner(is);
    }

    public int nextInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return this.scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    public void close() {
        this.scanner.close();
    }
}
