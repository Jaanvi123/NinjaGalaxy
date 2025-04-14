@homePage
Feature: Validate the home page

  @tag1
  Scenario: Verify that the user is able to navigate to home page
    Given The user enters ds-algo launch page on the browser
    When User clicks on get started button
    Then User should be landed on the page with title "NumpyNinja"
    

 