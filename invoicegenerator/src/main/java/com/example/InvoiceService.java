package com.example;

import java.util.List;

public class InvoiceService {
    RideService rideService;
    CabInvoice cabInvoice;

    public InvoiceService(RideService rideService) {
        this.rideService = rideService;
        this.cabInvoice = new CabInvoice();
    }

    public Invoice getUserInvoice(String userId) {
        List<Ride> rides = this.rideService.getRides(userId);

        if (rides == null || rides.isEmpty()) {
            return null;
        }

        return this.cabInvoice.generateInvoiceForUserRides(rides);
    }

}
