package com.scrumtrek.simplestore;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getPoints(int daysRented) {
        // Add bonus for a two-day new-release rental
        if (daysRented > 1) {
            return 1;
        }
        return 0;
    }

}
