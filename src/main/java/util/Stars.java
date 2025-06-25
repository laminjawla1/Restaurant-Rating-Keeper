package util;

public class Stars {
    public static String stars(double averageRating) {
        int end = (int) averageRating;
        return "*".repeat(end) + "-".repeat(5 - end);
    }
}
