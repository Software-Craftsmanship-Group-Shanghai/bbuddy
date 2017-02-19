package com.odde.bbuddy.charter.domain;

import com.odde.bbuddy.charter.repo.CarConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CharterCalculator {
    private final CarConfigRepository carConfigRepository;
    private final DriverVendor driverVendor;

    @Autowired
    public CharterCalculator(final CarConfigRepository carConfigRepository, final DriverVendor driverVendor) {
        this.carConfigRepository = carConfigRepository;
        this.driverVendor = driverVendor;
    }

    public int calculate(Trip trip) {
        List<CarConfig> configs = carConfigRepository.findAll();
        if (configs.isEmpty()) {
            return 9999;
        }
        CarConfig carConfig = configs.get(0);
        return carConfig.getCarFee()
                + carConfig.getServiceFee()
                + driverVendor.findDriver(trip).getDriveAloneFee(trip);
    }

}
