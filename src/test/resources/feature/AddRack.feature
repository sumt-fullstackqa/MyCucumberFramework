#Author: sumit.mishra@cloudsmartz.net
Feature: Add Inventory Rack
  This feature deals with Service Provider user is able to add Rack.

  @AddRack
  Scenario: Verify that service provider admin user is able to add Rack
    Given login to seaborn application with service provider admin user
    And click on the inventory management menu and Rack link
    And click on the Add Rack button
    And select Rack type and select Manufacturer name and select location
    When enter model name and size and notes
    And click on save button for Add Rack form
    Then success message should be shown on the page
