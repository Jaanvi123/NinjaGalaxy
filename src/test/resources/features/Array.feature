Feature: Arrays

  Background: User is logged into DS Algo Portal
    Given The user is logged with valid credential and the user is on the Home page
    When The user clicks the Get Started button in Array Panel
    Then The user should be navigated to the Array page

  ## (Arrays in Python page)
  ####TC01
  Scenario: Verify that user is able to navigate to Arrays in Python page
    Given The user is on the Array page
    When The user clicks the Arrays in Python link
    Then The user should be redirected to Arrays in Python page

  ###TC02
  Scenario: Verify that user is able to navigate to try Editor page under Arrays in Python page
    Given The user is on the Arrays in Python page
    When The user clicks Try Here button in Arrays in Python page
    Then The user should be redirected to a page having a tryEditor with a Run button

  ###TC03
  Scenario: Verify Run button behavior with empty code editor on Try
    Given The user is on the tryEditor page with a Run button
    When The user clicks the Run button without entering the code in the code Editor
    Then The user should not see any error message in the popup

  ###TC04
  Scenario Outline: Verify error message for invalid code on Try Editor
    Given The user is on the tryEditor page of Array in python
    When The user clicks Run button with invalid code from sheetname "<Sheetname>" and row <RowNumber> for Arrays in Python page
    Then The user should be able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC05
  Scenario Outline: Verify output for valid code on Try Editor page of Array in Python
    Given The user is on the tryEditor page of Array in python
    When The user clicks Run button with invalid code from sheetname "<Sheetname>" and row <RowNumber> for Arrays in Python page
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #( Arrays Using List page)
  ##TC06
  Scenario: Verify navigation to Arrays Using List page
    Given The user is on the Array page to explore Arrays Using List page
    When The user clicks the Arrays Using List link
    Then The user should be redirected to Arrays Using List page

  ##TC07
  Scenario: Verify Try Here button on Arrays Using List page
    Given The user is on the Arrays Using List page
    When The user clicks Try Here button in Arrays Using List page
    Then The user should be redirected to a page having a tryEditor with a run button

  ##TC08
  Scenario: Verify Run button behavior with empty code editor in Arrays Using List section
    Given The user is on the Arrays Using List page
    When The user clicks the Run button without entering code in the Editor for Arrays Using List section
    Then The user should not see any error message in the popup

  ##TC09
  Scenario Outline: Verify error message for invalid code in Arrays Using List page
    Given The user is on the Arrays Using List page
    When The user clicks Run button with invalid code from sheetname "<Sheetname>" and row <RowNumber> for Arrays Using List page
    Then The user should be able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC10
  Scenario Outline: Verify output for valid code in Arrays Using List page
    Given The user is on the Arrays Using List page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Arrays Using List page
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #(Basic Operations in Lists)
  ##TC11
  Scenario: Verify that user is able to navigate to Basic Operations in Lists page
    Given The user is on the  Array page after logged in
    When The user clicks the Basic Operations in Lists link
    Then The user should be redirected to Basic Operations in Lists page

  ##TC12
  Scenario: Verify that user is able to navigate to try Editor page under Basic Operations in Lists page
    Given The user is on Basic Operations in Lists page with tryhere button
    When The user clicks Try Here button in Basic Operations in Lists page
    Then The user should be redirected to a page having a tryEditor with a Run button

  ##TC13
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for Basic Operations in Lists page
    Given The user is on tryeditor page of  Basic Operations in Lists page
    When The user clicks the Run button without entering the code in the Editor for Basic Operations in Lists section
    Then The user should not see any error message in the popup

  ##TC14
  Scenario Outline: Verify that user receives error for invalid python code for Basic Operations in Lists page
    Given The user is on tryeditor page of  Basic Operations in Lists page
    When The user clicks Run button with invalid code from sheetname "<Sheetname>" and row <RowNumber> for Basic Operations in Lists page
    Then The user should be able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC15
  Scenario Outline: Verify that user is able to see output for valid python code for Basic Operations in Lists page
    Given The user is on tryeditor page of  Basic Operations in Lists page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Basic Operations in Lists page
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #(Applications of Array)
  ##TC16
  Scenario: Verify that user is able to navigate to Applications of Array page
    Given The user is on overview of the Array page
    When The user clicks the Applications of Array link
    Then The user should be redirected to a page having an tryEditor with a Run button in Applications of Array link

  ##TC17
  Scenario: Verify that user is able to navigate to try Editor page under Applications of Array page
    Given The user is on Applications of Array page
    When The user clicks Try Here button in Applications of Array page
    Then The user should be redirected to a page having an tryEditor with a Run button in Applications of Array link

  ##TC18
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for Applications of Array page
    Given The user is on Applications of Array page
    When The user clicks the Run button without entering the code in the Editor for Applications of Array section
    Then The user should not see any error message in the popup

  ##TC19
  Scenario Outline: Verify that user receives error for invalid python code for Applications of Array page
    Given The user is on Applications of Array page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Applications of Array page
    Then The user should be able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

  ##TC20
  Scenario Outline: Verify that user is able to see output for valid python code for Applications of Array page
    Given The user is on Applications of Array page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Applications of Array page
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #(Practice Questions page scenarios)
  ##TC21
  Scenario: Verify that user is able to navigate to list of Practice Questions under Array page
    Given The user is on the Array page
    When The user clicks Practice Questions link of Array page
    Then The user should be redirected to page with four Practice Questions

  ##TC22
  Scenario: Verify that user is able to navigate to Search the array Page Practice Question
    Given The user is on the Practice Questions page
    When The user clicks Search the array page Question link
    Then The user should be redirected to try Editor page with a Run and Submit buttons

  ##TC23
  Scenario Outline: Verify that user receives error for invalid python code for Search the array Question
    Given The user is on the try Editor page for Search the array practice question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname   | RowNumber |
      | pythonCode1 |         1 |

  ##TC24
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the try Editor page for Search the array practice question
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Search the array practice question
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname   | RowNumber |
      | pythonCode1 |         0 |

  ##TC25
  Scenario Outline: Verify that user receives error for invalid python code for Max Consecutive Ones Question
    Given The user is on the try Editor page for Max Consecutive Ones practice question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname          | RowNumber |
      | ArrayPracticeQnsQ1 |         0 |

  ##TC26
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the try Editor page for Max Consecutive Ones question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Max Consecutive Ones practice question
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname          | RowNumber |
      | ArrayPracticeQnsQ1 |         2 |

  ##TC27
  Scenario Outline: Verify that user receives error for invalid python code for Find Numbers with Even Number of Digits Question
    Given The user is on the try Editor page for Find Numbers with Even Number of Digits practice question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname   | RowNumber |
      | pythonCode1 |         0 |

  ##TC28
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the try Editor page for Find Numbers with Even Number of Digits question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Find Numbers with Even Number of Digits practice question
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname   | RowNumber |
      | pythonCode1 |         1 |

  ##TC29
  Scenario Outline: Verify that user receives error for invalid python code for Squares of a Sorted Array Question
    Given The user is on the try Editor page for Squares of a Sorted Array practice question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in alert window

    Examples: 
      | Sheetname   | RowNumber |
      | pythonCode1 |         1 |

  ##TC30
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on the try Editor page for Squares of a Sorted Array question
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Squares of a Sorted Array question
    Then The user should be able to see output in the console

    Examples: 
      | Sheetname   | RowNumber |
      | pythonCode1 |         0 |
