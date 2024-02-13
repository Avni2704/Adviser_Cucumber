Feature: Login UAT

  # Background is for Pre Condition
  # If the precondition is same for all scenario in the features
  # Before Test = Run before run the scenario
  Background: Given User should navigate to the site

  Scenario: Verify User can Login Successfully
    And User enter email as "adviser.vka@gmail.com"
    And User enter password as "VkaTest@123"
    When User click the Login button
    Then Login should be successful

  Scenario Outline: (N) Verify User cannot Login with no email address
    And User enter email as "<email>"
    And User enter password as "<password>"
    When User click the Login button
    But Login should be fail

    Examples: 
      | email | password    |
      |       | VkaTest@123 |

  
  Scenario Outline: (N) Verify User cannot Login with no password
    And User enter email as "<email>"
    And User enter password as "<password>"
    When User click the Login button
    But Login should be fail

    Examples: 
      | email                 | password |
      | adviser.vka@gmail.com |          |

@Try
  Scenario Outline: (N) Verify User cannot Login with wrong email
    And User enter email as "<email>"
    And User enter password as "<password>"
    When User click the Login button
    But Login should be fail

    Examples: 
      | email                   | password    |
      | adviser.vvvka@gmail.com | VkaTest@123 |


  Scenario Outline: (N) Verify User cannot Login with wrong password
    And User enter email as "<email>"
    And User enter password as "<password>"
    When User click the Login button
    But Login should be fail

    Examples: 
      | email                 | password   |
      | adviser.vka@gmail.com | VkaTest@12 |

@TryAgain
  Scenario Outline: (N) Verify User cannot Login with both wrong email and password
    And User enter email as "<email>"
    And User enter password as "<password>"
    When User click the Login button
    But Login should be fail

    Examples: 
      | email                  | password   |
      | adviser.vvka@gmail.com | VkaTest@12 |
