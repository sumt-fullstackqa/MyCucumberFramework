#Author: ankur.bhardwaj@cloudsmartz.net

Feature: View Ticket details
  I want to view the tickets details

  @ViewTicketdetails
  Scenario: View Tickets Details
    Given login to seaborn application with customer admin
    And click on the tickets menu icon
    When user selects view tickets option of any tickets
    Then view tickets details screen is opened
    And ticket related details are shown
