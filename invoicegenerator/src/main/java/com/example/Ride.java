package com.example;

public class Ride {
    private double distance;
    private double time;
    private double fare;

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
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

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Ride --> distance: " + distance + ", time: " + time + ", fare: " + fare;
    }
}
