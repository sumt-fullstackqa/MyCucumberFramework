#Author: sumit.mishra@cloudsmartz.net
Feature: view order with customer login
  This feature deals with customer admin user is able to view order from order list.

  @vieworderwithcustomer
  Scenario: Verify that customer admin user is able to view order from order list
    Given login to seaborn with customer admin user
    And click on the manage orders icon and order list link
    And click on the 3dotted icon for first order from the list and click on view details
    And click on previous button
    Then user should be navigated back to order list page.
