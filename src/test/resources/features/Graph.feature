Feature: Graph Page Functionality

  Background: 
    Given The user is on the DS Algo Home Page
    When The user navigates to MainGraph page from the home page

  Scenario: Verify user is on MainGraph page
    Given The user is on the MainGraph page
    Then The page title should be Graph

  Scenario: Verify Graph navigation
    Given The user is on the MainGraph page
    When The user clicks the Graphhome page link
    Then The user should be navigated to the Graph home page

  Scenario: Verify Try Here editor is accessible for Graph
    Given The user is on the Graphhome page
    When The user clicks on Try Here button
    Then The user should be redirected to the editor page

  Scenario: Execute Python code in Try Editor
    Given The user is on the Try Editor page
    When The user enters valid Python code:
    And Clicks on the Run button
    Then The output should display Graph Link

  Scenario: Navigate to Graph Representations page
    Given The user is on the MainGraph page
    When The user clicks on the Graph Representations link
    Then The user should be navigated to Graph Representations page
