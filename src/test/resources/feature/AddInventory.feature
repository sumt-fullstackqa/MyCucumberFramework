#Author: sumit.mishra@cloudsmartz.net
Feature: Add Inventory
  This feature deals with Service Provider user is able to add Inventory.
  
  @Inventory
  Scenario: Verify that service provider admin user is able to add Inventory
    Given login to seaborn with service provider admin user
    And click on the inventory management menu and Inventory link
    And click on the Add Inventory button
    And select Device Model and select Location and select Vlan Start Range and select Vlan End Range and select Rack and select rack start unit
    When enter Device name and inventory ID and serial number and IPAddress and Inventorynotes and inventory status
    And click on Device for LOA
    And click on Save button
    Then success message should be shown for inventory added in application
