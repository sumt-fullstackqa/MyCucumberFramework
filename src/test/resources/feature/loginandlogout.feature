#Author: sumit mishra 

Feature: Login and Logout Feature
  This feature deals with user is able to login with valid credentials and logout successfully.

  @LoginandLogout
  Scenario: User should able to login in to website with valid credentials
    Given I navigate to the web URL
    And   click on login link 
    When user enter Username and Password
    And I click on SignIn button
    Then Login should be successful and click on signout button to logout of the application

 

 


  




 

 

  



