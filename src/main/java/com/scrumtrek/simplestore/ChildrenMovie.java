package com.scrumtrek.simplestore;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title, PriceCodes.CHILDREN);
    }

    @Override
    public double getAmount(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result = (daysRented - 3) * 1.5;
        }
        return result;
    }

}
