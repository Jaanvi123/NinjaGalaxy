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
   
   @treePage
    Scenario Outline: validating Terminologies  Page
     Given User is on Terminologies page and verify the pagetitle
    When The user clicks Try Here button of Terminologies  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
   
   @treePage
    Scenario Outline: validating Types of Trees Page
     Given User is on Types of Trees page and verify the pagetitle
    When The user clicks Try Here button of Types of Trees Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
    
    @treePage
    Scenario Outline: validating Tree Traversals of trees  Page
     Given User is on Tree Traversalss page and verify the pagetitle
    When The user clicks Try Here button of Tree Traversals  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
    
       @treePage
    Scenario Outline: validating Traversals Illustrations  Page
     Given User is on Traversals Illustrations page and verify the pagetitle
    When The user clicks Try Here button of Traversals Illustrations  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
   
     @treePage
    Scenario Outline: validating Binary Trees  Page
     Given User is on Binary Trees page and verify the pagetitle
    When The user clicks Try Here button of Binary Trees Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      
    
      @treePage
    Scenario Outline: validating Types of Binary Trees  Page
     Given User is on Types of Binary Trees page and verify the pagetitle
    When The user clicks Try Here button of Types of Binary Trees  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      @treePage
    Scenario Outline: validating Implementation in Python  Page
     Given User is on Implementation in Python page and verify the pagetitle
    When The user clicks Try Here button of Implementation in Python Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      @treePage
    Scenario Outline: validating Binary Tree Traversals  Page
     Given User is on Binary Tree Traversals page and verify the pagetitle
    When The user clicks Try Here button of Binary Tree Traversals  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      @treePage
    Scenario Outline: validating Implementation Of Binary Trees Page
     Given User is on Implementation Of Binary Trees page and verify the pagetitle
    When The user clicks Try Here button of Implementation Of Binary Trees Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      @treePage
    Scenario Outline: validating Application Of Binary trees  Page
     Given User is on Application Of Binary trees page and verify the pagetitle
    When The user clicks Try Here button of Application Of Binary trees  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      @treePage
    Scenario Outline: validating Binary Search Trees Page
     Given User is on Terminologies page and verify the pagetitle
    When The user clicks Try Here button of Terminologies  Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
    
      Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
      @treePage
    Scenario Outline: validating  Implementation of BTS Page
     Given User is on  Implementation of BTS  page and verify the pagetitle
    When The user clicks Try Here button of  Implementation of BTS Page and the user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    And THE  user is on python editor and User write the invalid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see an <message> in alert window
    Then The USER write the valid code in Editor <rowNumber> and <sheetName> and click run button and the user should able to see output in the console
    
     Examples: 
      | rowNumber | sheetName       | message                                          |
      |         1 | Text_Try_Editor | NameError: name 'hello' is not defined on line 1 |
      
             @treePage
  Scenario: validating PracticeQuestionPage
     Given USER is on Types Of PractionQuestion page and verify the url"https://dsportalapp.herokuapp.com/tree/practice"
     Then User navigate back to DsalgohomePage
   
   
   