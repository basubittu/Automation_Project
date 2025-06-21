Feature: Check Login Functionality

  @tag1
  Scenario: To check login functionality
    Given user navigate  to webpage
    When user enter proper username and password
    And user click on login button
    And user click on logout button
    Then check able to signin to the website successfully

  @Tag2
  Scenario: To check read propertis value
    Given navigate to properties file
    When enter "<URL>" to the property file
    Then I validate URL contains "amazon.in"
