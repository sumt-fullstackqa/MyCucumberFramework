#Author: sumit.mishra@cloudsmartz.net
Feature: Deactivate and Activate Customer User Feature
  This feature deals with customer admin user is able to deactivate and activate customer user

  @RegressionTest
  Scenario: Verify that Customer admin user is able to deactivate and activate customer user
    Given login with customer credentials to the seaborn portal
    And click on user management menu icon
    And click on the 3 dotted icon for first customer from the list and click on deactivate link
    And click on ok button for confirmation pop up
    And Success message should appear for the user deactivated
    And click on status filter and click on inactive radio button and click on filter button
    And click on the 3 dotted icon for deactivated customer in the list and click on Activate link
    And click on ok button for confimation pop up of activate user
    Then success message should appear for customer user activated in application
