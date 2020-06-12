#Author: ankur.bhardwaj@cloudsmartz.net

Feature: Export file in Excel and PDF format
  I want to export files in excel and pdf format for tickets

  @Exportfile
  Scenario: Export tickets in excel and pdf format
    Given login to seaborn application with customer admin
    And click on the tickets menu icon
    When I click on Export to excel 
    Then excel file downloaded with tickets data
    When I click on Export to pdf button
    Then pdf file downloaded with ticket data