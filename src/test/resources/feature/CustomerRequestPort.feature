#Author: sumit.mishra@cloudsmartz.net
Feature: Customer Request Port Feature
  This feature deals with customer admin user is able to request port.

  @CustomerRequestPort
  Scenario: Verify that Customer admin user is able to request port.
    Given login with customer admin to the SDX portal
    And click on the Assigned port menu icon
    And click on the Request port button
    And select Location and Port type and Billing account
    When enter port display name
    And click on the save button for requesting port
    Then success message should appear for new port request
