#Author: sumit.mishra@cloudsmartz.net
Feature: Edit user Feature
  This feature deals with Service Provider user is able to edit user.

  @RegressionTest
  Scenario: Verify that service provider user is able to edit user
    Given login to SDX portal with service proivder admin
    And click on the user management menu icon for SP
    And click on the 3 dotted menu icon for first user and click on edit link
    When clear and enter new valid emailaddress and clear and enter new firstname and clear and enter new middlename and clear and enter new lastname and clear and enter new phonenumber
    And select new county and select the new role
    And click on update button
    Then success message should appear for user updated in application
    