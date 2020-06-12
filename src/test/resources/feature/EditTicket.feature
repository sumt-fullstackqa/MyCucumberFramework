#Author: ankur.bhardwaj@cloudsmartz.net

Feature: Edit the customer Ticket
  I want to Edit the customer ticket

  @editcustomerTicket
  Scenario: Verify that customer admin user is able to edit the ticket
    Given login to seaborn application with customer admin
    And click on the tickets menu icon
    When user click on edit ticket
    And add details
    Then ticket updated successfully


  