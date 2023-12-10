@smoke
  Feature: F02_Login | users could use login functionality to use their accounts
    Scenario: user could login with valid email and password
      Given user go to login page
      When user login with "valid" "test@example.com" and "P@ssw0rd"
      And user press on login button
      Then user login to system successfully and redirected to homepage
      And my account tab displayed

      ########################Secnario2#########################
    Scenario: user could login with invalid email and password
      Given  user go to login Link
      When user login with "invalid" "wrong@example.com" and "P@ssw0rd"
      And  user press login button
      Then  user could not login to the system and error message displayed contains "Login was unsuccessful."
      And  the color of this message is red #e4434b