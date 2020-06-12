#Author: ankur.bhardwaj@cloudsmartz.net

Feature: Reopen closed ticket
  I want to reopen the closed ticket

   @Reopenclosedticket
   Scenario: Verify that customer admin user is able to reopen the closed ticket
    Given login to seaborn application with customer admin
    And click on the tickets menu icon
    When user clicks on action icon and select close Ticket
    Then ticket closed successfully and move to closed ticket tab
    And validate ticket on closed tab screen
    When user click on Reopen ticket
    Then ticket moves to Open ticket tab