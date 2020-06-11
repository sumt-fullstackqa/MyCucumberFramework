#Author: ankur.bhardwaj@cloudsmartz.net
Feature: View company details
  I want to view the company details

  @Viewcompanydetails
  Scenario: View company details
    Given login to SDX with service provider admin
    And navigates to company List screen
    When I click on any company view details
    Then company details screen is opened
    And company details should displayed
