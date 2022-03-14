@Password_Setting
Feature: setting homepage feature

  Background:
    Given User navigates to "https://www.medunna.com/"
    When User clicks on SignIn button  on the right top
    Then User clicks on signIn in dropdown list



  Scenario Outline: User creates a new Password
    Then User enters username "mclara"
    Then User enters password "<password>"
    Then User clicks on sign in button
    Then  User clicks on newly signedIn User
    Then User clicks on Password option on the dropdown
    Then User enters current password "<currentPwd>"
    Then User enters new password "<newPwd1>"
    Then User reenters new password "<newPwd2>"
    And  User clicks on Save Button
    Then User verifies the message "Password changed!"
    Examples: Test Data
      | password | currentPwd | newPwd1 | newPwd2 |
      | 123abc$  | 123abc$    | 123abc$ | 123abc$ |