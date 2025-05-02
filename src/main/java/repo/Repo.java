package repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import models.Restaurant;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Repo {
    private final ArrayList<Restaurant> restaurants;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String db;

    public Repo(String db) {
        this.restaurants = this.init();
        this.db = db;
    }

    private ArrayList<Restaurant> init() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("db.json")) {
            Type RT = new TypeToken<ArrayList<Restaurant>>() {}.getType();
            return gson.fromJson(reader, RT);
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        return new ArrayList<>();
    }

    public void save() {
        try (FileWriter writer = new FileWriter(this.db)) {
            gson.toJson(this.restaurants, writer);
            System.out.println("Successfully wrote to " + this.db);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(Restaurant r) {
        restaurants.add(r);
    }

    public int getLastObjectId() {
        try {
            return restaurants.getLast().getId();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public ArrayList<Restaurant> getAll() {
        return this.restaurants;
    }
}
