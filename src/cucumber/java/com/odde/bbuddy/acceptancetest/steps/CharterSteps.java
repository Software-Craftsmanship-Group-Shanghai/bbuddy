package com.odde.bbuddy.acceptancetest.steps;

import com.odde.bbuddy.acceptancetest.data.charter.CarConfigRepositoryForTest;
import com.odde.bbuddy.acceptancetest.driver.UiDriver;
import com.odde.bbuddy.charter.repo.CarConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CharterSteps {

    @Autowired
    UiDriver uiDriver;

    @Autowired
    CarConfigRepositoryForTest carConfigRepositoryForTest;

    private CarConfig carConfig = new CarConfig();

    @Given("^traffic fee (\\d+) and driver service fee (\\d+)$")
    public void traffic_fee_and_driver_service_fee(int trafficFee, int serviceFee) throws Throwable {
        carConfig.setCarFee(trafficFee);
        carConfig.setServiceFee(serviceFee);
    }

    @Given("^non local driver cost (\\d+)$")
    public void non_local_driver_cost(int driverAloneFee) throws Throwable {
        carConfig.setDriveAloneFee(driverAloneFee);

    }

    @When("^calculate$")
    public void calculate() throws Throwable {
        carConfigRepositoryForTest.save(carConfig);
        uiDriver.navigateTo("/charter/fee_result");
    }

    @Then("^result is (\\d+)$")
    public void result_is(int fee) throws Throwable {
        assertThat(uiDriver.getAllTextInPage()).contains(String.valueOf(fee));
    }

}
