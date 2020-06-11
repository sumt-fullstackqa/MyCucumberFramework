#Author: sumit.mishra@cloudsmartz.net
Feature: Add New Billing Account
  This feature deals with customer admin user is able to add new billing account.

  @AddNewBillingAccount
  Scenario: Verify that customer admin user is able to add new billing account
    Given login to seaborn portal with customer admin
    And click on the billing accounts managemengt menu icon
    And click on the add new account button
    When enter valid BillingCompany BillingAddress BillingPhoneNumber Billingcity BillingPostalCode and BillingFaxNumber
    And select currency country and state
    And click on the billing account save button
    Then success message should display on page
