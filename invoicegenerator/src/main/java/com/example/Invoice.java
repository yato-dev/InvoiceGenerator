package com.example;

public class Invoice {
    private int totalRides;
    private double totalFare;
    private double averaFare;

    public Invoice(int totalRides, double totalFare, double averaFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averaFare = averaFare;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAveraFare() {
        return averaFare;
    }

    @Override
    public String toString() {
        return "totalRides: " + totalRides + ", totalFare: " + totalFare + ", averaFare: " + averaFare;
    }

}
