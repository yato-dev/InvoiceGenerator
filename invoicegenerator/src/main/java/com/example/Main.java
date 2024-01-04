package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        InvoiceService invoiceService = new InvoiceService(rideService);

        rideService.addRides("User1",
                Arrays.asList(
                        new Ride(2.5, 10),
                        new Ride(3, 5),
                        new Ride(0.1, 1)));

        Invoice invoiceUser1 = invoiceService.getUserInvoice("User1");
        System.out.println(invoiceUser1);
    }
}
