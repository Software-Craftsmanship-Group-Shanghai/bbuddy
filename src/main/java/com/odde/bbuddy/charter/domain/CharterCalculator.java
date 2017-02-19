package com.odde.bbuddy.charter.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharterCalculator {
    private final CarConfigRepository carConfigRepository;

    @Autowired
    public CharterCalculator(CarConfigRepository carConfigRepository) {

        this.carConfigRepository = carConfigRepository;
    }

    public int calculate() {
        return carConfigRepository.findAll().get(0).getCarFee()
                + carConfigRepository.findAll().get(0).getServiceFee()
                + carConfigRepository.findAll().get(0).getDriveAloneFee();
    }
}
