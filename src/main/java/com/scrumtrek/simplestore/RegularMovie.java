package com.scrumtrek.simplestore;

import java.math.BigDecimal;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getAmount(int daysRented) {
        BigDecimal result = BigDecimal.valueOf(2);
        if (daysRented > 2) {
            result = result.add(BigDecimal.valueOf((daysRented - 2) * 1.5));
        }
        return result.doubleValue();
    }

    @Override
    public int getPoints(int daysRented) {
        return 0;
    }
}
