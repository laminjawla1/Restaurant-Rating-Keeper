package util;

import java.util.ArrayList;


public class RMath {
    public static double average(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) return 0;
        return sum(numbers) / numbers.size();
    }

    public static double sum(ArrayList<Integer> numbers) {
        double total = 0;
        for (int n: numbers)
            total += n;
        return total;
    }
}
