Feature: Linked List Page Features

  Background: 
    Given The user is on home page of ds algo portal
    When The user clicks Sign in link and enters valid credentials to sign in 
    Then The user should land on the Linked list page by clicking Get started button for Linked list module
 
##Introduction
#TC01
   #Scenario: Verify that the user is able to navigate to the Introduction page
    #Given The user is on the Linked List page after signing in
    #When The user clicks the Introduction link
    #Then The user should be redirected to the Introduction page
#TC02
  #Scenario: Navigate to Try Editor for linked list Introduction
    #Given The user is on the Introduction page 
    #When The user clicks Try Here button on the Introduction page
    #Then The user is redirected to a page having Editor with run button on the Introduction page
      #
#TC03
  #Scenario: User clicks the Run button without entering any code for linked list
    #Given The user is on the tryEditor page after clicking Try here button on the Introduction page
    #When The user enters an empty code in editor of Introduction page and clicks Run button
    #Then No error message is displayed for Try editor of Introduction page
  #
 #TC04
   #Scenario Outline: Verify that user receives error message for invalid python code
    #Given The user is on the tryEditor page and clicks Try here button on the Introduction page
    #When The user writes invalid code in the editor on the Introduction page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on the Introduction page TryEditor page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
 #TC05
  #Scenario Outline: Verify that user is able to see output for valid python code on the Introduction page
    #Given The user is on the tryEditor page along with run button and valid code on the Introduction page
    #When The user writes valid Python code in the editor on the Introduction page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console on the Introduction page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
 ##TC06
  #Scenario: Verify that the user is able to navigate to Practice Questions page on the Introduction page
    #Given The user is on the Introduction page after signing in
    #When The user clicks the Practice Questions link present on the Introduction page
    #Then The user should be redirected to the Practice Questions page from the Introduction page


    # Creating Linked List
##TC07
  #Scenario: Verify that the user is able to navigate to the Creating Linked List page
  #Given The user is on the Linked list page after valid sign in
  #When The user clicks the Creating Linked List link
  #Then The user should be redirected to the Creating Linked List page
##  TC08
  #Scenario: Navigate to Try Editor for Creating Linked List page
  #Given The user is on the Creating Linked List page
  #When  The user clicks Try Here button in Creating Linked List page
  #Then The user is redirected to a page having Editor with run button for Creating Linked List page
  #TC09
  #Scenario: User clicks the Run button without entering any code for Creating Linked List page
  #Given The user is on the tryEditor page after clicking Try here button in Creating Linked List page
  #When  The user enters an empty code in editor of Creating Linked List page and clicks Run button
  #Then  No error message is displayed for Try editor of Creating Linked List page
 ##TC10
  #Scenario Outline: Verify that user receives error message in the alert window for invalid python code on Creating Linked List page
    #Given The user is on the tryEditor page and clicks Try here button in Creating Linked List page
    #When The user writes invalid code in the editor of Creating Linked List page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Creating Linked List page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
 #TC11
  #Scenario Outline: Verify that user is able to see output for valid python code Creating Linked List page
    #Given The user is on tryEditor page along with run button and valid code for Creating Linked List page
    #When The user writes valid Python code in the editor of Creating Linked List page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Creating Linked List page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
#
 ##TC12
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Creating Linked List page
  #Given The user is on Creating Linked List page after signing in
  #When The user clicks the Practice Questions link present in Creating Linked List page
  #Then The user should be redirected to the Practice Questions page from Creating Linked List page
  #
    
    # Types of Linked List
    ##TC13
 #Scenario: Verify that the user is able to navigate to the Types of Linked List page
  #Given The user is on the Types of Linked List data structure page
  #When The user clicks the Types of Linked List link
  #Then The user should be redirected to the Types of Linked List page
   #TC14
  #Scenario: Navigate to Try Editor for Types of Linked List
  #Given The user is on the Types of Linked List page
  #When  The user clicks Try Here button in Types of Linked List page
  #Then The user is redirected to a page having Editor with run button for Types of Linked List page
   #TC15
  #Scenario: User clicks the Run button without entering any code for Types of Linked List
  #Given The user is on the tryEditor page after clicking Try here button in Types of Linked List link
  #When  The user enters an empty code in editor of Types of Linked List link and clicks Run button
  #Then  No error message is displayed for Try editor of Types of Linked List page
   #TC16
  #Scenario Outline: Verify that user receives error message in the alert window for invalid python code in Types of Linked List page
    #Given The user is on the tryEditor page and clicks Try here button in Types of Linked List page
    #When The user writes invalid code in the editor of Types of Linked List page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Types of Linked List TryEditor page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
 #TC17
  #Scenario Outline: Verify that user is able to see output for valid python code on Types of Linked List page
    #Given The user is on tryEditor page along with run button and valid code for Types of Linked List page
    #When The user writes valid Python code in the editor of Types of Linked List page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Types of Linked List page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
#
  #TC18 
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Types of Linked List page
  #Given The user is on Types of Linked List page after signing in
  #When The user clicks the Practice Questions link present in Types of Linked List page
  #Then The user should be redirected to the Practice Questions page from Types of Linked List page
  #
   
   
    # Implement Linked List in Python
##TC19
  #Scenario: Verify that the user is able to navigate to the Implement Linked List in Python page
  #Given The user is on the Implement Linked List in Python data structure page
  #When The user clicks the Implement Linked List in Python link
  #Then The user should be redirected to the Implement Linked List in Python data structure page
   #TC20
  #Scenario: Navigate to Try Editor for Implement Linked List in Python
  #Given The user is on the Implement Linked List in Python page
  #When  The user clicks Try Here button in Implement Linked List in Python page
  #Then The user is redirected to a page having Editor with run button for Implement Linked List in Python page
   #TC21
  #Scenario: User clicks the Run button without entering any code for Implement Linked List in Python
  #Given The user is on the tryEditor page after clicking Try here button in Implement Linked List in Python link
  #When  The user enters an empty code in editor of Implement Linked List in Python link and clicks Run button
  #Then  No error message is displayed for Try editor of Implement Linked List in Python page
   #TC22
  #Scenario Outline: Verify that user receives error message in the alert window for invalid python code in Implement Linked List in Python page
    #Given The user is on the tryEditor page and clicks Try here button in Implement Linked List in Python page
    #When The user writes invalid code in the editor of Implement Linked List in Python page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Implement Linked List in Python TryEditor page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
 #TC23
  #Scenario Outline: Verify that user is able to see output for valid python code on Implement Linked List in Python page
    #Given The user is on tryEditor page along with run button and valid code for Implement Linked List in Python page
    #When The user writes valid Python code in the editor of Implement Linked List in Python page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Implement Linked List in Python page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
#
  #TC24 
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Implement Linked List in Python page
  #Given The user is on Implement Linked List in Python page after signing in
  #When The user clicks the Practice Questions link present in Implement Linked List in Python page
  #Then The user should be redirected to the Practice Questions page from Implement Linked List in Python page
  
    
     # Traversal
 ##TC25
 #Scenario: Verify that the user is able to navigate to the Traversal page
  #Given The user is on the Traversal data structure page
  #When The user clicks the Traversal link
  #Then The user should be redirected to the Traversal data structure page
   #TC26
  #Scenario: Navigate to Try Editor for Traversal
  #Given The user is on the Traversal page
  #When  The user clicks Try Here button in Traversal page
  #Then The user is redirected to a page having Editor with run button for Traversal page
   #TC27
  #Scenario: User clicks the Run button without entering any code for Traversal
  #Given The user is on the tryEditor page after clicking Try here button in Traversal link
  #When  The user enters an empty code in editor of Traversal link and clicks Run button
  #Then  No error message is displayed for Try editor of Traversal page
   #TC28
  #Scenario Outline: Verify that user receives error message in the alert window for invalid python code in Traversal page
    #Given The user is on the tryEditor page and clicks Try here button in Traversal page
    #When The user writes invalid code in the editor of Traversal page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Traversal TryEditor page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
 #TC29
  #Scenario Outline: Verify that user is able to see output for valid python code on Traversal page
    #Given The user is on tryEditor page along with run button and valid code for Traversal page
    #When The user writes valid Python code in the editor of Traversal page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Traversal page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
#
  #TC30
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Traversal page
  #Given The user is on Traversal page after signing in
  #When The user clicks the Practice Questions link present in Traversal page
  #Then The user should be redirected to the Practice Questions page from Traversal page
  #
    
     
     # Insertion
 ##TC31
  #Scenario: Verify that the user is able to navigate to the Insertion page
  #Given The user is on the Insertion data structure page
  #When The user clicks the Insertion link
  #Then The user should be redirected to the Insertion data structure page
   #TC32
  #Scenario: Navigate to Try Editor for Insertion
  #Given The user is on the Insertion page
  #When  The user clicks Try Here button in Insertion page
  #Then The user is redirected to a page having Editor with run button for Insertion page
   #TC33
  #Scenario: User clicks the Run button without entering any code for Insertion
  #Given The user is on the tryEditor page after clicking Try here button in Insertion link
  #When  The user enters an empty code in editor of Insertion link and clicks Run button
  #Then  No error message is displayed for Try editor of Insertion page
   #TC34
  #Scenario Outline: Verify that user receives error message in the alert window for invalid python code in Insertion page
    #Given The user is on the tryEditor page and clicks Try here button in Insertion page
    #When The user writes invalid code in the editor of Insertion page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Insertion TryEditor page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         1 |
#
 #TC35
  #Scenario Outline: Verify that user is able to see output for valid python code on Insertion page
    #Given The user is on tryEditor page along with run button and valid code for Insertion page
    #When The user writes valid Python code in the editor of Insertion page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Insertion page
#
    #Examples: 
      #| Sheetname     | RowNumber |
      #| tryEditorCode |         0 |
#
  #TC36
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Insertion page
  #Given The user is on Insertion page after signing in
  #When The user clicks the Practice Questions link present in Insertion page
  #Then The user should be redirected to the Practice Questions page from Insertion page
  #
   
   # Deletion
##TC37
Scenario: Verify that the user is able to navigate to the Deletion page
  Given The user is on the Deletion data structure page
  When The user clicks the Deletion link
  Then The user should be redirected to the Deletion data structure page
   #TC38
  Scenario: Navigate to Try Editor for Deletion
  Given The user is on the Deletion page
  When  The user clicks Try Here button in Deletion page
  Then The user is redirected to a page having Editor with run button for Deletion page
   #TC39
  Scenario: User clicks the Run button without entering any code for Deletion
  Given The user is on the tryEditor page after clicking Try here button in Deletion link
  When  The user enters an empty code in editor of Deletion link and clicks Run button
  Then  No error message is displayed for Try editor of Deletion page
   #TC40
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code in Deletion page
    Given The user is on the tryEditor page and clicks Try here button in Deletion page
    When The user writes invalid code in the editor of Deletion page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Deletion TryEditor page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

 #TC41
  Scenario Outline: Verify that user is able to see output for valid python code on Deletion page
    Given The user is on tryEditor page along with run button and valid code for Deletion page
    When The user writes valid Python code in the editor of Deletion page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Deletion page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  #TC42
  Scenario: Verify that the user is able to navigate to Practice Questions page from Deletion page
  Given The user is on Deletion page after signing in
  When The user clicks the Practice Questions link present in Deletion page
  Then The user should be redirected to the Practice Questions page from Deletion page
  #