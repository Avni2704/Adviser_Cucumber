Feature: FOV

  Background: 
    Given User logs in to Adviser Portal
    And User Navigates to Hamburger
    When User navigates to FOV

  Scenario: Verify user can view the FOV page
    Then FOV module should display

  Scenario: Verify user can click the checkbox in the bottom of the page
    And User scroll down to the bottom of the page
    When User clicks on the checkbox
    Then The checkbox should be checked

  Scenario: Verify user can uncheck the checkbox in the bottom of the page
    And User scroll down to the bottom of the page
    When User clicks on the checkbox
    And User clicks again to uncheck the checkbox
    Then The checkbox should be unchecked

  Scenario: Verify user can click on the Legal Notes
    And User scroll down to the bottom of the page
    When User clicks on the Legal Notes
    Then New Tab should be shown with Legal notes

  Scenario: Verify user can click on the Terms of Use
    And User scroll down to the bottom of the page
    When User clicks on the Terms of Use
    Then New Tab should be shown with Terms of Use

  Scenario: Verify user can click on the Privacy Statement
    And User scroll down to the bottom of the page
    When User clicks on the Privacy Statement
    Then New Tab should be shown with Privacy Statement

  @Individual
  Scenario Outline: Verify user can click Next button when Entity Type = Individual, Nationality = Malaysian, Remark with value and Disclaimer checkbox is checked
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    Then The next tab Documents should be shown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual
  Scenario Outline: Verify user can click Next button when Entity Type = Individual, Nationality = Malaysian, Remark with no value and Disclaimer checkbox is checked
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    Then The next tab Documents should be shown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 |        |

  @Individual
  Scenario Outline: Verify user can click Next button when Entity Type = Individual, Nationality = Foreigner, Remark with value and Disclaimer checkbox is checked
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    Then The next tab Documents should be shown

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual
  Scenario Outline: Verify user can click Next button when Entity Type = Individual, Nationality = Foreigner, Remark with no value and Disclaimer checkbox is checked
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    Then The next tab Documents should be shown

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 |        |

  @Company
  Scenario Outline: Verify user can click Next button when Entity Type = Company and Remark with value and Disclaimer checkbox is checked
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    Then The next tab Documents should be shown

    Examples: 
      | entityType | nationality | compName | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | James    | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company
  Scenario Outline: Verify user can click Next button when Entity Type = Company and Remark with no value and Disclaimer checkbox is checked
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    Then The next tab Documents should be shown

    Examples: 
      | entityType | nationality | compName | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Company    | Malaysian   | James    | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 |        |

  ##############################################################################################################################################
  @Individual
  Scenario Outline: Verify user can upload documents when Entity Type = Individual and Nationality = Malaysian
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads NRIC document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    Then Application should be send to Backoffice

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual
  Scenario Outline: Verify user can upload documents when Entity Type = Individual and Nationality = Foreigner
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document
    And User uploads VISA document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    Then Application should be send to Backoffice

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Company
  Scenario Outline: Verify user can upload documents when when Entity Type = Company
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document
    And User uploads Authorization Letter document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    Then Application should be send to Backoffice

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  ###################-- NEGATIVE SCENARIO = INDIVIDUAL -- start -- #################################################################################
  @Name @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all Numbers in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    But The Name textbox should not display the value

    Examples: 
      | entityType | nationality | name |
      | Individual | Malaysian   |  123 |

  @Name @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all Symbols in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    But The Name textbox should not display the value

    Examples: 
      | entityType | nationality | name |
      | Individual | Malaysian   | %()  |

  @Name @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with Symbols and Numbers in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    But The Name textbox should not display the value

    Examples: 
      | entityType | nationality | name   |
      | Individual | Malaysian   | %()123 |

  @Name @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with Alphabets, Symbols and Numbers in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    But The Name textbox should not display the full value

    Examples: 
      | entityType | nationality | name      |
      | Individual | Malaysian   | ABC%()123 |

  @Name @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all UPPERCASE in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    Then The Name textbox should display the full value

    Examples: 
      | entityType | nationality | name |
      | Individual | Malaysian   | ABC  |

  @Name @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all lowercase in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    Then The Name textbox should display the full value

    Examples: 
      | entityType | nationality | name |
      | Individual | Malaysian   | abc  |

  @Name @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with acceptable symbols in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    Then The Name textbox should display the full value

    Examples: 
      | entityType | nationality | name           |
      | Individual | Malaysian   | James a/l Bond |

  @Name @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Name Textbox
    And User chooses Nationality as "<nationality>"
    When User inserts value for Name as "<name>"
    But The Name textbox should throw validation error

    Examples: 
      | entityType | nationality | name |
      | Individual | Malaysian   |      |

  #####NRIC
  @NRIC @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all alphabets in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The NRIC textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id   |
      | Individual | Malaysian   | James | abcd |

  @NRIC @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The NRIC textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id |
      | Individual | Malaysian   | James |    |

  @NRIC @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all symbols in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The NRIC textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id   |
      | Individual | Malaysian   | James | <>?- |

  @NRIC @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with less than 12 digits in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The NRIC textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id         |
      | Individual | Malaysian   | James | 9805140865 |

  @NRIC @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols, alphabets and numbers in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The NRIC textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id             |
      | Individual | Malaysian   | James | 9805AB-08-6598 |

  @NRIC @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols and numbers in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The NRIC textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id             |
      | Individual | Malaysian   | James | 980514-08-6598 |

  @NRIC @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with 12 digits in NRIC Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    Then The NRIC textbox should display the full value

    Examples: 
      | entityType | nationality | name  | id           |
      | Individual | Malaysian   | James | 980514086598 |

  #Pasport
  @Passport @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all Symbols in Passport Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The Passport textbox should not display the full value

    Examples: 
      | entityType | nationality | name | id     |
      | Individual | Foreigner   | Alex | <>?:{} |

  @Passport @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Passport Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    But The Passport textbox should throw validation error

    Examples: 
      | entityType | nationality | name | id |
      | Individual | Foreigner   | Alex |    |

  @Passport @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all alphabets in Passport Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    Then The Passport textbox should display the full value

    Examples: 
      | entityType | nationality | name | id                 |
      | Individual | Foreigner   | Alex | UnitedArabEmirates |

  @Passport @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all numbers in Passport Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    Then The Passport textbox should display the full value

    Examples: 
      | entityType | nationality | name | id       |
      | Individual | Foreigner   | Alex | 59845984 |

  @Passport @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with alphabets and numbers in Passport Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    When User inserts value for ID as "<id>"
    Then The Passport textbox should display the full value

    Examples: 
      | entityType | nationality | name | id          |
      | Individual | Foreigner   | Alex | UAE59845984 |

  #ContactNo
  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all alphabets in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    But The Contact Number textbox should not display the value

    Examples: 
      | entityType | nationality | name  | id        | contactNo |
      | Individual | Foreigner   | James | UAE595984 | abcd      |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all symbols in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    But The Contact Number textbox should not display the value

    Examples: 
      | entityType | nationality | name  | id        | contactNo |
      | Individual | Foreigner   | James | UAE595984 | <>?/      |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols and numbers in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    But The Contact Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id        | contactNo   |
      | Individual | Foreigner   | James | UAE595984 | 16-345-6789 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with alphabets, symbols and numbers in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    But The Contact Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id        | contactNo   |
      | Individual | Foreigner   | James | UAE595984 | AB1345-6789 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with less than 8 digits in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    But The Contact Number textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id        | contactNo |
      | Individual | Foreigner   | James | UAE595984 |     12345 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with more than 12 digits in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    But The Contact Number textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id        | contactNo      |
      | Individual | Foreigner   | James | UAE595984 | 12345678901234 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with null value in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    Then The Contact Number textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id        | contactNo |
      | Individual | Foreigner   | James | UAE595984 |           |

  @ContactNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV within 8 - 12 digits in Contact Number Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    When User inserts value for Contact Number as "<contactNo>"
    Then The Contact Number textbox should display the full value

    Examples: 
      | entityType | nationality | name  | id        | contactNo |
      | Individual | Foreigner   | James | UAE595984 | 123456789 |

  #Email
  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV without '@' in domain name in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    But The Email textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email         |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | jamesbond.com |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV without full domain in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    But The Email textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email      |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | jamesbond@ |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV without domain in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    But The Email textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email     |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | jamesbond |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with numbers in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    But The Email textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email   |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | 2824655 |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with numbers in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    But The Email textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email  |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | <>?:{} |

  @Email @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with null value in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    Then The Email textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 |       |

  @Email @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with complete Email address in Email Textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    When User inserts value for Email as "<email>"
    Then The Email textbox should display the full value

    Examples: 
      | entityType | nationality | name  | id          | contactNo | email          |
      | Individual | Foreigner   | James | UAE59845984 | 123456789 | james@bond.com |

  #Bank
  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Bank Name dropdown list
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    When User skips Bank Name
    But The Bank Name dropdown list should throw validation error

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com |          | 11259815675 |

  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    But The Bank Account Number should throw validation error

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  |           |

  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with alphabets in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    But The Account Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | abcfss    |

  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    But The Account Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | <>?:{}    |

  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols and alphabets in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    But The Account Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | <>?:{}abc |

  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols and numbers in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    But The Account Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | <>?:{}123 |

  @Bank @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with alphabets and numbers in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    But The Account Number textbox should not display the full value

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | abc123    |

  @Bank @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with numbers in Bank Account Number textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    When User inserts value for Bank Account as "<accountNo>"
    Then The Account Number textbox should display the full value

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 |

  #Address
  @Address @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Line 1 textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    When User inserts value for Line 1 as "<line1>"
    But The Line1 textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1 |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 |       |

  @Address @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Line 2 textbox
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    When User inserts value for Line 2 as "<line2>"
    But The Line2 textbox should throw validation error

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2 |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 |       |

  @Address @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Postcode dropdown list
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    When User skips Postcode
    But The Postcode dropdown list should throw validation error

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |          |

  @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV when Disclaimer checkbox is not checked
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    When User clicks on the Next button in FOV page
    But The Error pop up message should be displayed

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  ###################-- NEGATIVE SCENARIO = INDIVIDUAL -- end -- ###################################################################################
  ###################-- NEGATIVE SCENARIO = COMPANY -- start -- #################################################################################
  @CompName @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all Numbers in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    Then The Company textbox should display the value

    Examples: 
      | entityType | compName |
      | Company    |      123 |

  @CompName @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all Symbols in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    But The Company Name textbox should not display the value

    Examples: 
      | entityType | compName |
      | Company    | %<>?     |

  @CompName @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with Symbols and Numbers in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    But The Company Name textbox should not display the full value

    Examples: 
      | entityType | compName |
      | Company    | %<>?123  |

  @CompName @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with Alphabets, certain Symbols and Numbers in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    Then The Company textbox should display the value

    Examples: 
      | entityType | compName    |
      | Company    | ABC()-@&123 |

  @CompName @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all UPPERCASE in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    Then The Company textbox should display the value

    Examples: 
      | entityType | compName |
      | Company    | ABC      |

  @CompName @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all lowercase in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    Then The Company textbox should display the value

    Examples: 
      | entityType | compName |
      | Company    | abc      |

  @CompName @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with acceptable symbols in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    Then The Company textbox should display the value

    Examples: 
      | entityType | compName |
      | Company    | ()-@&    |

  @CompName @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Company Name Textbox
    And User chooses Entity Type as "<entityType>"
    When User inserts value for Company Name as "<compName>"
    But The Company Name textbox should throw validation error

    Examples: 
      | entityType | compName |
      | Company    |          |

  #Business RegNo
  @BussRegNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all Numbers in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    Then The Business Registration No textbox should display the value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | 654987321 |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all Symbols in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    But The Business Registration No textbox should not display the value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | %<>?      |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with Symbols and Numbers in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    But The Business Registration No textbox should not display the full value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | %<>?123   |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with Alphabets, certain Symbols and Numbers in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    Then The Business Registration No textbox should display the value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | ABC-123   |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all UPPERCASE in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    Then The Business Registration No textbox should display the value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | ABC       |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with all lowercase in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    Then The Business Registration No textbox should display the value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | abc       |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with acceptable symbols in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    Then The Business Registration No textbox should display the value

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | ---       |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    But The Business Registration No textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    |           |

  @BussRegNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with less than 3 characters in Business Registration No Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    When User inserts value for Business Registration No as "<bussRegNo>"
    But The Business Registration No textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo |
      | Company    | James    | a1        |

  #ContactNo
  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all alphabets in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    But The Company Contact Number textbox should not display the value

    Examples: 
      | entityType | compName | bussRegNo | contactNo |
      | Company    | James    | No256-05  | abcd      |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with all symbols in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    But The Company Contact Number textbox should not display the value

    Examples: 
      | entityType | compName | bussRegNo | contactNo |
      | Company    | James    | No256-05  | <>?/      |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with symbols and numbers in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    But The Company Contact Number textbox should not display the full value

    Examples: 
      | entityType | compName | bussRegNo | contactNo   |
      | Company    | James    | No256-05  | 16-345-6789 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with alphabets, symbols and numbers in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    But The Company Contact Number textbox should not display the full value

    Examples: 
      | entityType | compName | bussRegNo | contactNo   |
      | Company    | James    | No256-05  | AB1345-6789 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with less than 8 digits in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    But The Company Contact Number textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo |
      | Company    | James    | No256-05  |     12345 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with more than 12 digits in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    But The Company Contact Number textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo      |
      | Company    | James    | No256-05  | 12345678901234 |

  @ContactNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with null value in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    Then The Company Contact Number textbox should throw null validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo |
      | Company    | James    | No256-05  |           |

  @ContactNo @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV within 8 - 12 digits in Company Contact Number Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    When User inserts value for Office Number as "<contactNo>"
    Then The Company Contact Number textbox should display the full value

    Examples: 
      | entityType | compName | bussRegNo | contactNo |
      | Company    | James    | No256-05  | 123456789 |

  #Email
  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV without '@' in domain name in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    But The Company Email textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email         |
      | Company    | James    | No256-05  | 123456789 | jamesbond.com |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV without full domain in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    But The Company Email textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email      |
      | Company    | James    | No256-05  | 123456789 | jamesbond@ |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV without domain in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    But The Company Email textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email     |
      | Company    | James    | No256-05  | 123456789 | jamesbond |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with numbers in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    But The Company Email textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email   |
      | Company    | James    | No256-05  | 123456789 | 2824655 |

  @Email @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with numbers in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    But The Company Email textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email  |
      | Company    | James    | No256-05  | 123456789 | <>?:{} |

  @Email @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with null value in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    Then The Company Email textbox should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email |
      | Company    | James    | No256-05  | 123456789 |       |

  @Email @Validation @Sprint25
  Scenario Outline: Verify user can create new FOV with complete Email address in Company Email Textbox
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    When User inserts value for Email as "<email>" for company
    Then The Company Email textbox should display the full value

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email          |
      | Company    | James    | No256-05  | 123456789 | james@bond.com |

  @NatOfBus @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV with null value in Nature of Business dropdown list
    And User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    When User skips Nature of Business
    But The  Nature of Business dropdown list should throw validation error

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email          | natOfBuss |
      | Company    | James    | No256-05  | 123456789 | james@bond.com |           |

  @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot create new FOV when Disclaimer checkbox is not checked for Company Entity Type
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the Next button in FOV page
    But The Error pop up message should be displayed

    Examples: 
      | entityType | compName | bussRegNo | contactNo | email          | natOfBuss | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Company    | James    | No256-05  | 123456789 | james@bond.com | Arts      | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 |        |

  ###################-- NEGATIVE SCENARIO = COMPANY -- end -- #################################################################################
  ###################-- NEGATIVE SCENARIO = UPLOAD DOCUMENT -- start -- ###############################################################################
  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload when NRIC and Bank Statement document more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads NRIC document more than 15MB
    And User Uploads Bank Statement document more than 15MB
    And User Clicks Next button to complete FOV
    But Size Validation error for NRIC should be thrown
    And Size Validation error for local Individual Bank statement should be thrown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload when Bank Statement document more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    And User uploads NRIC document
    When User Uploads Bank Statement document more than 15MB
    And User Clicks Next button to complete FOV
    But Size Validation error for local Individual Bank statement should be thrown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload when NRIC document more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads NRIC document more than 15MB
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Size Validation error for NRIC should be thrown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without relevant documents
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User Clicks Next button to complete FOV
    But Null Validation error for NRIC should be thrown
    And Null Validation error for local Individual Bank statement should be thrown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without NRIC document
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    Then Null Validation error for NRIC should be thrown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without Bank Statement document
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads NRIC document
    And User Clicks Next button to complete FOV
    But Null Validation error for local Individual Bank statement should be thrown

    Examples: 
      | entityType | nationality | name  | id           | contactNo | email          | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Individual | Malaysian   | James | 980514086985 | 123456789 | james@bond.com | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  #Foreigner
  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Passport, VISA and Bank Statement is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document more than 15MB
    And User uploads VISA document more than 15MB
    And User Uploads Bank Statement document more than 15MB
    And User Clicks Next button to complete FOV
    But Size Validation error for Passport should be thrown
    And Size Validation error for VISA should be thrown
    And Size Validation error for Foreigner Bank statement should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Passport is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document more than 15MB
    And User uploads VISA document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Size Validation error for Passport should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when VISA is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document
    And User uploads VISA document more than 15MB
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Size Validation error for VISA should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Foreigner Bank Statement is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document
    And User uploads VISA document
    And User Uploads Bank Statement document more than 15MB
    And User Clicks Next button to complete FOV
    But Size Validation error for Foreigner Bank statement should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without relevant Foreign documents
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User Clicks Next button to complete FOV
    But Null Validation error for Passport should be thrown
    And Null Validation error for VISA should be thrown
    And Null Validation error for Foreigner Bank statement should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without Passport document
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads VISA document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Null Validation error for Passport should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without VISA document
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Null Validation error for VISA should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  @Individual @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without Foreigner Bank Statement document
    When User chooses Entity Type as "<entityType>"
    And User chooses Nationality as "<nationality>"
    And User inserts value for Name as "<name>"
    And User inserts value for ID as "<id>"
    And User inserts value for Contact Number as "<contactNo>"
    And User inserts value for Email as "<email>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Passport document
    And User uploads VISA document
    And User Clicks Next button to complete FOV
    But Null Validation error for Foreigner Bank statement should be thrown

    Examples: 
      | entityType | nationality | name | id          | contactNo | email          | bankName | accountNo   | line1   | line2   | postcode | remark |
      | Individual | Foreigner   | Alex | UAE59845984 | 123456789 | james@bond.com | Maybank  | 70268168115 | Line 11 | Line 22 |    12000 | Remark |

  #Company
  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without relevant company documents
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User Clicks Next button to complete FOV
    But Null Validation error for Form 24 should be thrown
    And Null Validation error for Authorization Letter should be thrown
    And Null Validation error for Company Bank statement should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without Form 24 document
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Authorization Letter document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Null Validation error for Form 24 should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without Authorization Letter document
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Null Validation error for Authorization Letter should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot submit new FOV without Company Bank Statement document
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document
    And User uploads Authorization Letter document
    And User Clicks Next button to complete FOV
    But Null Validation error for Company Bank statement should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Form 24, Authorization Letter and Company Bank Statement is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document more than 15MB
    And User uploads Authorization Letter document more than 15MB
    And User Uploads Bank Statement document more than 15MB
    And User Clicks Next button to complete FOV
    But Size Validation error for Form 24 should be thrown
    And Size Validation error for Authorization Letter should be thrown
    And Size Validation error for Company Bank statement should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Form 24 is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document more than 15MB
    And User uploads Authorization Letter document
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Size Validation error for Form 24 should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Authorization Letter is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document
    And User uploads Authorization Letter document more than 15MB
    And User Uploads Bank Statement document
    And User Clicks Next button to complete FOV
    But Size Validation error for Authorization Letter should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |

  @Company @Validation @Sprint25
  Scenario Outline: (N) Verify user cannot upload documents when Company Bank Statement is more than 15MB
    When User chooses Entity Type as "<entityType>"
    And User inserts value for Company Name as "<compName>"
    And User inserts value for Business Registration No as "<bussRegNo>"
    And User inserts value for Office Number as "<contactNo>"
    And User inserts value for Email as "<email>" for company
    And User chooses Nature of Business as "<natOfBuss>"
    And User chooses Bank Name as "<bankName>"
    And User inserts value for Bank Account as "<accountNo>"
    And User inserts value for Line 1 as "<line1>"
    And User inserts value for Line 2 as "<line2>"
    And User chooses Postcode as "<postcode>"
    And User inserts value in the Remark as "<remark>"
    And User clicks on the checkbox
    And User clicks on the Next button in FOV page
    And The next tab Documents should be shown
    When User uploads Form 24 document
    And User uploads Authorization Letter document
    And User Uploads Bank Statement document more than 15MB
    And User Clicks Next button to complete FOV
    But Size Validation error for Company Bank statement should be thrown

    Examples: 
      | entityType | nationality | compName  | bussRegNo    | contactNo | email          | natOfBuss | bankName | accountNo   | line1  | line2  | postcode | remark |
      | Company    | Malaysian   | Harold Co | 980514086985 | 123456789 | james@bond.com | Arts      | Maybank  | 11259815675 | Line 1 | Line 2 |    12000 | Remark |
###################-- NEGATIVE SCENARIO = UPLOAD DOCUMENT -- end -- #################################################################################
