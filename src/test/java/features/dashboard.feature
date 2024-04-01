Feature: Dashboard

  Background: 
    Given User logs in to Adviser Portal

    @VKA1
Scenario: Verify Dashboard page is a default page
Then Dashboard page should be displayed

  @VKA1
Scenario: Verify user can click Personal Result
And User Navigates to Hamburger
And User navigates to FAQ
And User Navigates to Hamburger
When User clicks on Personal Result
Then Dashboard page should be displayed
