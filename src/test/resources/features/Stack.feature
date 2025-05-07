Feature: Stack Page Features

    Background: 
    Given The user is on home page of dsalgo portal
    When The user press Sign in link and enters valid credentials
    Then The user lands on the stack page on clicking Get started button for stack module
  
# Operations in Stack
#TC01
  Scenario: Verify that the user is able to navigate to the Operations in Stack page
    Given the user is on the stack page after signing in
    When the user clicks the Operations in Stack link
    Then the user should be redirected to the Operations in Stack data structure page

#TC02
  Scenario: Navigate to Try Editor for Operations in Stack in stack module
    Given The user is on the Operations in Stack page 
    When The user clicks Try Here button on the Operations in Stack page 
    Then The user is redirected to a page having Editor with run button for Operations in Stack

#NO Code
#TC03
  Scenario: User clicks the Run button without entering any code for stack
   Given The user is on tryEditor page and clicks Try here button in Operations in Stack
    When The user enters an empty code in editor of Operations in Stack and clicks Run button
    Then No error message is displayed for Operations in Stack

#Valid Code
#TC04
  Scenario Outline:  Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page after clicking Try here button in Operations in Stack
    When The user enter valid Python code in the editor of Operations in Stack page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Operations in Stack
		   Examples: 
           | Sheetname     | RowNumber |
           | tryEditorCode |       0   |
#TC05
#Invalid Code

  Scenario Outline: User writes Invalid code and clicks Run button on Operations in Stack Try Editor page
    Given The user is on the tryEditor page and clicks Try here button in Operations in Stack link
    When The user enter invalid code in the editor Operations in Stack and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Operations in Stack 
    		Examples: 
           | Sheetname     | RowNumber |
           | tryEditorCode |      1    |

#TC06
  Scenario: Verify that the user is able to navigate to Practice Questions page from Operations in Stack page
    Given The user is in the Operations in Stack page
    When The user clicks the Practice Questions link from the Operations in Stack page
    Then The user should be redirected to the Practice Questions page from Operations in Stack page

#Implementation
#TC07
  #Scenario: Verify that the user is able to navigate to the Implementation
    #Given The user is in stack page after signing in
    #When the user clicks the Implementation
    #Then the user should be redirected to the Implementation data structure page
#
#TC08
  #Scenario: Navigate to Try Editor for Implementation in stack module
    #Given The user is on the Implementation
    #When The user clicks Try Here button on the Implementation
    #Then The user is redirected to a page having Editor with run button for Implementation
#
#NO Code
#TC09
  #Scenario: User clicks the Run button without entering any code for stack
   #Given The user is on tryEditor page and clicks Try here button in Implementation
    #When The user enters an empty code in editor of Implementation and clicks Run button
    #Then No error message is displayed for Implementation
#
#Valid Code
#TC10
  #Scenario Outline:  Verify that user is able to see output for valid python code
    #Given The user is on the tryEditor page after clicking Try here button in Implementation
    #When The user wrote valid Python code in the editor of Implementation and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Implementation
#		   Examples: 
           #| Sheetname     | RowNumber |
           #| tryEditorCode |       0   |
#TC11
#Invalid Code
#
  #Scenario Outline: User writes Invalid code and clicks Run button on Implementation Try Editor page
    #Given The user is on the tryEditor page and clicks Try here button in Implementation
    #When The user wrote invalid code in the editor Implementation and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Implementation
    #		Examples: 
           #| Sheetname     | RowNumber |
           #| tryEditorCode |      1    |
#
#TC12
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Implementation
    #Given The user is on the Implementation
    #When The user clicks the Practice Questions link from the Implementation
    #Then The user should be redirected to the Practice Questions page from Implementation
#
#
#Applications
#TC13
  #Scenario: Verify that the user is able to navigate to the Applications
    #Given The user is in stack page after signing in
    #When the user clicks the Applications
    #Then the user should be redirected to the Applications data structure page
#
#TC14
  #Scenario: Navigate to Try Editor for Applications in stack module
    #Given The user is on the Applications
    #When The user clicks Try Here button on the Applications
    #Then The user is redirected to a page having Editor with run button for Applications
#
#NO Code
#TC15
  #Scenario: User clicks the Run button without entering any code for stack
   #Given The user is on tryEditor page and clicks Try here button in Applications
    #When The user enters an empty code in editor of Applications and clicks Run button
    #Then No error message is displayed for Applications
#
#Valid Code
#TC16
  #Scenario Outline:  Verify that user is able to see output for valid python code
    #Given The user is on the tryEditor page after clicking Try here button in Applications
    #When The user has valid Python code in the editor of Applications and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Applications
#		   Examples: 
           #| Sheetname     | RowNumber |
           #| tryEditorCode |       0   |
#TC17
#Invalid Code
#
  #Scenario Outline: User writes Invalid code and clicks Run button on Applications Try Editor page
    #Given The user is on the tryEditor page and clicks Try here button in Applications
    #When The user has invalid code in the editor Applications and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Applications
    #		Examples: 
           #| Sheetname     | RowNumber |
           #| tryEditorCode |      1    |
#
#TC18
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Applications
    #Given The user is on the Applications
    #When The user clicks the Practice Questions link from the Applications
    #Then The user should be redirected to the Practice Questions page from Applications
#
  