#Author: sumit.mishra@cloudsmartz.net
Feature: Place an order with Port and ETree
  This feature deals with customer admin user is able to place new order with Port and ETree

  @PortandETree
  Scenario: Verify that customer admin user is able to place new order with port and ETree .
    Given login to SDX Portal app with customer admin
    And click on the manage orders icon and place an order sub menu
    And click on the 3dotted icon for  Ethernet U.N.I. Port and Add button link
    And select Location and select porttype and select capacity for UNI port
    When enter valid portdisplayname and valid duration value for UNI port
    And click on Add to cart button for adding UNI Port to the cart
    And click on ETree section
    When enter valid ETreename and duration
    And select Latency protection Class Bandwidth and select Source port and select Destination location and select Destination Port
    And click on Add to cart button for Etree
    And click on cart and place order button
    When enter valid Poreference and CommentsSpecialInstruction value for ETree
    And select primary contact 247 contact and select technical contact for ETree
    And click on next button and click on confirm order button for ETree
    Then success message should appear on the page that order has been confirmed for ETree
