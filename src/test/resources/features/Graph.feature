Feature: Graph Page Features

    Background: 
    Given The user is on home page of ds portal
    When The user clicks Sign in link for ds and enters valid credentials
    Then The user lands on the graph page on clicking Get started button for graph module
    
  ## Inside graph
  
  ##TC01
  Scenario: Verify that the user is able to navigate to the Inside graph page
    Given The user is on the Graph page after signing in
    When The user clicks the Inside graph link
    Then The user should be redirected to the Inside graph data structure page

#TC02
  Scenario: Navigate to Try Editor for Inside graph in Graph module
    Given The user is on the Inside graph page 
    When The user clicks Try Here button on the Inside graph page 
    Then The user is redirected to a page having Editor with run button for Inside graph

#NO Code
#TC03
  Scenario: User clicks the Run button without entering any code for Inside Graph
   Given The user is on tryEditor page and clicks Try here button in Inside Graph
    When The user enters an empty code in editor of Inside Graph and clicks Run button
    Then No error message is displayed for Inside Graph

#Valid Code
#TC04
  Scenario Outline:  Verify that user is able to see output for valid python code
    Given The user is on the tryEditor page after clicking Try here button in Inside Graph
    When The user writes valid Python code in the editor of Inside Graph page and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to see output in the console for Inside Graph
		   Examples: 
           | Sheetname     | RowNumber |
           | tryEditorCode |       0   |
#TC05
#Invalid Code

  Scenario Outline: User writes Invalid code and clicks Run button on Inside graph Try Editor page
    Given The user is on the tryEditor page and clicks Try here button in Inside Graph link
    When The user writes invalid code in the editor Inside Graph and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    Then The user should be able to get alert on Inside graph 
    		Examples: 
           | Sheetname     | RowNumber |
           | tryEditorCode |      1    |

#TC06
  Scenario: Verify that the user is able to navigate to Practice Questions page from Inside graph page
    Given The user is on Inside Graph page
    When The user clicks the Practice Questions link from the Inside Graph page
    Then The user should be redirected to the Practice Questions page from Inside graph page

##Graph representations
##TC07
  #Scenario: Verify that the user is able to navigate to the Graph representations
    #Given The user is in Graph page after signing in
    #When The user clicks the Graph representations
    #Then The user should be redirected to the Graph representations data structure page
#
##TC08
  #Scenario: Navigate to Try Editor for Graph representations in Graph module
    #Given The user is on the Graph representations
    #When The user clicks Try Here button on the Graph representations
    #Then The user is redirected to a page having Editor with run button for Graph representations
#
##NO Code
##TC09
  #Scenario: User clicks the Run button without entering any code for Graph
   #Given The user is on tryEditor page and clicks Try here button in Graph representations
    #When The user enters an empty code in editor of Graph representations and clicks Run button
    #Then No error message is displayed for Graph representations
#
##Valid Code
##TC10
  #Scenario Outline:  Verify that user is able to see output for valid python code
    #Given The user is on the tryEditor page after clicking Try here button in Graph representations
    #When The user writes valid Python code in the editor of Graph representations and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to see output in the console for Graph representations
#		   Examples: 
           #| Sheetname     | RowNumber |
           #| tryEditorCode |       0   |
##TC11
##Invalid Code
#
  #Scenario Outline: User writes Invalid code and clicks Run button on Graph representations Try Editor page
    #Given The user is on the tryEditor page and clicks Try here button in Graph representations
    #When The user writes invalid code in the editor Graph representations and clicks Run button from sheetname "<Sheetname>" and row <RowNumber>
    #Then The user should be able to get alert on Graph representations
    #		Examples: 
           #| Sheetname     | RowNumber |
           #| tryEditorCode |      1    |
#
##TC12
  #Scenario: Verify that the user is able to navigate to Practice Questions page from Graph representations
    #Given The user is on Graph representations
    #When The user clicks the Practice Questions link from the Graph representations
    #Then The user should be redirected to the Practice Questions page from Graph representations