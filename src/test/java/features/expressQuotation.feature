Feature: Express Quotation

  Background: 
    Given User logs in
    And User Navigates to Hamburger
    When User navigates to Express Quotation

  @Sprint27
  Scenario: Verify can open the Express Quotation module
    Then Express Quotation module display

  @Sprint27
  Scenario: Verify can click on the New Enquiry button
    When User clicks on the New Enquiry button
    Then User selects the Product Type
    And Application page is shown

  @Sprint27
  Scenario Outline: Verify User can fill up the required form details in Enquiry Tab
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    Then Vehicle info page should be shown in the Enquiry Tab.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint27 @CheckThis
  Scenario Outline: Verify User can fill up the Vehicle Info in Enquiry Tab
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    Then Quotation Tab is shown

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint28
  Scenario Outline: Verify User can choose random Quotation for Express Quotation.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    Then Payment Tab is shown

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint29
  Scenario Outline: Verify User can make payment for Express Quotation through Online Banking.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And Vehicle info page should be shown in the Enquiry Tab.
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    And Payment Tab is shown
    And User clicks on the Make Payment button on Express Quotation
    And User navigates to Payment gateway portal
    And User clicks on Online Banking for Individual Account
    And User chooses Bank Name
    And User clicks on the Pay Now button
    And User inserts value into Bank User ID and Bank Password textboxes and Sign in
    And User clicks on the Confirm button to make FPX Payment
    And Amount has been deducted message is shown
    And User clicks on the Complete Transaction button
    And User navigates to the Adviser portal again
    Then User can view the Payment Tab with payment receipt

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint29
  Scenario Outline: Verify User can make payment for Express Quotation through Credit Card.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And Vehicle info page should be shown in the Enquiry Tab.
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    And Payment Tab is shown
    And User clicks on the Make Payment button on Express Quotation
    And User navigates to Payment gateway portal
    And User clicks on Credit Card payment
    And User clicks on the Pay Now button
    And User fill up credit card details
    #And User clicks on the Confirm button to make credit card Payment
    And User clicks on Submit button for Authentication Result
    And User navigates to the Adviser portal again
    Then User can view the Payment Tab with payment receipt

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint29
  Scenario Outline: Verify User can view Policy Tab after making Online Payment.
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    When User clicks on the Enquiry Page to view the list of Enquiries
    And User clicks on the newly created Enquiry
    And User clicks on the Policy Tab
    Then Issue Date should be the current Date
    And Expiry Date should be 364 days from the Effective Date

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  ###################-- NEGATIVE SCENARIO = Enquiry Tab -- start -- #################################################################################
  @Name @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with all Numbers in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    But The Name textbox should not display the value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   4 |

  @Name @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with all Symbols in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    But The Name textbox should not display the value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   5 |

  @Name @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with Symbols and Numbers in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    But The Name textbox should not display the value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  10 |

  @Name @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with Alphabets, Symbols and Numbers in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    But The Name textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   9 |

  @Name @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with all UPPERCASE in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    Then The Name textbox should display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   2 |

  @Name @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with all lowercase in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    Then The Name textbox should display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   3 |

  @Name @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with acceptable symbols in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    Then The Name textbox should display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   7 |

  @Name @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in Name Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    But The Name textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   1 |

  #####NRIC
  @NRIC @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with all alphabets in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    But The NRIC textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   2 |

  @NRIC @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    But The NRIC textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  26 |

  @NRIC @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with all symbols in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    But The NRIC textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   5 |

  @NRIC @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with less than 12 digits in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    But The NRIC textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   4 |

  @NRIC @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with symbols, alphabets and numbers in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    But The NRIC textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   8 |

  @NRIC @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with symbols and numbers in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    But The NRIC textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   6 |

  @NRIC @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with 12 digits in NRIC Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User chooses ID Type and inserts value for ID No.
    Then The NRIC textbox should display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  15 |

  ##ContactNo
  @ContactNo @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with all alphabets in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    But The Contact Number textbox should not display the value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   3 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with all symbols in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    But The Contact Number textbox should not display the value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   5 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with symbols and numbers in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    But The Contact Number textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   7 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with alphabets, symbols and numbers in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    But The Contact Number textbox should not display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   9 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with less than 8 digits in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    But The Contact Number textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  27 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with more than 12 digits in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    But The Contact Number textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  28 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with null value in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    Then The Contact Number textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  29 |

  @ContactNo @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry within 8 - 12 digits in Contact Number Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    When User inserts value for Vehicle Reg No. and Contact No.
    Then The Contact Number textbox should display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   6 |

  #Email
  @Email @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry without '@' in domain name in Email Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    When User inserts value for Office No. and Email Address
    But The Email textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  12 |

  @Email @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry without full domain in Email Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    When User inserts value for Office No. and Email Address
    But The Email textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  14 |

  @Email @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry without domain in Email Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    When User inserts value for Office No. and Email Address
    But The Email textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  13 |

  @Email @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with numbers in Email Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    When User inserts value for Office No. and Email Address
    But The Email textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  30 |

  @Email @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with null value in Email Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    When User inserts value for Office No. and Email Address
    Then The Email textbox should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  11 |

  @Email @Validation @Sprint29
  Scenario Outline: Verify user can create new Enquiry with complete Email address in Email Textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    When User inserts value for Office No. and Email Address
    Then The Email textbox should display the full value.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  15 |

  @Address @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in Line 1 and Line 2 textbox
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    When User inserts value for Address Line 1 and Line 2
    But The Line1 and Line2 textbox should throw validation error

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  25 |

  @Address @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in Postcode dropdown list
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    When User skips postcode
    But The Postcode dropdown list should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  24 |

  @Dropdown @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in Maritial dropdown list
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    When User skips Maritial Status
    But The Maritial Status dropdown list should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  15 |

  @Dropdown @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in Nature of Business dropdown list
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    When User skips Nature of Business.
    But The Nature of Business dropdown list should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  16 |

  @Dropdown @Validation @Sprint29
  Scenario Outline: (N) Verify user cannot create new Enquiry with null value in Occupation dropdown list
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    When User skips Occupation
    But The Occupation dropdown list should throw validation error.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  17 |


  @Sprint30
  Scenario Outline: (N) Verify User cannot continue further without choosing Quotation for Express Quotation.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    When User clicks on the Next button without choosing the Quotation
    But System is still should be in Quotation Tab

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint30 @TryAgain
  Scenario Outline: (N) Verify User cannot choose the same Test Data for Express Quotation that already existed.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    When User clicks on the Next button
    But Vehicle info page should not be shown in the Enquiry Tab.

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |  31 |

  @Sprint30
  Scenario Outline: (N) Verify User cannot make payment for Express Quotation through wrong FPX credential.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And Vehicle info page should be shown in the Enquiry Tab.
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    And Payment Tab is shown
    When User clicks on the Make Payment button on Express Quotation
    And User navigates to Payment gateway portal
    And User clicks on Online Banking for Individual Account
    And User chooses Bank Name
    And User clicks on the Pay Now button
    And User inserts wrong value into Bank User ID and Bank Password textboxes
    And Try to Sign in
    But User cannot sigin to the portal

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   31 |

  @Sprint30 
  Scenario Outline: (N) Verify User cannot proceed to Policy Tab in Express Quotation without making Payment.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And Vehicle info page should be shown in the Enquiry Tab.
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    And Payment Tab is shown
    When User clicks on the Policy Tab
    But Policy Tab is not clickable

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint30
  Scenario Outline: Verify Enquiry Status is changed to Pending payment after cancelling the payment in Express Quotation.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And Vehicle info page should be shown in the Enquiry Tab.
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    And Payment Tab is shown
    When User clicks on the Enquiry Page to view the list of Enquiries
    Then Newly created Policy should be 'Pending Payment' status

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |

  @Sprint30
  Scenario Outline: Verify Enquiry Status is changed to Completed with paid after completing the payment in Express Quotation.
    And User clicks on the New Enquiry button
    And User selects the Product Type
    And Gets Test Data from "<file>", "<sheetName>" sheet and row number: "<row>"
    And User chooses the salution
    And User inserts value for Customer Name and Insured Name
    And User inserts value for Vehicle Reg No. and Contact No.
    And User inserts value for Office No. and Email Address
    And User chooses ID Type and inserts value for ID No.
    And User chooses Maritial Status and Nature of Business and Occupation
    And User inserts value for Address Line 1 and Line 2
    And User chooses postcode and inserts value for Driving Experience
    And User may choose the FOV Name and insert value for Remark
    And User clicks disclaimer checkbox
    And User clicks on the Next button
    And Vehicle info page should be shown in the Enquiry Tab.
    When User chooses Cover Note Type
    And User inserts value for Vehicle Registration Card NO. and Inception Date
    And User chooses Is Recon Car and Body
    And User inserts value for Hire Purchase Company
    And User chooses Garage, Safety Features and Anti Theft
    And User chooses NVIC and Allianz Variant
    And User inserts value for Sum Insured Amount and chooses PIAM Driver Code
    And User clicks on the Next button
    And Quotation Tab is shown
    And User chooses a random Quotation
    And User selects additional benefits
    And Detailed Quotation Tab should be shown.
    And User clicks on the Product Disclosure Sheet disclaimer and Next button
    And Payment Tab is shown
    And User clicks on the Make Payment button on Express Quotation
    And User navigates to Payment gateway portal
    And User clicks on Online Banking for Individual Account
    And User chooses Bank Name
    And User clicks on the Pay Now button
    And User inserts value into Bank User ID and Bank Password textboxes and Sign in
    And User clicks on the Confirm button to make FPX Payment
    And Amount has been deducted message is shown
    And User clicks on the Complete Transaction button
    And User navigates to the Adviser portal again
    And User can view the Payment Tab with payment receipt
    When User clicks on the Enquiry Page to view the list of Enquiries
    Then Newly created Policy should be 'Completed with paid' status after payment

    Examples: 
      | file                  | sheetName   | row |
      | Adviser_TestData.xlsx | ExpressQuot |   0 |
