package dispatcher;

import parser.CommandHandler;
import parser.ParsedCommand;
import service.AdvanceRestaurantService;

import java.util.HashMap;
import java.util.Map;

public class AdvanceDispatcher {
    private final Map<String, CommandHandler> options = new HashMap<>();


    public AdvanceDispatcher() {
        AdvanceRestaurantService rs = new AdvanceRestaurantService();

        this.options.put("add", rs::addRestaurant);
        this.options.put("del", rs::deleteRestaurant);
        this.options.put("rate", rs::rateRestaurant);
        this.options.put("tp", rs::topPicksByCuisine);
        this.options.put("ls", rs::listAllRestaurants);
        this.options.put("help", rs::listAllAvailableCommands);
    }

    public void dispatch(ParsedCommand command) {
        if (this.options.containsKey(command.getAction()))
            try {
                this.options.get(command.getAction()).handle(command.getArgs());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        else
            System.out.println("Invalid option");
    }
}
