#Author: sumit.mishra@cloudsmartz.net
Feature: Add Inventory Location
  This feature deals with Service Provider user is able to add Location.

  @Location
  Scenario: Verify that service provider admin user is able to add Location
    Given login to portal with service provider admin user
    And click on the inventory management menu and Location link
    And click on the Add New Location button
    And select Country and select State and select City
    When enter Location Name and Location code and Address and othercity name and Zip code
    And click on Save button for New Location form
    Then success message should be shown for new Location added in application
