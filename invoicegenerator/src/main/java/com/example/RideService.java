package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideService {
    private Map<String, List<Ride>> userRides;

    public RideService() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, List<Ride> rides) {
        userRides.put(userId, rides);
    }

    public List<Ride> getRides(String userId) {
        return userRides.get(userId);
    }

}
