Feature: My Profile

  Background:
    Given User logs in to Adviser Portal

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

  @UI @VKA2 @Sprint35
  Scenario: Out Verify that Adviser can view My License page under My Profile.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can only view and unable to edit any fields in My License tab page.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the My License tab under My Profile page

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view FAR (Financial Adviser Representative) section if the user previously select tick box for Financial Adviser Representative during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the My License tab under My Profile page

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user able to view present Life Insurans Provider under FAR (Financial Adviser Representative).
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View FAR Life Insurance Provider List under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view IFAR (Islamic Financial Adviser Representative) section if the user previously select tick box for Financial Adviser Representative during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the IFAR section under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user able to view present Life Insurans Provider under IFAR (Islamic Financial Adviser Representative).
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View IFAR Life Insurance Provider List under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view CMSRL (Capital Markets Services Representative’s License) section if the user previously select tick box for Financial Adviser Representative during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the CMSRL section under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user able to view present Life Insurans Provider under CMSRL (Capital Markets Services Representative’s License).
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View CMSRL Life Insurance Provider List under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view FIMM UTSC (Unit Trust Consultant) section if the user previously select tick box for Financial Adviser Representative during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the UTSC section under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user able to view present Life Insurans Provider under FIMM UTSC (Unit Trust Consultant).
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View UTSC Life Insurance Provider List under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view FIMM PRSC (Private Retirement Scheme Consultant) section if the user set previously during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the PRSC section under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user able to view present Life Insurans Provider under FIMM PRSC (Private Retirement Scheme Consultant) section if the user set previously during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View PRSC Life Insurance Provider List under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view FIMM UTSC Apprentice (Unit Trust Consultant Apprentice) section if the user set previously during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the UTSC section under My License tab

  @Functional @VKA2 @Sprint35
  Scenario: Verify that user can view FIMM PRSC Apprentice (Private Retirement Scheme Consultant Apprentice) section if the user set previously during applicant onboarding.
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the My Profile
    And My Profile page should shown
    When User clicks on My License tab
    Then View the PRSC section under My License tab
