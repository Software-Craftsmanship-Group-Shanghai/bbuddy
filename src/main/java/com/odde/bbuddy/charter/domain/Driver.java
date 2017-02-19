package com.odde.bbuddy.charter.domain;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    private final String location;
    private static final Map<String, Integer> feeMap = new HashMap<String, Integer>() {{
        put("NANJING;SHANGHAI", 50);
        put("SHANGHAI;NANJING", 50);
        put("NANJING;HANGZHOU", 40);
        put("SHANGHAI;HANGZHOU", 40);
    }};

    public Driver(final String location) {
        this.location = location;
    }

    public int getDriveAloneFee(final Trip trip) {
        return singleWayFee(trip.getDestination(), location) + singleWayFee(location, trip.getDeparture());
    }

    private int singleWayFee(final String from, final String to) {
        return feeMap.getOrDefault(feeKey(from, to), 0);
    }

    private String feeKey(final String first, final String second) {
        return String.format("%s;%s", first, second);
    }
}
