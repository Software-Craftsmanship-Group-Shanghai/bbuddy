package com.odde.bbuddy.acceptancetest.steps;

import com.odde.bbuddy.acceptancetest.data.charter.CarConfigRepositoryForTest;
import com.odde.bbuddy.acceptancetest.driver.UiDriver;
import com.odde.bbuddy.charter.repo.CarConfig;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CharterSteps {

    @Autowired
    UiDriver uiDriver;

    @Autowired
    CarConfigRepositoryForTest carConfigRepositoryForTest;

    private CarConfig carConfig = new CarConfig();

    @Before("@charter")
    public void setup() {
        carConfigRepositoryForTest.deleteAll();
    }

    @Given("^traffic fee (\\d+) and driver service fee (\\d+)$")
    public void traffic_fee_and_driver_service_fee(int trafficFee, int serviceFee) throws Throwable {
        carConfig.setCarFee(trafficFee);
        carConfig.setServiceFee(serviceFee);
        carConfigRepositoryForTest.save(carConfig);
    }

    @Given("^fee configuration is:$")
    public void fee_configuration_is(List<CarConfig> carConfigs) throws Throwable {
        carConfigRepositoryForTest.save(carConfigs.get(0));
    }

    @When("^calculate$")
    public void calculate() throws Throwable {
        uiDriver.navigateTo("/charter/fee_result");
    }

    @Then("^result is (\\d+)$")
    public void result_is(int fee) throws Throwable {
        assertThat(uiDriver.getAllTextInPage()).contains(String.valueOf(fee));
    }

}
