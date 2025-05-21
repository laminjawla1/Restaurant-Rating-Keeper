package util;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import models.Restaurant;

import java.util.ArrayList;

public class Tabulate {
    public static void tabulate(ArrayList<Restaurant> rs) {
        AsciiTable at = new AsciiTable();
        at.getContext().setWidth(50);
        at.addRule();
        at.addRow("ID", "NANE", "CUISINE", "LOCATION", "AVERAGE RATING");
        at.addRule();
        for (Restaurant r: rs)
            at.addRow(r.getId(), r.getName(), r.getCuisine(), r.getLocation(), RMath.average(r.getRatings()));
        at.addRule();
        at.getRenderer().setCWC(new CWC_LongestLine());
        String output = at.render();
        System.out.println(output);
    }
}
