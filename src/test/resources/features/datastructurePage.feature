@tag
Feature: Datastructure functionality

  @tag1
  Scenario Outline: user is able to navigate to "Data Structures - Introduction" page
    Given The user is in the Home page after logged in
    When The user clicks the "Get Started" button in Data Structures - Introduction
    Then The user is on Datastructure introduction page
    Given The user is in the "Time Complexity" page
    When The user clicks "Time Complexity" button
    Then The user should be redirected to "Time Complexity"
    When The user clicks the "Practice Questions" button
    Then The user should be redirected to "Practice Questions"
    When The user clicks "Try Here" button
    Then The user should be redirected to a page having an try Editor with a Run button to test
    Given The user is in the tryEditor page
    When The user clicks the Run Button with valid code in the Editor
    Then The user should able to see valid output
    Given The user on the tryEditor page
    When the user writes inavalid code 
    Then the error window pops up 
