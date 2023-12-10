@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully
    Given  user go to register page
     When user select gender
    And user enter first name "tester" and  last name automation
    And user enter day of birth
    And user enter month of birth
    And user enter year of birth
    And user enter email "Test@gmail.com"
    And user fills password fields"P@ssw0rd" "P@ssw0rd"
    And user click on register button
    Then success message is displayed
