package com.odde.bbuddy.charter.domain;

import com.odde.bbuddy.charter.repo.CarConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharterCalculator {
    private final CarConfigRepository carConfigRepository;
    private final DriverVendor driverVendor;

    @Autowired
    public CharterCalculator(CarConfigRepository carConfigRepository, DriverVendor driverVendor) {
        this.carConfigRepository = carConfigRepository;
        this.driverVendor = driverVendor;
    }

    public int calculate(Trip trip) {
        CarConfig carConfig = carConfigRepository.findAll().get(0);
        return carConfig.getCarFee()
                + carConfig.getServiceFee()
                + driverVendor.findDriver(trip).getFee();
    }

}
