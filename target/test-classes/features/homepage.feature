@tag
Feature: Navigation and Warning Validation

  @tag1
  Scenario: Verify that the user is able to navigate to home page
    Given The user is in the ds-algo launch page
    When The user clicks on the "Get Started" button
    Then The user should land on dsAlgo home portal

  @tag2
  Scenario: Warning message on unauthenticated access
    Given The user is on the Home page
    When The user clicks on dropdown "Data Structure"
    Then The user should see all the options of "Array,Linked List,Stack,Queue,Tree,Graph"
    Given The user is on the Home page
    When The user clicks on dropdown "Array"
    Then The user should see warning message
