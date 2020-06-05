#Author: sumit.mishra@cloudsmartz.net
Feature: Assign Port Feature
  This feature deals with service provider admin is able to assign new port to the company 

  @RegressionTest
  Scenario: Verify that service provider admin is able to assign new port to the company
    Given login to SDX  app with service provider admin
    And click on the inventory management menu and manage port link
    And click on the 3 dotted icon for first company from the list and click on Assign Port link
    And select location and select Inventory and select port and select Billing account
    When enter Port display name for assign port
    And click on add button 
    And click on checkbox for the added value
    And clcik on Assign button 
    Then success message should appear for assigned port to the company