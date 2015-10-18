package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTests {
    @Test
    public void customerStatementEqualsReferenceValue() {
        // Create movies
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

        // Create customers
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Customer custDonaldDuck = new Customer("Donald Duck");
        Customer custMinnieMouse = new Customer("Minnie Mouse");

        // Create rentals
        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        // Assign rentals to customers
        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        // Generate invoice
        String statement = custMickeyMouse.Statement();

        Assert.assertEquals("Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "\tStar Wars\t6.5\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 24.5\n" +
                "You earned 4 frequent renter points.", statement);
    }
}

