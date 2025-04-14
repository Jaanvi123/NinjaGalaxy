Feature: TreePage

  Scenario: Verify that the user is able to navigate to the Tree data structure page
    Given the user is in the DS Algo portal after signing in
    When the user clicks the Get Started button
    Then the user should be redirected to the Tree data structure page

  Scenario: Verify that user is able to navigate to tree data structure page through dropdown
    Given the user is in the home page and is signed in
    When The user selects tree item from the drop down menu
    Then the user should be redirected to the Tree data structure page

  Scenario: Verify that the user is able to navigate to the Overview of Trees page
    Given the user is on the Tree page after signing in
    When the user clicks the Overview of Trees button
    Then the user should be redirected to the Overview of Trees data structure page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Overview of Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  ##Terminologies#
  Scenario: Verify that the user is able to navigate to the Terminologies page
    Given the user is on the Tree page after signing in
    When the user clicks the Terminologies button
    Then the user should be redirected to the Terminologies data structure page

  Scenario: Navigate to Try Editor for Tree Data Structure Terminologies
    Given The user is on the Terminologies page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Types of Trees
  Scenario: Verify that the user is able to navigate to Types of Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Types of Trees link
    Then the user should be redirected to the Types of Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Types of Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Tree Traversals
  Scenario: Verify that the user is able to navigate to Traversals page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Tree Traversals link
    Then the user should be redirected to the Tree Traversals page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Tree Traversals page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  #Traversals Illustration
  Scenario: Verify that the user is able to navigate to Traversals Illustration page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Traversals Illustration link
    Then the user should be redirected to the Traversals Illustration page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Traversals Illustration page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  ### Binary Trees ###
  Scenario: Verify that the user is able to navigate to Binary Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Binary Trees link
    Then the user should be redirected to the Binary Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Binary Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  #### Types of Binary Trees###
  Scenario: Verify that the user is able to navigate to Types of Binary Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Types of Binary Trees link
    Then the user should be redirected to the Types of Binary Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Types of Binary Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Implementation in Python#
  Scenario: Verify that the user is able to navigate to Implementation In Python page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Implementation In Python link
    Then the user should be redirected to the Implementation In Python page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Implementation in Python page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Binary Tree Traversals #
  Scenario: Verify that the user is able to navigate to Binary Tree Traversals page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Binary Tree Traversals link
    Then the user should be redirected to the Binary Tree Traversals page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Binary Tree Traversals page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Implementation of Binary Trees#
  Scenario: Verify that the user is able to navigate to Implementation Of Binary Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Implementation Of Binary Trees link
    Then the user should be redirected to the Implementation Of Binary Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Implementation of Binary Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  #Applications of Binary Trees#
  Scenario: Verify that the user is able to navigate to Applications Of Binary Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Applications Of Binary Trees link
    Then the user should be redirected to the Applications Of Binary Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Applications of Binary Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Binary Search Trees#
  Scenario: Verify that the user is able to navigate to Binary Search Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Binary Search Trees link
    Then the user should be redirected to the Binary Search Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Binary Search Trees page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  # Implementation Of BST #
  Scenario: Verify that the user is able to navigate to Implementation of Binary Search Trees page after signing in
    Given the user is on the Tree page after signing in
    When the user clicks the Implementation of Binary Search Trees link
    Then the user should be redirected to the Implementation of Binary Search Trees page

  Scenario: Navigate to Try Editor for Tree Data Structure
    Given The user is on the Implementation of BST page in the DS Algo portal
    When The user clicks Try Here button on the  page
    Then The user is redirected to a page having Editor with run button for Tree

  Scenario: User clicks the Run button without entering any code for Tree
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user clicks on the Run button without entering any code for Tree
    Then nothing happens and no error message is displayed for Tree

  Scenario: User writes invalid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes invalid Python code in the editor and clicks the Run button for Trees
    Then the user should see an error message in an alert window for Trees

  Scenario: User writes valid Python code and clicks Run button
    Given the user is on the tryEditor page of Trees with an empty code editor
    When the user writes valid Python code in the editor and clicks the Run button for Trees
    Then the user should be able to see output in the console for Trees

  Scenario: Tree Practice Questions
    Given The user is on the Implementation of BST page in the DS Algo portal
    When The user clicks Practice Questions link
    Then The user is redirected to Practice Questions page.
