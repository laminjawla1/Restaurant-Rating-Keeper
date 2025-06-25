package service;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import models.Restaurant;
import repository.Repo;
import util.Tabulate;

import java.util.*;
import java.util.stream.Collectors;

public class AdvanceRestaurantService {
    Repo repo = new Repo("db.json");

    public void addRestaurant(List<String> args) throws Exception {
        if (args.size() != 3) {
            throw new Exception("Args must be 3: <Name>, <Location> and <Cuisine>");
        }

        String name = args.getFirst();
        String location = args.get(1);
        String cuisine = args.getLast();

        Restaurant r = new Restaurant(name, location, cuisine, new ArrayList<>(), new Date(), new Date());
        r.setId(repo.getLastObjectId() + 1);

        repo.add(r);
        repo.save();
    }

    public void rateRestaurant(List<String> args) throws Exception {
        if (args.size() != 2) {
            throw new Exception("Args must be 2: <id> and <value  1 to 5>");
        }
        int id;
        try {
            id = Integer.parseInt(args.getFirst());
        } catch (NumberFormatException e) {
            System.out.println("Restaurant id must be a integer");
            return;
        }

        Restaurant restaurant = repo.get(id);

        if (restaurant == null) {
            System.out.println("No restaurant matches the given ID");
            return;
        }

        int rating;
        try {
            rating = Integer.parseInt(args.getLast());
            if (rating < 1 || rating > 5) {
                System.out.println("Rating value must be between 1 to 5");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Rating value must be an integer");
            return;
        }

        restaurant.setRatings(rating);
        repo.save();
        System.out.println(restaurant + " rated successfully!");
    }

    public void listAllRestaurants(List<String> args) {
        if (!args.isEmpty()) {
            final String keyword = args.getFirst().toLowerCase();
            Tabulate.tabulate((ArrayList<Restaurant>) repo.getAll().stream().filter(
                    r -> r.getName().toLowerCase().contains(keyword) ||
                            r.getCuisine().toLowerCase().contains(keyword) ||
                            r.getLocation().toLowerCase().contains(keyword))
            .collect(Collectors.toList()));
        } else {
            Tabulate.tabulate(repo.getAll());
        }
    }

    public void topPicksByCuisine(List<String> args) throws Exception {
        if (args.size() != 1) {
            throw new Exception("Args must be 1: <Cuisine>");
        }

        String cuisine = args.getFirst();
        Tabulate.tabulate(repo.orderByAVGRating(repo.getByCuisine(cuisine)));
    }

    public void listAllAvailableCommands(List<String> args) {
        AsciiTable at = new AsciiTable();

        at.addRule();
        at.addRow("COMMAND", "ARGS", "Description");

        at.addRule();
        at.addRow("add", "Restaurant name, location and cuisine", "Creates a new restaurant");
        at.addRule();
        at.addRow("del", "Restaurant ID", "Deletes a restaurant that matches with the given ID");
        at.addRule();
        at.addRow("ls", "No args", "Display all restaurants in formatted ascii table");
        at.addRule();
        at.addRow("rate", "Restaurant ID and rating value (int)", "Rates a restaurant");
        at.addRule();
        at.addRow("tp", "Cuisine", "List top picks by cuisine and order them by average rating in desc");

        at.addRule();
        at.getRenderer().setCWC(new CWC_LongestLine());

        System.out.println(at.render());
    }

    public void deleteRestaurant(List<String> args) throws Exception {
        if (args.size() != 1) {
            throw new Exception("Args must be 1: <Restaurant ID>");
        }
        try {
            repo.deleteById(Integer.parseInt(args.getFirst()));
            System.out.println("Restaurant successfully deleted");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Restaurant ID must be an Integer");
        }
    }
}
