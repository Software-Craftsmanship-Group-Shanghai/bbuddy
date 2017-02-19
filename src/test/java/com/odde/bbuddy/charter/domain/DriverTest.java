package com.odde.bbuddy.charter.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {

    @Test
    public void should_give_0_free_if_local() {
        Driver driver = new Driver("SHANGHAI");
        Trip trip = new Trip("SHANGHAI", "SHANGHAI");

        assertThat(driver.getDriveAloneFee(trip)).isEqualTo(0);
    }

    @Test
    public void should_give_if_driver_is_from_departure() {
        Driver driver = new Driver("SHANGHAI");
        Trip trip = new Trip("SHANGHAI", "HANGZHOU");
        assertThat(driver.getDriveAloneFee(trip)).isEqualTo(40);
    }

    @Test
    public void should_give_if_driver_is_not_from_destination_nor_departure() {
        Driver driver = new Driver("NANJING");
        Trip trip = new Trip("SHANGHAI", "HANGZHOU");
        assertThat(driver.getDriveAloneFee(trip)).isEqualTo(90);
    }


}