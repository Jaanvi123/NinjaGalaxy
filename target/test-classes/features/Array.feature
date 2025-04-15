@tag
Feature: Array Page Functionality

  Background: 
    Given the user is on the DS Algo Portal
    When the user navigates to the "Array" page from the home page
    Then the page title should be "Array"

  Scenario: Navigate to "Arrays in Python" page
    When the user clicks on the "Arrays in Python" link
    Then the user should be navigated to the "Arrays in Python" page

  Scenario: Access "Try Here" editor from Arrays in Python page
    Given the user is on the "Arrays in Python" page
    When the user clicks on the "Try Here" Link
    Then the user should be redirected to the editor page

  Scenario: Execute Python code in Try Editor
    Given the user is on the Try Editor page
    When the user enters valid Python code and clicks on the Run button
    Then the output should display "Array test successful"

  Scenario: Navigate to "Arrays Using List" page
    When the user clicks on the "Arrays Using List" link
    Then the user should be on the "Arrays Using List" page

  Scenario: Navigate to "Basic Operations in Lists" page
    When the user clicks on the "Basic Operations in Lists" link
    Then the user should be on the "Basic Operations in Lists" page

  Scenario: Navigate to "Applications of Array" page
    When the user clicks on the "Applications of Array" link
    Then the user should be on the "Applications of Array" page

  Scenario: Attempt Practice Questions
    When the user clicks on the "Practice Questions" link
    Then the user should be navigated to the "Practice Questions" page
