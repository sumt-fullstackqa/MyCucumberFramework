#Author: sumit.mishra@cloudsmartz.net
Feature: Raise New Ticket with Customer login
  This feature deals with customer admin user is able to raise new ticket.

  @RaiseNewTicket
  Scenario: Verify that customer admin user is able to raise new ticket
    Given login to seaborn application with customer admin
    And click on the tickets menu icon
    And click on the raise ticket button
    When enter valid ticketname and description
    And select Ticketfor
    And click yes for Is your service down radio button
    And click on select files and add attachment
    And click on save button for this form
    Then success message should be shown

  