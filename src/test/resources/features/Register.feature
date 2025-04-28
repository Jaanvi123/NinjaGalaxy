@tag
Feature: DS Portal Registration feature

  Background: DS Portal New user registration page
    Given The user is on the new user registration page

  Scenario Outline: Verify that user receives error message for all empty fields during registration
    When The user clicks Register button with all fields empty on registration form from sheetname "<Sheetname>" and row <RowIndex>
    Then It should display an error "Please fill out this field." below Username textbox

    Examples: 
      | Sheetname | RowIndex |
      | Register  |        0 |

  Scenario Outline: Register with mismatched passwords
    When The User clicks Register button after entering different passwords in sheetname "<Sheetname>" and row <RowIndex>
    Then The user see warning message "password_mismatch:The two password fields didn’t match." below

    Examples: 
      | Sheetname | RowIndex |
      | Register  |        1 |

  Scenario Outline: Register using valid data from Excel
    When User enters valid username, password,confirm_password from sheetname "<Sheetname>" and row  <RowIndex>
    Then The User should be redirected to HomePage of DS_Algo and see successful message "You are logged in"  on the DS_Algo HomePage
    When User clicks on signout
    Then User lands on homePage with signout

    Examples: 
      | Sheetname | RowIndex |
      | Register  |        2 |
