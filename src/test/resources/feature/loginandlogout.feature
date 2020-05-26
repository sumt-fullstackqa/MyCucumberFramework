#Author: sumit.mishra@cloudsmartz.net

Feature: Login and Logout Feature
  This feature deals with user is able to login with valid credentials and logout successfully.

  @RegressionTest
  Scenario: User should able to login in seaborn with valid credentials
    Given I navigate to the seaborn login page
    When user enter Username and Password
    And I click on SignIn button
    Then Login should be successful and click on signout button to logout of the application

 

 


  




 

 

  



