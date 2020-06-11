#Author: ankur.bhardwaj@cloudsmartz.net
Feature: Edit the company details
  I want to edit the company details

  @EditCompany
  Scenario: Edit the company Details
    Given login to SDX with service provider admin
    And navigates to company List screen
    When I click on edit link
    And update the mandatory company details
    And click on the update company button
    Then company details should be updated successfully
