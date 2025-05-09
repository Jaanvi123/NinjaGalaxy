Feature: Tree Page Feature

  Background: 
    Given The user is on home page
    When The user clicks Sign in link and enters valid credentials
    Then The user should land on the tree page by clicking Get started button for tree module

  ## Overview of Trees
  ## TC01
  Scenario: Verify that the user is able to navigate to the Overview of Trees page
    Given The user is on the Tree page after signing in
    When The user clicks the Overview of Trees link
    Then The user should be redirected to the Overview of Trees data structure page

  ##TC02
  Scenario: Navigate to Try Editor for Tree Overview of Trees
    Given The user is on the Overview of Trees page
    When The user clicks Try Here button in Overview of Trees page
    Then The user is redirected to a page having Editor with run button for Overview of Trees page

  ##TC03
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Overview of Trees link
    When The user enters an empty code in editor of Overview of Trees link and clicks Run button
    Then No error message is displayed for Try editor of Overview of Trees page

  #TC04
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Overview of Trees link
    When The user writes invalid code in the editor of Overview of Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Overview of Trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC05
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page along with run button and valid code
    When The user writes valid Python code in the editor of Overview of Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Overview of Trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC06
  Scenario: Verify that the user is able to navigate to Practice Questions page from Overview of Trees page
    Given The user is on overview of Trees page after signing in
    When The user clicks the Practice Questions link present in Overview of Trees page
    Then The user should be redirected to the Practice Questions page from Overview of Trees page

  ## Terminologies
  #TC07
  Scenario: Verify that the user is able to navigate to the Terminologies page
    Given The user is on the Tree page after valid sign in
    When The user clicks the Terminologies link
    Then The user should be redirected to the Terminologies data structure page

  #TC08
  Scenario: Navigate to Try Editor for Tree Terminologies
    Given The user is on the Terminologies page
    When The user clicks Try Here button in Terminologies page
    Then The user is redirected to a page having Editor with run button for Terminologies page

  #TC09
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Terminologies link
    When The user enters an empty code in editor of Terminologies link and clicks Run button
    Then No error message is displayed for Try editor of Terminologies page

  #TC10
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Terminologies link
    When The user writes invalid code in the editor of Terminologies page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Terminologies TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC11
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Terminologies page
    When The user writes valid Python code in the editor of Terminologies page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Terminologies page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC12
  Scenario: Verify that the user is able to navigate to Practice Questions page from Terminologies page
    Given The user is on Terminologies page after signing in
    When The user clicks the Practice Questions link present in Terminologies page
    Then The user should be redirected to the Practice Questions page from Terminologies page

  ## Types of Trees
  #TC13
  Scenario: Verify that the user is able to navigate to the Types of Trees page
    Given The user is on the Tree page
    When The user clicks the Types of Trees link
    Then The user should be redirected to the Types of Trees data structure page

  #TC14
  Scenario: Navigate to Try Editor for Tree Types of Trees
    Given The user is on the Types of Trees page
    When The user clicks Try Here button in Types of Trees page
    Then The user is redirected to a page having Editor with run button for Types of Trees page

  #TC15
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Types of Trees link
    When The user enters an empty code in editor of Types of Trees link and clicks Run button
    Then No error message is displayed for Try editor of Types of Trees page

  #TC16
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Types of Trees link
    When The user writes invalid code in the editor of Types of Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Types of Trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC17
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Types of Trees page
    When The user writes valid Python code in the editor of Types of Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Types of Trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC18
  Scenario: Verify that the user is able to navigate to Practice Questions page from Types of Trees page
    Given The user is on Types of Trees page after signing in
    When The user clicks the Practice Questions link present in Types of Trees page
    Then The user should be redirected to the Practice Questions page from Types of Trees page

  ##  Tree Traversals
  #TC19
  Scenario: Verify that the user is able to navigate to the Tree Traversals page
    Given The user is on the Tree page after clicking get started button
    When The user clicks the Tree Traversals link
    Then The user should be redirected to the Tree Traversals data structure page

  ##TC20
  Scenario: Navigate to Try Editor for Tree Traversals
    Given The user is on the Tree Traversals page
    When The user clicks Try Here button in Tree Traversals page
    Then The user is redirected to a page having Editor with run button for Tree Traversals page

  #TC21
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Tree Traversals link
    When The user enters an empty code in editor of Tree Traversals link and clicks Run button
    Then No error message is displayed for Try editor of Tree Traversals page

  ##TC22
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Tree Traversals link
    When The user writes invalid code in the editor of Tree Traversals page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Tree Traversals TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC23
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Tree Traversals page
    When The user writes valid Python code in the editor of Tree Traversals page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Tree Traversals page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC24
  Scenario: Verify that the user is able to navigate to Practice Questions page from Tree Traversals page
    Given The user is on Tree Traversals page after signing in
    When The user clicks the Practice Questions link present in Tree Traversals page
    Then The user should be redirected to the Practice Questions page from Tree Traversals page

  ## Traversals Illustration
  #TC25
  Scenario: Verify that the user is able to navigate to the Traversals Illustration page
    Given The user is on the Tree page after clicking get started
    When The user clicks the Traversals Illustration link
    Then The user should be redirected to the Traversals Illustration data structure page

  #TC26
  Scenario: Navigate to Try Editor for Traversals Illustration Illustration
    Given The user is on the Traversals Illustration page
    When The user clicks Try Here button in Traversals Illustration page
    Then The user is redirected to a page having Editor with run button for Traversals Illustration page

  #TC27
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Traversals Illustration link
    When The user enters an empty code in editor of Traversals Illustration link and clicks Run button
    Then No error message is displayed for Try editor of Traversals Illustration page

  #TC28
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Traversals Illustration link
    When The user writes invalid code in the editor of Traversals Illustration page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Traversals Illustration TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC29
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Traversals Illustration page
    When The user writes valid Python code in the editor of Traversals Illustration page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Traversals Illustration page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC30
  Scenario: Verify that the user is able to navigate to Practice Questions page from Traversals Illustration page
    Given The user is on Traversals Illustration page after signing in
    When The user clicks the Practice Questions link present in Traversals Illustration page
    Then The user should be redirected to the Practice Questions page from Traversals Illustration page

  ##  Binary Trees
  #TC31
  Scenario: Verify that the user is able to navigate to the  Binary Trees page
    Given The user is on Tree page after clicking get started
    When The user clicks the  Binary Trees link
    Then The user should be redirected to the  Binary Trees data structure page

  #TC32
  Scenario: Navigate to Try Editor for  Binary Trees Illustration
    Given The user is on the  Binary Trees page
    When The user clicks Try Here button in  Binary Trees page
    Then The user is redirected to a page having Editor with run button for  Binary Trees page

  #TC33
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Binary Trees link
    When The user enters an empty code in editor of  Binary Trees link and clicks Run button
    Then No error message is displayed for Try editor of  Binary Trees page

  #TC34
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Binary Trees link
    When The user writes invalid code in the editor of Binary Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Binary Trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC35
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Binary Trees page
    When The user writes valid Python code in the editor of Binary Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Binary Trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC36
  Scenario: Verify that the user is able to navigate to Practice Questions page from  Binary Trees page
    Given The user is on  Binary Trees page after signing in
    When The user clicks the Practice Questions link present in  Binary Trees page
    Then The user should be redirected to the Practice Questions page from  Binary Trees page

  ##  Types of Binary Trees
  #TC37
  Scenario: Verify that the user is able to navigate to the Types of Binary Trees page
    Given The user is on Tree data Structures Page
    When The user clicks the  Types of Binary Trees link
    Then The user should be redirected to the  Types of Binary Trees data structure page

  #TC38
  Scenario: Navigate to Try Editor for  Types of Binary Trees Illustration
    Given The user is on the  Types of Binary Trees page
    When The user clicks Try Here button in  Types of Binary Trees page
    Then The user is redirected to a page having Editor with run button for  Types of Binary Trees page

  #TC39
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in  Types of Binary Trees link
    When The user enters an empty code in editor of  Types of Binary Trees link and clicks Run button
    Then No error message is displayed for Try editor of  Types of Binary Trees page

  #TC40
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page clicks Try here button in Types of Binary Trees link
    When The user writes invalid code in the editor of Types of Binary Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Types of Binary Trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC41
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Types of Binary Trees page
    When The user writes valid Python code in the editor of Types of Binary Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Types of Binary Trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC42
  Scenario: Verify that the user is able to navigate to Practice Questions page from  Types of Binary Trees page
    Given The user is on  Types of Binary Trees page after signing in
    When The user clicks the Practice Questions link present in  Types of Binary Trees page
    Then The user should be redirected to the Practice Questions page from  Types of Binary Trees page

  ##  Implementation in Python
  #TC43
  Scenario: Verify that the user is able to navigate to the Implementation in Python page
    Given The user is on the Tree data Structures Page
    When The user clicks the Implementation in Python link
    Then The user should be redirected to the Implementation in Python data structure page

  ##TC44
  Scenario: Navigate to Try Editor for Implementation in Python Illustration
    Given The user is on the Implementation in Python page
    When The user clicks Try Here button in Implementation in Python page
    Then The user is redirected to a page having Editor with run button for Implementation in Python page

  ##TC45
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Implementation in Python link
    When The user enters an empty code in editor of Implementation in Python link and clicks Run button
    Then No error message is displayed for Try editor of Implementation in Python page

  ##TC46
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Implementation in Python link
    When The user writes invalid code in the editor of Implementation in Python page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Implementation in Python TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC47
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Implementation in Python page
    When The user writes valid Python code in the editor of Implementation in Python page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Implementation in Python page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC48
  Scenario: Verify that the user is able to navigate to Practice Questions page from  Implementation in Python page
    Given The user is on Implementation in Python page after signing in
    When The user clicks the Practice Questions link present in Implementation in Python page
    Then The user should be redirected to the Practice Questions page from Implementation in Python page

  ## Binary Tree Traversals
  #TC49
  Scenario: Verify that the user is able to navigate to the Binary Tree Traversals page
    Given The user is on the Tree ds page
    When The user clicks the Binary Tree Traversals link
    Then The user should be redirected to the Binary Tree Traversals data structure page

  ##TC50
  Scenario: Navigate to Try Editor for Binary Tree Traversals Illustration
    Given The user is on the Binary Tree Traversals page
    When The user clicks Try Here button in Binary Tree Traversals page
    Then The user is redirected to a page having Editor with run button for Binary Tree Traversals page

  #TC51
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Binary Tree Traversals link
    When The user enters an empty code in editor of Binary Tree Traversals link and clicks Run button
    Then No error message is displayed for Try editor of Binary Tree Traversals page

  ##TC52
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Binary Tree Traversals link
    When The user writes invalid code in the editor of Binary Tree Traversals page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Binary Tree Traversals TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC53
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Binary Tree Traversals page
    When The user writes valid Python code in the editor of Binary Tree Traversals page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Binary Tree Traversals page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC54
  Scenario: Verify that the user is able to navigate to Practice Questions page from Binary Tree Traversals page
    Given The user is on Binary Tree Traversals page after signing in
    When The user clicks the Practice Questions link present in Binary Tree Traversals page
    Then The user should be redirected to the Practice Questions page from Binary Tree Traversals page

  ## Implementation of Binary Trees
  #TC55
  Scenario: Verify that the user is able to navigate to the Implementation of Binary Trees page
    Given The user is on Tree ds page
    When The user clicks the Implementation of Binary Trees link
    Then The user should be redirected to the Implementation of Binary Trees data structure page

  #TC56
  Scenario: Navigate to Try Editor for Implementation of Binary Trees Illustration
    Given The user is on the Implementation of Binary Trees page
    When The user clicks Try Here button in Implementation of Binary Trees page
    Then The user is redirected to a page having Editor with run button for Implementation of Binary Trees page

  #TC57
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Implementation of Binary Trees link
    When The user enters an empty code in editor of Implementation of Binary Trees link and clicks Run button
    Then No error message is displayed for Try editor of Implementation of Binary Trees page

  #TC58
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Implementation of Binary Trees link
    When The user writes invalid code in the editor of Implementation of Binary Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Implementation of Binary Trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC59
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Implementation of Binary Trees page
    When The user writes valid Python code in the editor of Implementation of Binary Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Implementation of Binary Trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC60
  Scenario: Verify that the user is able to navigate to Practice Questions page from Implementation of Binary Trees page
    Given The user is on Implementation of Binary Trees page after signing in
    When The user clicks the Practice Questions link present in Implementation of Binary Trees page
    Then The user should be redirected to the Practice Questions page from Implementation of Binary Trees page

  ## Applications of Binary trees
  #TC61
  Scenario: Verify that the user is able to navigate to the Applications of Binary trees page
    Given The user is on data structure Tree page
    When The user clicks the Applications of Binary trees link
    Then The user should be redirected to the Applications of Binary trees data structure page

  ##TC62
  Scenario: Navigate to Try Editor for Applications of Binary trees Illustration
    Given The user is on the Applications of Binary trees page
    When The user clicks Try Here button in Applications of Binary trees page
    Then The user is redirected to a page having Editor with run button for Applications of Binary trees page

  ##TC63
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Applications of Binary trees link
    When The user enters an empty code in editor of Applications of Binary trees link and clicks Run button
    Then No error message is displayed for Try editor of Applications of Binary trees page

  ##TC64
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Applications of Binary trees link
    When The user writes invalid code in the editor of Applications of Binary trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on  Applications of Binary trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC65
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Applications of Binary trees page
    When The user writes valid Python code in the editor of Applications of Binary trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Applications of Binary trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC66
  Scenario: Verify that the user is able to navigate to Practice Questions page from Applications of Binary trees page
    Given The user is on Applications of Binary trees page after signing in
    When The user clicks the Practice Questions link present in Applications of Binary trees page
    Then The user should be redirected to the Practice Questions page from Applications of Binary trees page

  ## Binary Search Trees
  #TC67
  Scenario: Verify that the user is able to navigate to the Binary Search Trees page
    Given The user is on data structre Tree page
    When The user clicks the Binary Search Trees link
    Then The user should be redirected to the Binary Search Trees data structure page

  ##TC68
  Scenario: Navigate to Try Editor for Binary Search Trees Illustration
    Given The user is on the Binary Search Trees page
    When The user clicks Try Here button in Binary Search Trees page
    Then The user is redirected to a page having Editor with run button for  Binary Search Trees page

  ##TC69
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page after clicking Try here button in Binary Search Trees link
    When The user enters an empty code in editor of Binary Search Trees link and clicks Run button
    Then No error message is displayed for Try editor of Binary Search Trees page

  ##TC70
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Binary Search Trees link
    When The user writes invalid code in the editor of Binary Search Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Binary Search Trees TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC71
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Binary Search Trees page
    When The user writes valid Python code in the editor of Binary Search Trees page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Binary Search Trees page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  ##TC72
  Scenario: Verify that the user is able to navigate to Practice Questions page from Binary Search Trees page
    Given The user is on Binary Search Trees page after signing in
    When The user clicks the Practice Questions link present in Binary Search Trees page
    Then The user should be redirected to the Practice Questions page from Binary Search Trees page

  ##  Implementation Of BST
  #TC73
  Scenario: Verify that the user is able to navigate to the Implementation Of BST page
    Given The user is on the data structare Tree page
    When The user clicks the Implementation Of BST link
    Then The user should be redirected to the Implementation Of BST data structure page

  #TC74
  Scenario: Navigate to Try Editor for  Implementation Of BST Illustration
    Given The user is on the Implementation Of BST page
    When The user clicks Try Here button in Implementation Of BST page
    Then The user is redirected to a page having Editor with run button for Implementation Of BST page

  #TC75
  Scenario: User clicks the Run button without entering any code for Tree
    Given The user is on the tryEditor page afterclicking Try here button in Implementation Of BST link
    When The user enters an empty code in editor of Implementation Of BST link and clicks Run button
    Then No error message is displayed for Try editor of Implementation Of BST page

  #TC76
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on the tryEditor page and clicks Try here button in Implementation Of BST link
    When The user writes invalid code in the editor of Implementation Of BST page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Implementation Of BST TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  #TC77
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page along with run button and valid code for Implementation Of BST page
    When The user writes valid Python code in the editor of Implementation Of BST page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Implementation Of BST page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC78
  Scenario: Verify that the user is able to navigate to Practice Questions page from Implementation Of BST page
    Given The user is on Implementation Of BST page after signing in
    When The user clicks the Practice Questions link present in Implementation Of BST page
    Then The user should be redirected to the Practice Questions page from Implementation Of BST page
