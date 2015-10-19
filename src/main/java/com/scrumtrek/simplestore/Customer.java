package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getStatement() {
        double total = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + name + "\n";

        for (Rental rental : rentals) {
            double amount = 0;

            amount += rental.getMovie().getAmount(rental.getDaysRented());

            frequentRenterPoints++;

            frequentRenterPoints += rental.getMovie().getPoints(rental.getDaysRented());

            result += "\t" + rental.getMovie().getTitle() + "\t" + amount + "\n";
            total += amount;
        }

        result += "Amount owed is " + total + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }
}

