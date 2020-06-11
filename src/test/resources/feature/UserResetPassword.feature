#Author: sumit.mishra@cloudsmartz.net
Feature: User Reset Password Feature
  This feature deals with service provider admin is able to reset password of user

  @UserResetPassword
  Scenario: Verify that service provider admin is able to reset password of user
    Given login to SDX with service provider admin
    And click on the user management menu icon for service provider admin login
    And click on the 3 dotted icon for first user from the list and click on Reset Password link
    When enter New password and Confirm Password for user
    And click on ok button for Reset Password pop up for user
    Then success message should appear for Password Reset for that user
