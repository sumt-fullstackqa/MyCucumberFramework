#Author: sumit.mishra@cloudsmartz.net
Feature: Approve and Reject Customer Feature
  This feature deals with service provider admin user is able to approve and reject customer

  @RegressionTest
  Scenario: Verify that service provider admin is able to approve and reject customer 
    Given login with service provider admin credentials to the SDX portal
    And click on the 3 dotted icon for pending customer from the list and click on Reject link
    When enter reason for reject
    And  click on Save button for reject customer
    And Success message should appear for the customer rejected by SP login
    And click on status filter and enter Rejected in filter field and click on filter button 
    And click on the 3 dotted icon for rejected user in the list and click on Approve link
    And click on create new and approve button 
    Then success message should appear for user approved in application