package com.scrumtrek.simplestore;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title, PriceCodes.NEW_RELEASE);
    }

    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
