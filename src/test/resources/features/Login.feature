Feature: Login 

@Regression
  Scenario: User login with correct username and password
  Given User is landed on login page
  When Use enters username "metemitali@gmail.com" and password "Syntel@11"
  And Click on submit button
  Then User is able to login and access the dashboard
  
 @Regression  @Skip
 Scenario: User login with incorrect username
  Given User is landed on login page
  When Use enters incorrect username "gatesag" and password "Syntel@11"
 
 @Smoke  @Skip
Scenario: User login with correct username and incorrect password
 Given User is landed on login page
 When Use enters username "metemitali@gmail.com" and Incorrect password "Synda"
 And Click on submit button
 Then User gets authentication error message
  
 
  