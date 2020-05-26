#Author: sumit.mishra@cloudsmartz.net
Feature: Edit Customer User Feature
  This feature deals with customer admin user is able to edit Customer user.

  @RegressionTest
  Scenario: Verify that Customer admin user is able to edit customer user
    Given login with customer admin to the portal
    And click on customer user management menu icon
    And click on the 3 dotted icon for first customer from the list and click on edit link
    When clear and enter new valid customeruseremailaddress and clear and enter new customeruserfirstname and clear and enter new customerusermiddlename and clear and enter new customeruserlastname and clear and enter new customeruserphonenumber
    And select new county and select new role
    And click on the update button
    Then success message should appear for customer user updated in application
