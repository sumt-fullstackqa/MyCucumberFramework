#Author: ankur.bhardwaj@cloudsmartz.net

Feature: Network Template
  I want to add the network template

 @RegressionTest
  Scenario: Add the network template
    Given login to seaborn application with customer admin
    And click on the service Management
    When I click on services name Bandwidth on Demand
    And I click on Network and click on template 
    When I click on Add New Template
    And add Template details
    And I click on save button 
    Then template should created successfully