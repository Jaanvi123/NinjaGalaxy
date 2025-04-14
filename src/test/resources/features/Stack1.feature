Feature: Stack Page Functionality

  Background: 
    Given The user is on the DS Algo Home Page
    When The user navigates to Stack page from the home page

  Scenario: Verify user is on Stack page
    Given The user is on the Satck page
    Then The page title should be Stack

  Scenario: Verify Operations in Stack navigation
    Given The user is on the Operations in Stack page
    When The user clicks on Operations in Satck link
    Then The user should be navigated to the Opeartions in Stack page

  Scenario: Verify Try Here editor is accessible for Opeartions in Stack
    Given The user is on the Opeartions in Stack page
    When The user clicks on Try Here button
    Then The user should be redirected to the editor page

  Scenario: Execute Python code in Try Editor
    Given The user is on the Try Editor page
    When The user enters valid Python code:
    And Clicks on the Run button
    Then The output should display Stack Opeartion

  Scenario: Navigate to Implementation page
    Given The user is on the Satck page
    When The user clicks on the Implementation link
    Then The user should be on the Implementation page

  Scenario: Navigate to Applications page
    Given The user is on the Satck page
    When The user clicks on the Applications link
    Then The user should be on the Applications page
