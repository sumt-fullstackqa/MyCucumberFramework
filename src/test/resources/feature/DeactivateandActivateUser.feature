#Author: sumit.mishra@cloudsmartz.net
Feature: Deactivate and Activate User Feature
  This feature deals with service provider admin user is able to deactivate and activate user

  @DeactivateandActivateUser
  Scenario: Verify that service provider admin is able to deactivate and activate user
    Given login with service provider admin credentials to the seaborn portal
    And click on user management menu icon with SP login
    And click on the 3 dotted icon for first customer from the list and click on deactivate link with SP login
    And click on ok button for confirmation pop up with SP login
    And Success message should appear for the user deactivated by SP login
    And click on status filter and click on inactive radio button and click on filter button with SP login
    And click on the 3 dotted icon for deactivated user in the list and click on Activate link with SP login
    And click on ok button for confimation pop up of activate user with SP login
    Then success message should appear for user activated in application
