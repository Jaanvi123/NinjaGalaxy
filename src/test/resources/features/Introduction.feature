Feature: GetStarted page without logging on

Scenario Outline: Data Structures dropdown validation
Given User is on the Get Started Page
Then User clicks on Data Structures dropddown and validates all the <options> in  pane
|Arrays|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|

 

