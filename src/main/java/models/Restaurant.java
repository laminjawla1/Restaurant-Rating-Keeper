package models;

import java.util.ArrayList;
import java.util.Date;

public class Restaurant {
    private int id;
    private String name;
    private String location;
    private String cuisine;
    private ArrayList<Integer> ratings = new ArrayList<>();
    Date createdAt;
    Date updatedAt;

    public Restaurant() {}

    public Restaurant(
            String name, String location, String cuisine, ArrayList<Integer> ratings, Date createdAt, Date updatedAt) {
        this.name = name;
        this.location = location;
        this.cuisine = cuisine;
        this.ratings = ratings;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(int rating) {
        this.ratings.add(rating);
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
