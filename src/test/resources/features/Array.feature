Feature: Arrays

  Background: User is logged into DS Algo Portal
    Given The user is logged with valid credentials "Ninja_Galaxy" and "We_team3"
    When The user clicks the Getting Started button in Array Panel

  #--------------------------- (Array Get Started page)---------------------------
  #TC01
  Scenario: Verify that user is able to navigate to Array page
    Then The user should be redirected to Array page

  #TC02
  Scenario: Verify that user is able to navigate to Arrays in Python page
    When The user clicks the Arrays in Python link
    Then The user should be redirected to Arrays in Python page

  #TC03
  Scenario: Verify that user is able to navigate to try Editor page under Arrays in Python page
    When The user clicks Try Here button in Arrays in Python page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC04
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for Arrays in Python page
    When The user clicks the Run button without entering the code in the code Editor
    Then The user should not see any error message in the popup

  #TC05
  Scenario Outline: Verify that user receives error for invalid python code for Arrays in Python page
    When The user clicks Run button with invalid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see an error message in alert window

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |
  #TC06
  Scenario Outline: Verify that user is able to see output for valid python code
    When The user clicks Run button with the valid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |
      
    #---------------------------(Arrays Using List)---------------------------
   
  #TC07
  Scenario: Verify that user is able to navigate to Arrays Using List page
    When The user clicks the Arrays Using List link
    Then The user should be redirected to Arrays Using List page

  #TC08
  Scenario: Verify that user is able to navigate to try Editor page under Arrays Using List page
    When The user clicks Try Here button in Arrays Using List page
    Then The user should be redirected to a page having an tryEditor with a Run button

  #TC09
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for Arrays Using List page
    When The user clicks the Run button without entering the code in the Editor for Arrays Using List section 
    Then The user should not see any error message in the popup
  
  #TC10
  Scenario Outline: Verify that user receives error for invalid python code for Arrays Using List page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Arrays Using List page 
    Then The user should be able to see an error message in alert window
   

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |
      
  #TC11
  Scenario Outline: Verify that user is able to see output for valid python code for Arrays Using List page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Arrays Using List page
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

      
        #---------------------------(Basic Operations in Lists)---------------------------
  
 #TC12
  Scenario: Verify that user is able to navigate to Basic Operations in Lists page
    When The user clicks the Basic Operations in Lists link
    Then The user should be redirected to Basic Operations in Lists page
    
 #TC13  
 Scenario: Verify that user is able to navigate to try Editor page under Basic Operations in Lists page
    When The user clicks Try Here button in Basic Operations in Lists page
    Then The user should be redirected to a page having an tryEditor with a Run button

#TC14
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for Basic Operations in Lists page
    When The user clicks the Run button without entering the code in the Editor for Basic Operations in Lists section 
    Then The user should not see any error message in the popup

#TC15
 Scenario Outline: Verify that user receives error for invalid python code for Basic Operations in Lists page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Basic Operations in Lists page 
    Then The user should be able to see an error message in alert window
    
    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |
      
      
 #TC16
 Scenario Outline: Verify that user is able to see output for valid python code for Basic Operations in Lists page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Basic Operations in Lists page 
    Then The user should able to see output in the console
    
    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |
      
   
 #--------------------------- (Applications of Array)---------------------------

#TC17
  Scenario: Verify that user is able to navigate to Applications of Array page
    When The user clicks the Applications of Array link
    Then The user should be redirected to Applications of Array page
    
#TC18
 Scenario: Verify that user is able to navigate to try Editor page under Applications of Array page
    When The user clicks Try Here button in Applications of Array page
    Then The user should be redirected to a page having an tryEditor with a Run button

#TC19
  Scenario: Verify that user sees no changes when clicked on Run button without entering code for Applications of Array page
    When The user clicks the Run button without entering the code in the Editor for Applications of Array section 
    Then The user should not see any error message in the popup

#TC20
 Scenario Outline: Verify that user receives error for invalid python code for Applications of Array page
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Applications of Array page 
    Then The user should be able to see an error message in alert window
    
    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

#TC21
  Scenario Outline: Verify that user is able to see output for valid python code for Applications of Array page
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Applications of Array page
    Then The user should able to see output in the console
 
     Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |
 
 #--------------------------- (Practice Questions page scenarios)---------------------------      
  
  #TC22
  Scenario: Verify that user is able to navigate to list of Practice Questions under Array page
    When The user clicks Practice Questions link of Array page
    Then The user should be redirected to page with four Practice Questions 

  #-----(Practice Questions -> Question 1 :  Search the array (launched from Applications of Array page)--------
  
  #TC23
  Scenario: Verify that user is able to navigate to Search the array Page Practice Question
    When The user clicks Search the array page Question link
    Then The user should be redirected to try Editor page with a Run and Submit buttons

  #TC24
  Scenario Outline: Verify that user receives error for invalid python code for Search the array Question
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Search the array practice question
    Then The user should able to see an error message in alert window
    

    Examples: 
      | Sheetname          | RowNumber |
      | tryEditorCode			 |         1 |

  #TC25
  Scenario Outline: Verify that user is able to see output for valid python code
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Search the array practice question
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |
      
      
  #-----(Practice Questions -> Question 2 :  Max Consecutive Ones (launched from Arrays in Python page)

  #TC26
  Scenario Outline: Verify that user receives error for invalid python code for Max Consecutive Ones Question 
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Max Consecutive Ones practice question
    Then The user should able to see an error message in alert window
    

    Examples: 
      | Sheetname          | RowNumber |
      | tryEditorCode			 |         1 |

  #TC27
  Scenario Outline: Verify that user is able to see output for valid python code
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Max Consecutive Ones question
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |
    
   # -----(Practice Questions -> Question 3 :  Find Numbers with Even Number of Digits (launched from Arrays Using List page)

  #TC28
  Scenario Outline: Verify that user receives error for invalid python code for Find Numbers with Even Number of Digits Question 
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Find Numbers with Even Number of Digits practice question
    Then The user should able to see an error message in alert window
    

    Examples: 
      | Sheetname          | RowNumber |
      | tryEditorCode			 |         1 |

  #TC29
  Scenario Outline: Verify that user is able to see output for valid python code
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Find Numbers with Even Number of Digits question
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |  
      
 #-----(Practice Questions -> Question 4 : Squares of a Sorted Array (launched from Basic Operations in Lists page)     
      
      
  #TC30
  Scenario Outline: Verify that user receives error for invalid python code for Squares of a Sorted Array Question 
    When The user clicks Run button with invalidcode from sheetname "<Sheetname>" and row <RowNumber> for Squares of a Sorted Array practice question
    Then The user should able to see an error message in alert window
    

    Examples: 
      | Sheetname          | RowNumber |
      | tryEditorCode			 |         1 |

  #TC31
  Scenario Outline: Verify that user is able to see output for valid python code
    When The user clicks Run button with valid code from sheetname "<Sheetname>" and row <RowNumber> for Squares of a Sorted Array question
    Then The user should able to see output in the console

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |  
      
      
      
      