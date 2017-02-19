package com.odde.bbuddy.charter.domain;

import com.odde.bbuddy.charter.repo.CarConfig;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

public class CharterCalculatorTest {

    private CarConfigRepository carConfigRepository;
    private CarConfig config;
    private CharterCalculator calculator;
    private DriverVendor driverVendor;
    Driver stubDriver = mock(Driver.class);
    Trip stubTrip = mock(Trip.class);

    @Before
    public void setUp() {
        carConfigRepository = mock(CarConfigRepository.class);
        driverVendor = mock(DriverVendor.class);
        config = new CarConfig();
        calculator = new CharterCalculator(carConfigRepository, driverVendor);
    }

    @Test
    public void should_calculate_carFee_serviceFee_and_driverFee() {
        given_car_config(30, 530);
        given_driver_fee(100, stubTrip);

        assertThat(calculator.calculate(stubTrip)).isEqualTo(660);
    }

    private void given_driver_fee(int fee, Trip trip) {
        when(stubDriver.getFee()).thenReturn(fee);
        when(driverVendor.findDriver(trip)).thenReturn(stubDriver);
    }

    private void given_car_config(int carFee, int serviceFee) {
        config.setCarFee(carFee);
        config.setServiceFee(serviceFee);
        when(carConfigRepository.findAll()).thenReturn(asList(config));
    }

}