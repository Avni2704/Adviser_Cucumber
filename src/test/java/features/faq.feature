Feature: FAQ

  Background: 
    Given User logs in
    And User Navigates to Hamburger
    When User navigates to FAQ

  Scenario: Verify can open the FAQ module
    Then FAQ module display

Scenario: Verify User can open the question and close
Then User can open and close the questions

