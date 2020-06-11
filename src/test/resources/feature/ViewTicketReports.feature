#Author: sumit.mishra@cloudsmartz.net
Feature: View Ticket Reports
  This feature deals with Service Provider user is able to view all Reporting Tabs.

  @ViewTicketReports
  Scenario: Verify that service provider admin user is able to view ticketing reports for all reports tab
    Given login to seaborn portal with service provider admin user
    And click on the Ticket management menu and click on Reports
    And click on the overdue tickets tab and click on Ticket response rate tab and click on First time response and click on ticket count and click on outage tickets tab and click on unattended tickets tab and click on Reopened tickets tab
    Then data should be visible in grid
