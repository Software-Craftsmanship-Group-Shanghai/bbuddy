package com.odde.bbuddy.acceptancetest.steps;

import com.odde.bbuddy.acceptancetest.data.charter.CarConfigRepositoryForTest;
import com.odde.bbuddy.acceptancetest.driver.UiDriver;
import com.odde.bbuddy.charter.domain.CarConfigRepository;
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

    @Given("^xing che fei (\\d+) and fu wu fei (\\d+)$")
    public void xing_che_fei_and_fu_wu_fei(int trafficFee, int serviceFee) throws Throwable {
        CarConfig carConfig = new CarConfig();
        carConfig.setCarFee(trafficFee);
        carConfig.setServiceFee(serviceFee);
        carConfigRepositoryForTest.save(carConfig);
    }

    @When("^ji suan$")
    public void ji_suan() throws Throwable {
        uiDriver.navigateTo("/charter/fee_result");
    }

    @Then("^result is (\\d+)$")
    public void result_is(int fee) throws Throwable {
        assertThat(uiDriver.getAllTextInPage()).contains(String.valueOf(fee));
    }

}
