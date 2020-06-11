#Author: sumit.mishra@cloudsmartz.net
Feature: Add Inventory Library
  This feature deals with Service Provider user is able to add Library.

 @Library
  Scenario: Verify that service provider admin user is able to add library
    Given login to seaborn application with service provider admin
    And click on the inventory management menu and Library link
    And click on the Add library button
    And select device type and select Manufacturer name
    When enter device model and notes and rack size
    And click on save button for Add library form
    Then success message should be displayed on the page
