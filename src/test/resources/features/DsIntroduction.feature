Feature: Data Structures-Introduction

  Background: Verify that user is able to navigate to Data Structures - Introduction page
    Given The user is logged into the DS Algo Portal
    When The user clicks the Get Started button of Data Structure Introduction section
    Then The user should be directed to Data Structure introduction Page

 ##TC01
  Scenario: Verify that user is able to navigate to Time Complexity page of DS Introduction page
    Given The user is on data Structure introduction Page
    When The user clicks on Time Complexity link of DS Introduction page
    Then The user should be directed to Time Complexity page of DS Intro page

##TC02
  Scenario: Verify that user is able to navigate to Try Editor from Time Complexity page for DS Introduction page
    Given The user is on Time Complexity page of DS Introduction page
    When The user clicks on Try here button of Time Complexity Page
    Then The user should be directed to a page having Editor with run button

 ##TC03
  Scenario: Verify that user does not get any error message when clicked on Run button without any code
    Given The user is on time comlexity page to explore tryhere page with run button
    When The user clicks the Run button without entering the code in the text area editor
    Then The user does not see any error message displayed on time complexity page

##TC04
  Scenario Outline: Verify that user receives error message in the alert window for invalid python code
    Given The user is on tryEditor  page with run button with alert window
    When The user clicks Run button in DS with invalid code from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see an error message in the alert window on time complexity page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         1 |

 ##TC05
  Scenario Outline: Verify that user is able to see output for valid python code
    Given The user is on tryEditor page with run button and valid code on time complexity page
    When The user clicks Run button with valid code on time complexity page from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should able to see output in the console on time complexity page

    Examples: 
      | Sheetname     | RowNumber |
      | tryEditorCode |         0 |

  # TC06
  #Scenario: Verify that user is able to navigate to Practice Questions page
    #Given The user lands on time complexity page
    #When The user clicks Practice Questions link of DS page
    #Then The user should be redirected to Practice Questions page of DS
