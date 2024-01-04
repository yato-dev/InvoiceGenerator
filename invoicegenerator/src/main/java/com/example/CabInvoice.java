package com.example;

import java.util.List;

public class CabInvoice {
    private static double FARE_PER_KM_NORMAL = 10.0;
    private static double FARE_PER_MINUTE_NORMAL = 1.0;
    private static double MINIMUM_FARE_NORMAL = 5.0;

    private static double FARE_PER_KM_PREMIMUM = 15.0;
    private static double FARE_PER_MINUTE_PREMIMUM = 2.0;
    private static double MINIMUM_FARE_PREMIMUM = 20.0;

    public void calculateFare(Ride ride) {
        if (ride.getRiderType() == RiderType.NORMAL)
            ride.setFare(Math.max(MINIMUM_FARE_NORMAL,
                    ((ride.getDistance() * FARE_PER_KM_NORMAL) + (ride.getTime() * FARE_PER_MINUTE_NORMAL))));
        else
            ride.setFare(Math.max(MINIMUM_FARE_PREMIMUM,
                    ((ride.getDistance() * FARE_PER_KM_PREMIMUM) + (ride.getTime() * FARE_PER_MINUTE_PREMIMUM))));
    }

    public Invoice generateInvoiceForUserRides(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            calculateFare(ride);
            totalFare += ride.getFare();
            System.out.println(ride);
        }

        return new Invoice(rides.size(), totalFare, totalFare / rides.size());
    }
}