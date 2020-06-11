#Author: sumit.mishra@cloudsmartz.net
Feature: Add New Customer user Feature
  This feature deals with customer admin user is able to add new Customer user.

   @AddNewCustomeruser
  Scenario: Verify that Customer admin user is able to add new customer user
    Given login with customer admin
    And click on the customer user management menu icon
    And click on the add new customer user button
    When enter valid customeruseremailaddress customeruserfirstname customerusermiddlename customeruserlastname and customeruserphonenumber
    And select county and roles for add new customer user form
    And click on the save button for add new customer user
    Then success message should appear for new customer user added in application
