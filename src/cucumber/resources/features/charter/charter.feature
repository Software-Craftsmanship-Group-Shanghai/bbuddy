@charter
@user
Feature: Charter

  Scenario: One day
    Given traffic fee 50 and driver service fee 400
    When calculate
    Then result is 450

  Scenario: Driver is not local
    Given fee configuration is:
    |car fee | service fee | drive alone fee |
    |  50        |   400              | 40               |
    When calculate
    Then result is 490
