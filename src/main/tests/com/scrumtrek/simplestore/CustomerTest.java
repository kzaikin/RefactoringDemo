package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    private static final double EPSILON = 1e-4;

    @Test
    public void customerStatementEqualsReferenceValue() {
        Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDREN);
        Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);
        Movie movGladiator = new Movie("Gladiator", PriceCodes.NEW_RELEASE);

        Customer custMickeyMouse = new Customer("Mickey Mouse");

        Rental rental1 = new Rental(movCinderella, 5);
        Rental rental2 = new Rental(movStarWars, 5);
        Rental rental3 = new Rental(movGladiator, 5);

        custMickeyMouse.addRental(rental1);
        custMickeyMouse.addRental(rental2);
        custMickeyMouse.addRental(rental3);

        String statement = custMickeyMouse.getStatement();

        Assert.assertEquals("Rental record for Mickey Mouse\n" +
                "\tCinderella\t3.0\n" +
                "\tStar Wars\t6.5\n" +
                "\tGladiator\t15.0\n" +
                "Amount owed is 24.5\n" +
                "You earned 4 frequent renter points.", statement);
    }

    @Test
    public void childrenPricingOver3Days() {
        double amount = Customer.getChildrenAmount(5);
        Assert.assertEquals(3d, amount, EPSILON);
    }

    @Test
    public void childrenPricing3OrLessDays() {
        double amount = Customer.getChildrenAmount(3);
        Assert.assertEquals(1.5d, amount, EPSILON);
    }

    @Test
    public void newRelease3DayPricing() {
        int amount = Customer.getNewReleaseAmount(5);
        Assert.assertEquals(15, amount);
    }
}

