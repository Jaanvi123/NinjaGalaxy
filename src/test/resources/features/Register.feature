Feature: Register Page validation

@register 
Scenario: Opening Register Page
    Given The User opens Register Page
    When The User clicks "Register" button with all fields empty
    Then It should display an error "Please fill out this field." below Username textbox

    
 Scenario: Entering different passwords in password and password confirmation textbox
    Given The User opens Register Page
  	When The User clicks "Register" button after entering different passwords in Password and Password Confirmation fields 
    Then The User should able to see an pwd warning message "password_mismatch:The two password fields didn’t match."

  

    
  
 
    
    
      