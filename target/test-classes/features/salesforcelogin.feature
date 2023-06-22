Feature: Login Functionality

Background: 
    Given  User open salesforce application
    
Scenario: login with correct credentials
   When user on "loginpage"
   When User enters value into text box username as "<username1>"
   When User enters value into text box password as "<password1>"
   When Click on Login button
   Then verify we can see "homepage"


Scenario: Login with valid username and no password
   When user on "loginpage"
   When User enters value into text box username as "<username1>"
   When User should clear text box password as "<password1>"
   When Click on Login button
   Then verify error message is displayed

Scenario: Test remember username box is checkbox
   When user on "loginpage"
   When User enters value into text box username as "<username1>"
   When User enters value into text box password as "<password1>"
   When User check the box of remember username
   When Click on Login button
   Then verify we can see "homepage"
   When click on user menu dropodown
   And Select option of logout from dropdown
   Then verify username is displayed on the username field
 
 Scenario: Test forgot password 4A
   When user on "loginpage" 
   When user click on forgot password link
   Then verify we can see "forgot your password page"
    When User enters value into text box username field as "<username1>"
   When user click On continue button
   
Scenario: Test forgot password 4B
   When user on "loginpage"
   When User enters wrong  value into text box username as "<username2>"
   When User enters wrong value into text box password as "<password2>"
   When Click on Login button
   Then verify error message is displayed on loginPage