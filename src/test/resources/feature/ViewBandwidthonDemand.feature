#Author: ankur.bhardwaj@cloudsmartz.net
Feature: view networks
  I want to use this template for my feature file

  @networks
  Scenario: view networks
    Given login to seaborn application with customer admin
    And click on the service Management
    When I click on services name Bandwidth on Demand
    Then I validate it navigates to bandwidth on demand screen
    When I click on Networks
    And click on view networks
    Then service details should open
    And details should displayed on screen
