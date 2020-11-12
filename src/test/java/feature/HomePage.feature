Feature: HomePage feature

@SmokeTest
  Scenario: user login to the application as a valid user
    Given user launches the browser and enter the url "http://localhost:8888"
    When user enter username "admin" and password  "manager" and click on login button
    Then Home page should display

@Functional
  Scenario: user login to the application as a Invalid user
    Given user launches the browser and enter the url
    When user enter wrong username "admin123" and password "manager"
    And user click on login button
    Then error message should display
