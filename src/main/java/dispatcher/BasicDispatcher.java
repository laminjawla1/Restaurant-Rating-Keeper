package dispatcher;

import service.RestaurantService;

import java.util.HashMap;
public class BasicDispatcher {
    private final HashMap<Integer, Runnable> options;

    public BasicDispatcher() {
        this.options = new HashMap<>();
        RestaurantService rs = new RestaurantService();

        this.options.put(1, rs::addRestaurant);
        this.options.put(2, rs::rateRestaurant);
        this.options.put(3, rs::topPicksByCuisine);
        this.options.put(4, rs::listAllRestaurants);
    }


    public void dispatch(int option) {
        if (this.options.containsKey(option))
            this.options.get(option).run();
        else
            System.out.println("Invalid option");
    }
}
