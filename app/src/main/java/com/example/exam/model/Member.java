package com.example.exam.model;

public class Member {
    private String Restaurant;
    private double price;
    private int rating;
    private int profile;

    public Member(String restaurant, double price, int rating, int profile) {
        Restaurant = restaurant;
        this.price = price;
        this.rating = rating;
        this.profile = profile;
    }

    public Member() {
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String restaurant) {
        Restaurant = restaurant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
