package com.scrumtrek.simplestore;

public abstract class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getAmount(int daysRented);

    public abstract int getPoints(int daysRented);
}

