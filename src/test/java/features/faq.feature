Feature: FAQ

  Background: 
    Given User logs in to Adviser Portal
    And User Navigates to Hamburger
    When User navigates to FAQ

  @VKA1
  Scenario: Verify can open the FAQ module
    Then FAQ module display

  @VKA1
Scenario: Verify User can open the question and close
Then User can open and close the questions

