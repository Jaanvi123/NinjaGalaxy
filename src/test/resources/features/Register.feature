Feature: Register Page validation

@register 
Scenario: Opening Register Page
    Given The User opens Register Page
    When The User clicks "Register" button with all fields empty
    Then It should display an error "Please fill out this field." below Username textbox

@register    
 Scenario: Entering different passwords in password and password confirmation textbox
    Given The User opens Register Page
  	When The User clicks "Register" button after entering different passwords in Password and Password Confirmation fields 
    Then The User should able to see an pwd warning message "password_mismatch:The two password fields didn’t match."

@register     
Scenario Outline: Entering all the details in proper format   
    Given The User opens Register Page 
    When User enters valid username, password,confirm_password and clicks Register button from row <rowNumber>
    Then The User should be redirected to HomePage of DS_Algo
    And The User should able to see successful message "New Account Created. You are logged in as"  on the DS_Algo HomePage
    And user clicks on signout  
    
    Examples:
    |rowNumber|
    |1|
    |2|
    |3|
    
  
 
    
    
      