Feature: My Profile

  Background: 
    Given User logs in

  Scenario: Verify User can view the My Profile Page
    And User clicks on the Name dropdown to view the My Profile button
    When User clicks on the My Profile
    Then My Profile page should shown

  Scenario: Verify User can click on the FOV tab in My Profile Page
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on the FOV Tab
    Then List of FOV should be shown in the My Profile

  Scenario: Verify User can click on the My Course tab in My Profile Page
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on the My Course Tab
    Then List of My Course should be shown in the My Profile

  Scenario: Verify User can click on the My License tab in My Profile Page
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on the My License Tab
    Then List of My License should be shown in the My Profile

  Scenario: Verify User can click on the Personal Details tab in My Profile Page
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    And User clicks other tab first
    When User clicks on the Personal Details Tab
    Then List of Personal Details should be shown in the My Profile
    
    Scenario: Verify User can upload pic in the My Profile page
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on the Profile photo to change the image
    Then The profile photo updated to a new one
    

