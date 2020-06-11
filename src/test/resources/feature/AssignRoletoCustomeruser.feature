#Author: sumit.mishra@cloudsmartz.net
Feature: Assign Role to Customer user Feature
  This feature deals with customer admin user is able to assign role to customer user

  @AssignRoletoCustomeruser
  Scenario: Verify that Customer admin user is able to assign role to customer user
    Given login to SDX portal with customer admin
    And click on the user management menu icon for customer admin 
    And click on the 3 dotted icon for first customer from the list and click on Assign Roles link
    And click on Assign Roles tab 
    And click on checkbox for customer admin role 
    And click on Assign button
    Then success message should appear that role has been successfully updated for the user
