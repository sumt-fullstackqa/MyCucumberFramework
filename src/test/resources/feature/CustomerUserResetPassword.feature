#Author: sumit.mishra@cloudsmartz.net
Feature: Customer User Reset Password Feature
  This feature deals with customer admin user is able to reset password of customer user

  @RegressionTest
  Scenario: Verify that Customer admin user is able to reset password of customer user
    Given login to SDX with customer admin
    And click on the user management menu icon for customer admin login
    And click on the 3 dotted icon for first customer from the list and click on Reset Password link
    When enter New password and Confirm Password
    And click on ok button for Reset Password pop up
    Then success message should appear for Password Reset for that customer user
