Feature: Change Password

  Scenario: Verify user can view Reset Password page
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    When User clicks on the Change Password
    Then Reset Password page should be displayed

  Scenario Outline: (N) Verify user cannot reset password with all Symbols
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | ?>;%-/?;    | ?>;%-/?;        |

  Scenario Outline: (N) Verify user cannot reset password with all Numbers
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 |    12345678 |        12345678 |

  Scenario Outline: (N) Verify user cannot reset password with all lowercase
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | password    | password        |

  Scenario Outline: (N) Verify user cannot reset password with all UPPERCASE
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | PASSWORD    | PASSWORD        |

  Scenario Outline: (N) Verify user cannot reset password with alphabets and numbers
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | ABCD1231    | ABCD1231        |

  Scenario Outline: (N) Verify user cannot reset password with alphabets and symbols
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | ABCD?>;%    | ABCD?>;%        |

  Scenario Outline: (N) Verify user cannot reset password with alphabets, symbols and numbers
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | AB31/+      | AB31/+          |

  Scenario Outline: (N) Verify user cannot reset password with symbols and numbers
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | 1231?>;%    | 1231?>;%        |

  Scenario Outline: (N) Verify user cannot reset password with less than 8 characters
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | aA1?        | aA1?            |

  Scenario Outline: (N) Verify user cannot reset password with same Current Password
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | VkaTest@123 | VkaTest@123     |

  Scenario Outline: (N) Verify User cannot reset Password with different new Password and confirm password
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | ABCD1236/+= | 1231?>;%        |

  Scenario Outline: (N) Verify User cannot reset Password when the New Password textbox is null
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User skips New Password textbox
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 |             | 1231?>;%        |

  Scenario Outline: (N) Verify User cannot reset Password when the Confirm Password textbox is null
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User skips Confirm New Password textbox
    And User Clicks Reset Password button
    But The password should not be reset.

    Examples: 
      | password    | newPassword | confirmPassword |
      | VkaTest@123 | ABcd1236/+= |                 |

  Scenario Outline: Verify user can reset password
    And User logs in
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    Then The password should be reset
    And User logs in again using "<email>" and "<newPassword>"
    And Login should be successful

    Examples: 
      | email                 | password    | newPassword | confirmPassword |
      | adviser.vka@gmail.com | VkaTest@123 | VkaPass@123 | VkaPass@123     |

  @Final
  Scenario Outline: Verify user can update back to old Password
    And User logs in using new Password: "<password>"
    And User clicks on the Name dropdown to view the My Profile button
    And User clicks on the Change Password
    When User inserts value for current password as "<password>"
    And User inserts value for New Password as "<newPassword>"
    And User inserts value for Confirm Password as "<confirmPassword>"
    And User Clicks Reset Password button
    Then The password should be reset
    And User logs in again using "<email>" and "<newPassword>"
    And Login should be successful

    Examples: 
      | email                 | password    | newPassword | confirmPassword |
      | adviser.vka@gmail.com | VkaPass@123 | VkaTest@123 | VkaTest@123     |
