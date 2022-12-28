Feature: Testing JDBC States

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

  Scenario: States testing with JDBC
    And Click on the element in left nav
      | setupOne   |
      | parameters |
      | states     |
    Then Send The query the database "select * from states" and control match