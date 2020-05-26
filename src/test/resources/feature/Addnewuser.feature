#Author: sumit.mishra@cloudsmartz.net
Feature: Add New user Feature
  This feature deals with Service Provider user is able to add new user.

 @RegressionTest
  Scenario: Verify that service provider user is able to add new user
    Given login to seaborn portal
    And click on the user management menu icon
    And click on the add new user button
    When enter valid emailaddress userfirstname usermiddlename userlastname and phonenumber
    And select county and roles
    And click on the save button
    Then success message should appear
