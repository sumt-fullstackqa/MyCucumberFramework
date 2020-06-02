#Author: sumit.mishra@cloudsmartz.net
Feature: Place an order with Port and Eline
  This feature deals with customer admin user is able to place new order with port and Eline.

  @RegressionTest
  Scenario: Verify that customer admin user is able to place new order with port and Eline.
    Given login to SDX Portal with customer admin
    And click on the manage orders icon and place an order
    And click on the 3dotted icon for  Ethernet U.N.I. Port and sub menu Add button
    And select Location and select porttype and select capacity
    When enter valid portdisplayname and valid duration value
    And click on Add to cart button for adding UNI Port
    And click on Eline section
    When enter valid elinename and duration
    And select Latency protection Class Bandwidth and Source port and select Destination location and select Destination Port
    And click on Add to cart button for eline
    And click on cart menu icon and place order button
    When enter valid Poreference and CommentsSpecialInstruction value
    And select primary contact 247 contact and select technical contact
    And click on next button and click on confirm order button
    Then success message should appear on the page that order has been confirmed
