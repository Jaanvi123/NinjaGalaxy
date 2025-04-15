@tag
Feature: User Login on DS Portal

  Scenario: Successful user login with valid credentials
    Given User navigate to the login page
    When User enter valid credentials with username "Ninja_Galaxy" and password "We_team3"
    Then User click the "Login" button and should be redirected to the homepage

  Scenario: Login with empty Username
    Given User navigate to the login page
    When User enter an empty email field and user click the "Login" button
    Then user see an error message saying "Login is requried"

  Scenario: Login with empty password
    Given User navigate to the login page
    When User enter an Username "Ninja_Galaxy" and I leave the password field empty
    Then User click the "Login" button should see an error message saying "Password is required"

  Scenario: Login with invalid Username format
    Given User navigate to the login page
    When User enter an invalid Username"invalid-Username" and User enter a password "We_team3"
    Then User click the "Login" button and user should see an error message saying "Invalid Username format"

  Scenario: Login with incorrect credentials
    Given User navigate to the login page
    When User enter an Username "incorrectuser@example.com" and enter a password "incorrectPassword" and click the "Login" button
    Then I should see an error message saying "Invalid credentials"
