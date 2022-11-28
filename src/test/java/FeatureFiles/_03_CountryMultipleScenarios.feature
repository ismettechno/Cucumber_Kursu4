Feature: Country Multi Scenario

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly
    And Navigate to country page

  Scenario: Create Country
    When create a country
    Then Success message should be displayed

  Scenario: Create a country parameter data
    When Create a country name as "ism1Ulk111" code as "ism1Ulk1"
    Then Success message should be displayed


