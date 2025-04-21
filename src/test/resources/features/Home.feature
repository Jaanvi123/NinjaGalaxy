@homePage
Feature: Browser page

  I want to use this template for my feature file

  @homePage
  Scenario: Open the browser
    Given The user should open the browser and enters the DS_Algo Portal  
    Then The user should be landed on the DS_Algo Get Started page with message "You are at the right place"
    When User clicks on get started button
    Then User should be landed on the data structure page with title "NumpyNinja"
    