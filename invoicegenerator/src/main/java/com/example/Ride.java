package com.example;

public class Ride {
    private double distance;
    private double time;
    private double fare;
    private RiderType riderType;

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Ride(double distance, double time, RiderType riderType) {
        this.distance = distance;
        this.time = time;
        this.riderType = riderType;
        this.fare = 0;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public double getFare() {
        return fare;
    }

    public RiderType getRiderType() {
        return riderType;
    }

    @Override
    public String toString() {
        return "Ride --> distance: " + distance + ", time: " + time + ", RiderType: " + riderType + ", fare: " + fare;
    }
}
