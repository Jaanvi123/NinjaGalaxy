@treePage
Feature: DSalgo treePage
  I want to use this template for my feature file
  
  
  @treePage
  Scenario: validating treePage
     Given USER is on Dalgo homepage  and verify the page title
    When The user clicks  Get Started button below the treeList and verify pagetitle
   Then  validate treePage links
   |Overview of trees|
   |Terminologies|
   |Types of Trees|
   |Tree Traversals|
   |Traversals Illustrations|
   |Binary Trees|
  | Types of Binary Trees|
   |Implementation in Python|
   |Binary Tree Traversals|
 |Implementation Of Binary Trees|
 |Application Of Binary trees|
 |Binary Search Trees|
| Implementation of BTS|
 
 @treePage
    Scenario Outline: validating Overview of trees  Page
     Given User is on Overview of trees page and verify the pagetitle
    When The user clicks Try Here button of Overview of trees  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
   