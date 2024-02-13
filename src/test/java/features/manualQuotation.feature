Feature: Manual Quotation

  Background: 
    #Adviser Portal [UAT]
    Given User should navigate to the site
    #adviser.vka@gmail.com | VkaTest@123
    And User logs in
    And User Navigates to Hamburger
    And User navigates to Manual Quotation

  Scenario: Verify can click Resources Form button in Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    When User clicks the Resources Form button on the Enquiry Tab
    Then List of the Resources Form with download button should be shown.

  Scenario: Verify can click all checkboxes in Resources Form for Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    And User clicks the Resources Form button on the Enquiry Tab
    When User clicks all checkbox button in search box
    Then All the Resources should be selected.

  Scenario: Verify can click selected checkboxes in Resources Form for Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    And User clicks the Resources Form button on the Enquiry Tab
    When User clicks selected checkbox button
    Then Selected Resources should be selected.

  Scenario: Verify can click Download button in Resources Form for Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    And User clicks the Resources Form button on the Enquiry Tab
    And User clicks selected checkbox button
    When User clicks the Download button
    Then All the forms should be downloaded.

  Scenario: Verify can click Download button with no Selected Resources in Resources Form for Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    And User clicks the Resources Form button on the Enquiry Tab
    When User clicks the Download button
    But No forms should be downloaded.

  Scenario Outline: Verify can search in Resources Form with Keyword for Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    And User clicks the Resources Form button on the Enquiry Tab
    When User uses Keyword as "<keyword>" in the search box to search
    Then Shows all the relevant results.

    Examples: 
      | keyword |
      | Test    |

  Scenario Outline: Verify can search in Resources Form with invalid Keyword for Manual Quotation Enquiry Tab
    And User clicks the New Enquiry button
    And User clicks Motor Private Product Type
    And User clicks the Resources Form button on the Enquiry Tab
    When User uses Keyword as "<keyword>" in the search box to search
    But No relevant Resources should be shown.

    Examples: 
      | keyword |
      | def     |

  Scenario: Verify can Export Plans for Manual Quotation in Quotation Tab
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    When User clicks Export Plans button in Quotation Tab
    Then User must be able to download a zip folder.

  Scenario: Verify user can download Brochure/Quotaion of the Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    When User clicks Download button in Quotation Tab
    And User clicks on the Brochure/Quotaion option from the dropdownlist
    Then User must be able to view a file.

  Scenario: Verify user can download Proposal of the Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    When User clicks Download button in Quotation Tab
    And User clicks on the Proposal option from the dropdownlist
    Then User must be able to view a file.

  Scenario: Verify user can download PDS of the Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    When User clicks Download button in Quotation Tab
    And User clicks on the PDS option from the dropdownlist
    Then User must be able to view a file.

  Scenario: Verify user can download Policy Wording of the Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    When User clicks Download button in Quotation Tab
    And User clicks on the Policy Wording option from the dropdownlist
    Then User must be able to view a file.

  Scenario: Verify user can click Requote button on Quotatioin Tab in Manual Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    When User clicks Requote button
    Then User must be able to view the list of Providers to requote.

  Scenario: Verify user can click one Provider button on Request for Requote in Manual Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    When User clicks one Provider to requote
    Then User must be able to view the Requote Remarks textbox.

  Scenario: Verify user can click multiple Provider button on Request for Requote in Manual Quotation
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    When User clicks multiple Provider to requote
    Then User must be able to view multiple Requote Remarks textbox.

  Scenario Outline: Verify user can insert value in the Requote Remark Textbox on Request for Requote
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    When User clicks one Provider to requote
    Then User insert Requote Remarks as "<Remarks>" in the textbox.

    Examples: 
      | Remarks                                                                                                                                                                                                                                                                                        |
      | A book lies open on the bench, its pages filled with stories of distant lands and forgotten adventures. You lose yourself in its pages, transported to far-off places and magical realms. Time becomes fluid, and for a moment, you are both here and there, in the park and within the story. |

  Scenario Outline: Verify user can insert value less thaan 500 char in the Requote Remark Textbox on Request for Requote
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    When User clicks one Provider to requote
    Then User insert less thaan 500 char Requote Remarks as "<Remarks>" in the textbox.

    Examples: 
      | Remarks                                                                                                                                                                                                                                                                                        |
      | A book lies open on the bench, its pages filled with stories of distant lands and forgotten adventures. You lose yourself in its pages, transported to far-off places and magical realms. Time becomes fluid, and for a moment, you are both here and there, in the park and within the story. |

  Scenario Outline: Verify user can insert value more thaan 500 char in the Requote Remark Textbox on Request for Requote
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    And User clicks one Provider to requote
    When User insert more thaan 500 char Requote Remarks as "<Remarks>" in the textbox
    Then Remarks value stop after 500 char and will not insert anymore char.

    Examples: 
      | Remarks                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
      | A book lies open on the bench, its pages filled with stories of distant lands and forgotten adventures. You lose yourself in its pages, transported to far-off places and magical realms. Time becomes fluid, and for a moment, you are both here and there, in the park and within the story.Around you, people from all walks of life gather—a diverse tapestry of humanity. They share laughter, engage in deep conversations, and find common ground under the benevolent gaze of the ancient oak. In this small corner of the world, differences are set aside, and connections are forged. |

  Scenario: Verify user cannot Submit Requote if the Remark Textbox is empty on Request for Requote
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    And User clicks one Provider to requote [Empty]
    When User clicks Confirm Button
    But User cannot be able to submit requote request.

  Scenario Outline: Verify user can insert value in the Requote Remark Textbox and Submit Requote on Request for Requote
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    And User clicks one Provider to requote
    And User insert less thaan 500 char Requote Remarks as "<Remarks>" in the textbox.
    When User clicks Confirm Button
    Then User able to submit requote request

    Examples: 
      | Remarks                                                                                                                                                                                                                                                                                        |
      | A book lies open on the bench, its pages filled with stories of distant lands and forgotten adventures. You lose yourself in its pages, transported to far-off places and magical realms. Time becomes fluid, and for a moment, you are both here and there, in the park and within the story. |

  Scenario: Verify user can delete Remark in the already Requoted Quotation
    And User clicks on the first row of the table when the status is Requote Quotation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    And User clicks one Provider to requote
    When User deletes the current Remark
    Then All the values in the textbox is deleted.

  Scenario Outline: Verify user can submit new Remark in the already Requoted Quotation and Submit
    And User clicks on the first row of the table when the status is Requote Quotation
    And User clicks Next button after filling up FOV details
    And User clicks Next button after filling up Application
    And User clicks Next button after selecting Provider
    And User clicks Requote button
    And User clicks one Provider to requote
    And User deletes the current Remark
    And User insert less thaan 500 char Requote Remarks as "<Remarks>" in the textbox.
    When User clicks Confirm Button
    Then User able to submit requote request

    Examples: 
      | Remarks                                                               |
      | I am requesting for New Quotation as the current one is Not complete. |

  Scenario: Verify user can Filter Quotation by Provider
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    When User clicks on Filter By button
    Then List of Providers name should be shown for filtering

  Scenario: Verify user can select One Filter Quotation by Provider
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User clicks on Filter By button
    And List of Providers name should be shown for filtering
    When User selects one provider checkbox
    Then Quotation related to that filter only will be shown

  Scenario: Verify user can select multiple Filter Quotation by Provider
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User clicks on Filter By button
    And List of Providers name should be shown for filtering
    When User selects mutiple provider checkbox
    Then Quotation related to that filter only will be shown

  Scenario: Verify user can click Remark button
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    When User selects Remark
    Then Remark page should be shown

  Scenario: Verify user can click Add New Remark button
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User selects Remark
    And Remark page should be shown
    When User clicks Add New Remarks button
    Then Remark textbox should be shown

  Scenario: Verify user can close Remark textbox
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User selects Remark
    And Remark page should be shown
    And User clicks Add New Remarks button
    And Remark textbox should be shown
    When User clicks Add New Remarks button
    Then Remark textbox should not be shown

  Scenario Outline: Verify user can update New Remark
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User selects Remark
    And Remark page should be shown
    And User clicks Add New Remarks button
    And Remark textbox should be shown
    When User inserts "<Remarks>" in the textbox
    And User clicks Update button
    Then New Remark should be added in the page

    Examples: 
      | Remarks                       |
      | Wait until it take screenshot |

  Scenario: Verify user can sort Remark by oldest
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User selects Remark
    And Remark page should be shown
    When User clicks Sort by Oldest button
    Then Remarks should be shown in order

  Scenario: Verify user can sort Remark by newest
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User selects Remark
    And Remark page should be shown
    And User clicks Sort by Oldest button
    When User clicks Sort by Newest button
    Then Remarks should be shown in order

  Scenario: Verify user can download Proposal Form
    And User clicks on the first row of the table when the status is Awaiting Confirmation
    And User clicks Quotation Tab
    And User selects a Quotation
    And User clicks Next button after selecting a quotation
    When User clicks Add Download button
    Then Proposal Form should be downloaded

  Scenario: Verify user can view uploaded Proposal Form
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Quotation Tab
    When User clicks View File button
    Then Proposal Form should be open in another Tab

  #Payment
  @Today
  Scenario: Verify user can click Make Payment button
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    When User clicks on Make Payment button
    Then User should be able to view the Select Payment Type page

  @Today
  Scenario: Verify user can choose Payment Type
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    When User clicks payment type
    And User clicks confirm button payment type
    Then User should be able to view the Payment page to make payment

  @Today
  Scenario: Verify user can verify the amount to pay and clicks Make Payment button
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    When User clicks on Make Payment button to pay
    Then User should be able to view the Payment Page with provider name and bank details

  @method @NoDoc @Today
  Scenario Outline: Verify user can make payment using bulk payment method without document
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    And User clicks on Make Payment button to pay
    When User clicks Bulk Payment method
    Then User inputs the value for "<refNo>" and "<amount>"
    And User clicks Submit
    But User cannot submit the application

    Examples: 
      | refNo     | amount |
      | mv1268278 |   1000 |

  @method @NoDoc @Today
  Scenario Outline: Verify user can make payment using credit card method without document
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    And User clicks on Make Payment button to pay
    When User clicks Credit Card method
    Then User inputs the value for "<refNo>"
    And User clicks Submit
    But User cannot submit the application

    Examples: 
      | refNo     |
      | mv1268378 |

  @method @NoDoc @Today
  Scenario Outline: Verify user can make payment using Bank Transfer method without document
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    And User clicks on Make Payment button to pay
    When User clicks Bank Transfer method
    Then User inputs the value for "<refNo>"
    And User clicks Submit
    But User cannot submit the application

    Examples: 
      | refNo     |
      | mv1278378 |

  @method @Doc @One
  Scenario Outline: Verify user can make payment using bulk payment method with document
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    And User clicks on Make Payment button to pay
    When User clicks Bulk Payment method
    Then User inputs the value for "<refNo>" and "<amount>"
    And User uploads Document
    And User clicks Submit
    And User should be to get a pop up message that payment is submitted

    Examples: 
      | refNo     | amount |
      | mv1268278 |    800 |

  @method @Doc @Two
  Scenario Outline: Verify user can make payment using credit card method with document
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    And User clicks on Make Payment button to pay
    When User clicks Credit Card method
    Then User inputs the value for "<refNo>"
    And User uploads Document
    And User clicks Submit
    And User should be to get a pop up message that payment is submitted

    Examples: 
      | refNo     |
      | mv1268378 |

  @method @Doc @Three
  Scenario Outline: Verify user can make payment using Bank Transfer method with document
    And User clicks on the first row of the table when the status is Pending Payment
    And User clicks Payment Tab
    And User clicks on Make Payment button
    And User clicks payment type
    And User clicks confirm button payment type
    And User clicks on Make Payment button to pay
    When User clicks Bank Transfer method
    Then User inputs the value for "<refNo>"
    And User uploads Document
    And User clicks Submit
    And User should be to get a pop up message that payment is submitted

    Examples: 
      | refNo     |
      | mv1278378 |

  @Policy
  Scenario: Verify user can click Policy Tab
    And User clicks on the first row of the table when the status is Completed with paid
    When User clicks Policy Tab
    Then User should be able to view Policy Effective Date and Expiry Date

  @Policy @Again
  Scenario: Verify user can view uploaded payment receipt
    And User clicks on the first row of the table when the status is Completed with paid
    And User clicks Payment Tab
    When User clicks on Receipt
    Then User should be navigated to new Tab

  @Policy @Again
  Scenario: Verify user can click Done on Policy Tab
    And User clicks on the first row of the table when the status is Completed with paid
    And User clicks Policy Tab
    When User clicks Done button in Policy Tab
    Then User should be navigated to the Enquiry List
