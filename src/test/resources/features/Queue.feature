Feature: Queue Page Features

  Background: 
    Given The user is on home page of ds
    When The user clicks Sign in link and enters valid credentials for Queue page
    Then The user lands on the queue page on clicking Get started button for queue module

  ###Implementation of queue in python
  ##TC01
  Scenario: Verify that the user is able to navigate to the Implementation of queue in python page
    Given the user is on the Queue page after signing in
    When the user clicks the Implementation of queue in python link
    Then the user should be redirected to the Implementation of queue in python data structure page

  #TC02
  Scenario: Navigate to Try Editor for Implementation of queue in python in Queue module
    Given The user is on the Implementation of queue in python page
    When The user clicks Try Here button on the Implementation of queue in python page
    Then The user is redirected to a page having Editor with run button for Implementation of queue in python

  #NO Code
  #TC03
  Scenario: User clicks the Run button without entering any code for Queue
    Given The user is on tryEditor page and clicks Try here button in Implementation of queue
    When The user enters an empty code in editor of Implementation of queue and clicks Run button
    Then No error message is displayed for Implementation of queue

  #Valid Code
  #TC04
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page after clicking Try here button in Implementation of queue
    When The user writes valid Python code in the editor of Implementation of queue page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Implementation of queue

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC05
  Scenario Outline: User writes Invalid code and clicks Run button on Implementation of queue in python Try Editor page
    Given The user is on the tryEditor page and clicks Try here button in Implementation of queue link
    When The user writes invalid code in the editor Implementation of queue and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Implementation of queue in python

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC06
  Scenario: Verify that the user is able to navigate to Practice Questions page from Implementation of queue in python page
    Given The user is on the Implementation of queue page
    When The user clicks the Practice Questions link from the Implementation of queue page
    Then The user should be redirected to the Practice Questions page from Implementation of queue in python page

  ##Implementation using collections deque
  ##TC07
  Scenario: Verify that the user is able to navigate to the Implementation using collections deque
    Given The user is in Queue page after signing in
    When the user clicks the Implementation using collections deque
    Then the user should be redirected to the Implementation using collections deque data structure page

  ##TC08
  Scenario: Navigate to Try Editor for Implementation using collections deque in Queue module
    Given The user is on the Implementation using collections deque
    When The user clicks Try Here button on the Implementation using collections deque
    Then The user is redirected to a page having Editor with run button for Implementation using collections deque

  ##TC09
  Scenario: User clicks the Run button without entering any code for Queue
    Given The user is on tryEditor page and clicks Try here button in Implementation using collections deque
    When The user enters an empty code in editor of Implementation using collections deque and clicks Run button
    Then No error message is displayed for Implementation using collections deque

  ##TC10
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page after clicking Try here button in Implementation using collections deque
    When The user writes valid Python code in the editor of Implementation using collections deque and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Implementation using collections deque

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC11
  Scenario Outline: User writes Invalid code and clicks Run button on Implementation using collections deque Try Editor page
    Given The user is on the tryEditor page and clicks Try here button in Implementation using collections deque
    When The user writes invalid code in the editor Implementation using collections deque and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Implementation using collections deque

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC12
  Scenario: Verify that the user is able to navigate to Practice Questions page from Implementation using collections deque
    Given The user is on the Implementation using collections deque
    When The user clicks the Practice Questions link from the Implementation using collections deque
    Then The user should be redirected to the Practice Questions page from Implementation using collections deque

  ##Implementation using array
  ##TC13
  Scenario: Verify that the user is able to navigate to the Implementation using array
    Given The user is in Queue page after signing in
    When the user clicks the Implementation using array
    Then the user should be redirected to the Implementation using array data structure page

  ##TC14
  Scenario: Navigate to Try Editor for Implementation using array in Queue module
    Given The user is on the Implementation using array
    When The user clicks Try Here button on the Implementation using array
    Then The user is redirected to a page having Editor with run button for Implementation using array

  ##TC15
  Scenario: User clicks the Run button without entering any code for Queue
    Given The user is on tryEditor page and clicks Try here button in Implementation using array
    When The user enters an empty code in editor of Implementation using array and clicks Run button
    Then No error message is displayed for Implementation using array

  ##TC16
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page after clicking Try here button in Implementation using array
    When The user writes valid Python code in the editor of Implementation using array and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Implementation using array

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC17
  Scenario Outline: User writes Invalid code and clicks Run button on Implementation using array Try Editor page
    Given The user is on the tryEditor page and clicks Try here button in Implementation using array
    When The user writes invalid code in the editor Implementation using array and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Implementation using array

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC18
  Scenario: Verify that the user is able to navigate to Practice Questions page from Implementation using array
    Given The user is on the Implementation using array
    When The user clicks the Practice Questions link from the Implementation using array
    Then The user should be redirected to the Practice Questions page from Implementation using array

  ##TC19
  Scenario: Verify that the user is able to navigate to the Queue operations
    Given The user is in Queue page after signing in
    When the user clicks the Queue operations
    Then the user should be redirected to the Queue operations data structure page

  ##TC20
  Scenario: Navigate to Try Editor for Queue operations in Queue module
    Given The user is on the Queue operations
    When The user clicks Try Here button on the Queue operations
    Then The user is redirected to a page having Editor with run button for Queue operations

  ##TC21
  Scenario: User clicks the Run button without entering any code for Queue
    Given The user is on tryEditor page and clicks Try here button in Queue operations
    When The user enters an empty code in editor of Queue operations and clicks Run button
    Then No error message is displayed for Queue operations

  ##TC22
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page after clicking Try here button in Queue operations
    When The user writes valid Python code in the editor of Queue operations and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Queue operations

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC23
  Scenario Outline: User writes Invalid code and clicks Run button on Queue operations Try Editor page
    Given The user is on the tryEditor page and clicks Try here button in Queue operations
    When The user writes invalid code in the editor Queue operations and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Queue operations

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC24
  Scenario: Verify that the user is able to navigate to Practice Questions page from Queue operations
    Given The user is on the Queue operations
    When The user clicks the Practice Questions link from the Queue operations
    Then The user should be redirected to the Practice Questions page from Queue operations
