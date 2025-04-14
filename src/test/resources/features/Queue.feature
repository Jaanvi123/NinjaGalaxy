Feature: Queue Page Functionality

  Background: 
    Given The user is on the DS Algo Home Page
    When The user navigates to Queue page from the home page

  Scenario: Verify user is on Queue page
    Given The user is on the Queue page
    Then The page title should be Queue

  Scenario: Verify Implementation of Queue in Python navigation
    Given The user is on the Queue page
    When The user clicks on Implementation of Queue in Python link
    Then The user should be navigated to the Implementation of Queue in Python page

  Scenario: Verify Try Here editor is accessible for Implementation of Queue in Python
    Given The user is on the Implementation of Queue in Python page
    When The user clicks on Try Here button
    Then The user should be redirected to the editor page

  Scenario: Execute Python code in Try Editor
    Given The user is on the Try Editor page
    When The user enters valid Python code and Clicks on the Run button
    Then The output should display Queue

  Scenario: Navigate to Implementation using collection.deque
    Given The user is on the Queue page
    When The user clicks on the Implementation using collection.deque
    Then The user should be on the Implementation using collection.deque page

  Scenario: Navigate to Implementation using array page
    Given The user is on the Queue page
    When The user clicks on the Implementation using array link
    Then The user should be on the Implementaion using array page
