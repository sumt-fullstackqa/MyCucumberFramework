#Author: sumit.mishra@cloudsmartz.net
Feature: Add Inventory Interconnect
  This feature deals with Service Provider user is able to add Interconnect.

  @RegressionTest
  Scenario: Verify that service provider admin user is able to add Interconnect
    Given login to seaborn app with service provider admin user
    And click on the inventory management menu and Interconnect link
    And click on the Add Interconnect button
    And select Source Device and select Destination Device and select Source port and select Destination port
    When enter Interconnect ID and Circuit ID and Description
    And click on Save button for interconnect form
    Then success message should be shown for interconnect added in application
