@user
Feature: Charter

  Scenario: One day
    Given traffic fee 50 and driver service fee 400
    When calculate
    Then result is 450


    Given traffic fee 50 and driver service fee 400
    And  non local driver cost 40
    When calculate
    Then result is 490