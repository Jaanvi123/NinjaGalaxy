
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
    Scenario: The user is able to navigate home page
    Given The user is in the ds-algo launch page
    
    When The user clicks on "Get Started" button
   	Then The user navigate home page
   
    Given The user is on the Home page
    When The user clicks on dropdown "Data Sturcture"
    Then User should be able to see list of all the options in the dropdown
    
    
    Given The user is on the Home page
    When The user clicks on dropdown "Array"or"stack"or"linked List"or"Queue"or"Graph"
    Then the warning messaage poped "You are not Logged in"
    
    Given The user navigate to Login Page
    When  User click on Sign in link
    Then  The user is Login page
     
    Given The user navigate to Register Page
    When  User click on Register link
    Then  The user is Register page
    
    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
