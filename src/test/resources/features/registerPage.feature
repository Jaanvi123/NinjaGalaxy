@tag
Feature: User Registration on DS Portal

  Scenario: Successful user registration with valid details
    Given User navigate to the registration page
    When User enter valid details in the registration form and click the "Register" button
    Then User should be redirected to the home page and see alert message of logged in

  Scenario: Registration with missing Username
    Given User navigate to the registration page
    When User enter the details without an Username and click the "Register" button
    Then User should see an error message saying "Username is required"

  Scenario: Registration with invalid Username format
    Given User navigate to the registration page
    When User enter an invalid Username "invalid"and I click the "Register" button
    Then User should see an error message saying "Invalid Username format"

  Scenario: Registration with already existing email
    Given User navigate to the registration page
    When User enter the"Username" and fill in other required details and click the "Register" button
    Then User should see an error message saying "Password mismatch" and press "login"
