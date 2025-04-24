Feature: Tree

  Scenario: Verify that the user is able to navigate to the Tree data structure page
    Given the user is in the DS Algo portal after signing in
    When the user clicks the Get Started button in the Tree panel
    Then the user should be redirected to the Tree data structure page

  Scenario: Verify that user is able to navigate to tree data structure page through dropdown
    Given the user is in the home page after signing in
    When The user selects tree item from the drop down menu
    Then the user should be redirected to the Tree data structure page

  Scenario: Verify that the user is able to navigate to the Overview of Trees page
    Given the user is on the Tree page after signing in
    When the user clicks the Overview of Trees button
    Then the user should be redirected to the Overview of Trees data structure page
