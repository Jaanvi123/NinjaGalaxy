@homePage
Feature: DS Algo Sign in Page
  I want to use this template for my feature file

  @homePage
  Scenario: Signin page validation with no username and password
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after leaving the <username> textbox and <password> textbox blank
    Then The error message "Please fill out this field." appears below Username textbox

  @homePage
  Scenario Outline: Signin page validation with username and  no password
    Given user is on the DS Algo Sign in Page
    And The user clicks login button after entering the userName and leaves password textbox blank <rowNumber> <sheetName>
    Then The error message "Please fill out this field." appears below Pwd textbox

    Examples: 
      | rowNumber | sheetName        |
      |         1 | validCredentials |

  @homePage
  Scenario Outline: Signin page validation with no username
    Given user is on  DS Algo Sign in Page
    When The user clicks login button after entering the passWord only <rowNumber> <sheetName>
    Then The error message "Please fill out this field." appears below username textbox

    Examples: 
      | rowNumber | sheetName        |
      |         1 | validCredentials |

  @homePage
  Scenario Outline: Signin page validation with invalid username and invalid  password
    Given user lands on DS Algo Sign in page
    When The user clicks login button after entering invalid UserName and invalid PassWord <rowNumber> <sheetName>
    Then The error message "Invalid Username and Password". appears below Username textbox

    Examples: 
      | rowNumber | sheetName         |
      |         1 | invalidCredential |

  #Examples:
  #| UserName 					 | PassWord |
  #| Ninja_Galaxy11      | password1  |
  @homePage
  Scenario Outline: Signin page validation with valid username and valid password
    Given The  user land on DS Algo Sign in page
    When The user clicks login button after entering valid UserName and valid PassWord <rowNumber> <sheetName>
    Then The user should land in Data Structure Home Page "You are logged in"

    Examples: 
      | rowNumber | sheetName        |
      |         1 | validCredentials |
    #Examples: 
      #| UserName			| PassWord |
      #| Ninja_Galaxy | We_team3 |
