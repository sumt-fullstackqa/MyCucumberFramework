#Author: sumit.mishra@cloudsmartz.net


Feature: Add Company Feature
  This feature deals with Service Provider user is able to add new company.

 @Addcompany
  Scenario: Verify that service provider user is able to add new company
    Given login with valid credentials
    And click on the add new company button
    When enter valid Company name email first name last name contact number  Corporate Contact Number tax id postal code Address and city
    And select county and state
    And click on save button
    Then success message should be displayed.
