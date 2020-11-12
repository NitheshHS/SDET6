Feature: Login feature

Background:
Given user launches the browser and enter the url
 
@SmokeTest
Scenario: user login to the application as a valid user
When user enter username and password and click on login button
Then Home page should display

@Functional
Scenario: user login to the application as a Invalid user
When user enter wrong username and password
And user click on login button
Then error message should display