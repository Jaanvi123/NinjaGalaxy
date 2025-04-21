Feature: GetStarted page without logging on
@homePage
Scenario Outline: Data Structures dropdown validation
Given User is on the Get Started Page
Then User clicks on Data Structures dropddown and validates all the <options> in  pane
|Arrays|
|Linked List|
|Stack|
|Queue|
|Tree|
|Graph|

@homePage
Scenario: Get Started button validation of DataStructures
Given user is on the Get Started Page
When User clicks on Get Started button of any Data Structures section and verify the error message "You are not logged in"


#Scenario: Register and login links UI verification
 
#Then User should see register and login links 

