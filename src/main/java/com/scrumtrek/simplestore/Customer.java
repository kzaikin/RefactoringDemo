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

            switch (rental.getMovie().getPriceCode()) {
                case REGULAR:
                    amount += 2;
                    if (rental.getDaysRented() > 2) {
                        amount += (rental.getDaysRented() - 2) * 1.5;
                    }
                    break;

                case NEW_RELEASE:
                    amount += rental.getDaysRented() * 3;
                    break;

                case CHILDREN:
                    amount += getChildrenAmount(rental.getDaysRented());
                    break;
            }

            frequentRenterPoints++;

            // Add bonus for a two-day new-release rental
            if ((rental.getMovie().getPriceCode() == PriceCodes.NEW_RELEASE) && (rental.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            result += "\t" + rental.getMovie().getTitle() + "\t" + amount + "\n";
            total += amount;
        }

        result += "Amount owed is " + total + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points.";
        return result;
    }

    static double getChildrenAmount(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result = (daysRented - 3) * 1.5;
        }
        return result;
    }
}

