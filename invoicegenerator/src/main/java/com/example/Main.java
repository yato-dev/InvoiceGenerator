package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        InvoiceService invoiceService = new InvoiceService(rideService);

        rideService.addRides("User1",
                Arrays.asList(
                        new Ride(2.5, 10, RiderType.NORMAL),
                        new Ride(3, 5, RiderType.PREMIUM),
                        new Ride(0.1, 1, RiderType.NORMAL)));

        Invoice invoiceUser1 = invoiceService.getUserInvoice("User1");
        System.out.println(invoiceUser1);
    }
}
