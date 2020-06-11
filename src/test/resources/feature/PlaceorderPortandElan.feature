#Author: sumit.mishra@cloudsmartz.net
Feature: Place an order with Port and Elan 
  This feature deals with customer admin user is able to place new order with port and Elan.

  @PortandElan 
  Scenario: Verify that customer admin user is able to place new order with port and Elan.
    Given login to seaborn app with customer admin
    And click on the manage orders icon and place an order link
    And click on the 3dotted icon for  Ethernet U.N.I. Port and Add button
    And select Location porttype and capacity
    When enter valid portdisplayname and duration
    And click on Add to cart button
    When enter valid elanname and duration
    And select Latency protection Class Bandwidth and port
    And click on Add to cart button for elan
    And click on cart menu and place order button
    When enter valid Poreference and CommentsSpecialInstruction
    And select primary contact 247 contact and technical contact
    And click on next button and confirm order button
    Then success message should appear on the page
