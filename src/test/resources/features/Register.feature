Feature: Registration Page

  Background: DS Portal New user registration page
    Given The user is on the new user registration page
  #TC01
  #Scenario Outline: Verify that user receives error message for all empty fields during registration
    #When The user clicks Register button with all fields empty on registration form from sheetname "<Sheetname>" and row <RowNumber>
    #Then The error Please fill out this field. appears below Username textbox
    #Examples:
      #| Sheetname | RowNumber |
      #| Register  |         0 |
  #TC02
  #Scenario Outline: Verify that user receives error message for empty Password and Password confirmation fields during registration
    #When The user clicks Register button after entering Username with other fields empty from sheetname "<Sheetname>" and row <RowNumber>
    #Then The error message Please fill out this field. appears below Password textbox
    #Examples:
      #| Sheetname | RowNumber |
      #| Register  |         1 |
  #TC03
  #Scenario Outline: Verify that user receives error message for empty Password Confirmation field during registration
    #When The user clicks Register button after entering Username and Password leaving Password Confirmation field empty from sheetname "<Sheetname>" and row <RowNumber>
    #Then The error message Please fill out this field. appears below  Password Confirmation textbox
    #Examples:
      #| Sheetname | RowNumber |
      #| Register  |         2 |
  #TC04
  #Scenario Outline: Verify that user receives error message for invalid username field during registration
    #When The user clicks Register button after entering a username with spacebar characters other than digits and symbols from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see error msg after entering invalid data
    #Examples:
      #| Sheetname | RowNumber |
      #| Register  |         3 |
  #TC05
  #Scenario Outline: Verify that user receives error message for invalid password field during registration
    #When The user clicks Register button after entering a password with only numeric data from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see error msg after entering invalid data in password fields
    #Examples:
      #| Sheetname | RowNumber |
      #| Register  |         4 |
  #TC06
  #Scenario Outline: Verify that user receives error message for Password field less than eight characters during registration
    #When The user clicks Register button after entering a password with less than eight characters from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see error msg after entering less than eight characters
    #Examples:
      #| Sheetname | RowNumber |
      #| Register  |         5 |
  

  #TC07
  Scenario: Verify that user is able to click on login link from Registration page
    When The user clicks login link from Registration page
    Then The user should be landed on login page
  #TC08
  #Scenario: Verify that user is able to click on Sign in link from Registration page
    #When The user clicks Sign in link from Registration page
    #Then The user should be landed on login page


      