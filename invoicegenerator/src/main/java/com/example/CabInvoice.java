package com.example;

import java.util.List;

public class CabInvoice {
    private static double FARE_PER_KM = 10.0;
    private static double FARE_PER_MINUTE = 1.0;
    private static double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, double time) {
        return Math.max(MINIMUM_FARE, ((distance * FARE_PER_KM) + (time * FARE_PER_MINUTE)));
    }

    public Invoice generateInvoiceForUserRides(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            ride.setFare(calculateFare(ride.getDistance(), ride.getTime()));
            totalFare += ride.getFare();
            System.out.println(ride);
        }

        return new Invoice(rides.size(), totalFare, totalFare / rides.size());
    }
}