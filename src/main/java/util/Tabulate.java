package util;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import models.Restaurant;

import java.util.ArrayList;

public class Tabulate {
    public static void tabulate(ArrayList<Restaurant> rs) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("ID", "NAME", "CUISINE", "LOCATION", "AVERAGE RATING", "Stars");
        at.addRule();
        for (Restaurant r: rs) {
            double averageRating = RMath.average(r.getRatings());
            at.addRow(
                r.getId(), r.getName(), r.getCuisine(), r.getLocation(), averageRating, Stars.stars(averageRating)
            );
        }
        at.addRule();
        at.getRenderer().setCWC(new CWC_LongestLine());
        System.out.println(at.render());
    }
}
