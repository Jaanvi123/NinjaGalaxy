
Feature: DS Portal SignIn Feature

  Background: User is on DS Algo Sign in Page
    Given The user is on the DS Algo Sign in Page

  Scenario Outline: Verify that user able to land on Home page after entering valid Username and Password fields
    When The user clicks login button after entering valid username and valid password from "<Sheetname>" and row <RowNumber>
    Then The user should land in Data Structure Home Page with message "You are logged in"

    Examples: 
      | Sheetname | RowNumber |
      | login     |        0 |
