Feature: Forget Password

  @First
  Scenario: Verify user can click on the Forget Password button
    When User clicks on the Forgot Password button
    Then Forgot Password page should be shown

  @First
  Scenario Outline: Verify user can get temporary link
    And User clicks on the Forgot Password button
    When User inserts "<email>" as email address to get Temporary Link
    And User clicks on the Get Temporary Link button
    Then Temporary link should have sent
    And User clicks Done to navigate back to login page

    Examples: 
      | email                 |
      | adviser.vka@gmail.com |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with all alphabets
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      | abcdefgh    | abcdefgh        |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with all numbers
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      |   123456789 |       123456789 |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with all symbols
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      | /+=%()<>!   | /+=%()<>!       |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with all CAPITAL LETTERS
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      | ABCDEFGHI   | ABCDEFGHI       |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with alphabets and numbers
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      | abcd1234    | abcd1234        |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with alphabets and symbols
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      | abcd<>?]    | abcd<>?]        |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with numbers and symbols
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword | confirmPassword |
      | 12345<>?]   | 12345<>?]       |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with lowercase , numbers and symbols
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword  | confirmPassword |
      | abc12345<>?] | abc12345<>?]    |

  @Second
  Scenario Outline: (N) Verify User cannot set new password with Upper case , numbers and symbols
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    But The password should not be set

    Examples: 
      | newPassword  | confirmPassword |
      | ABC12345<>?] | ABC12345<>?]    |

  @Second
  Scenario Outline: Verify User can set new password with Uppercase , lowercase , numbers and symbols
    And User logs in using the link retrieved from email
    When User inserts new password as "<newPassword>"
    And User inserts confirm password as "<confirmPassword>"
    And User clicks Reset Password button
    Then The password should be set and navigate to back to login
    And User logs in again using "<email>" and "<newPassword>"
    And Login should be successful

    Examples: 
      | newPassword | confirmPassword | email                 | password    |
      | VkaTest@123 | VkaTest@123     | adviser.vka@gmail.com | VkaTest@123 |
