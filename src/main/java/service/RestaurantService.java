package service;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import models.Restaurant;
import repo.Repo;
import util.RMath;
import util.ScannerWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RestaurantService {
    Repo repo = new Repo("db.json");

    public void addRestaurant() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Restaurant Name: ");
        String name = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Cuisine: ");
        String cuisine = scanner.nextLine();

        Restaurant r = new Restaurant(name, location, cuisine, new ArrayList<>(), new Date(), new Date());
        r.setId(repo.getLastObjectId() + 1);

        repo.add(r);
        repo.save();
    }
    public void rateRestaurant() {
        ScannerWrapper scanner = new ScannerWrapper(System.in);

        render(repo.getAll());

        System.out.println("Select a restaurant by ID: ");
        int id = scanner.nextInt();

        Restaurant restaurant = repo.get(id);

        if (restaurant == null) {
            System.out.println("No restaurant matches the given ID");
            return;
        } else {
            System.out.println(restaurant);
        }

        int rating;
        do {
            System.out.println("Enter a rating (1 - 5): ");
            rating = scanner.nextInt();
        } while (rating < 1 || rating > 5);

        restaurant.setRatings(rating);
        repo.save();
        System.out.println(restaurant + " rated successfully!");
    }

    public void topPicksByCuisine() {
    }

    public void render(ArrayList<Restaurant> rs) {
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
