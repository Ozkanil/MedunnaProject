@US_02
Feature: US02 Choose a username that can contain any chars, but it cannot be blank and
  Username and email should be validated with API and DB

  @TC0001_UserName @Usernamebox_and_Emailbox_UI
  Scenario: TC_0001 Positive Scnenario with a valid username
    Given Go to medunna homepage
    Then User navigates to registration page
    Then User clicks on the username textbox
    Then Provide the valid username of the applicant
    Then User should not see the error message Your username is invalid., or Your username is required.

  @TC0002_UserName, @TC0003_UserName, @Usernamebox_and_Emailbox_UI
  Scenario Outline: TC_0002, TC_0003 and TC_0001 Negative Scnenario with a invalid usernames
    Given Go to medunna homepage
    Then User navigates to registration page
    Then User clicks on the username textbox
    Then Provide the "<invalid username>" of the applicant for usernamebox
    Then User should should see the error message.

    Examples: test data
      | invalid username |
      | Mus_ta!fa        |
      |                  |
      |                  |

  @TC0005_Email,@Usernamebox_and_Emailbox_UI
  Scenario: TC_0005 Positive Scnenario with a valid email
    Given Go to medunna homepage
    Then User navigates to registration page
    Then User clicks on the email textbox
    Then Provide the valid email of the applicant
    Then User should not see the error message Your email is invalid., or Your email is required.

  @TC0006_Email, @TC0007_Email, @TC0008_Email, @TC0009_Email, @TC00010_Email, @Usernamebox_and_Emailbox_UI
  Scenario Outline: TC_0005, TC_0006, TC_0001 Negative Scnenario with a invalid usernames
    Given Go to medunna homepage
    Then User navigates to registration page
    Then User clicks on the email textbox
    Then Provide the "<invalid email>" of the applicant for emailbox
    Then User should should see the error message.

    Examples: test data
      | invalid email      |
      | mustafaqa@gmail    |
      | mustafaqagmail.com |
      | mustafaqa@gmail    |
      | mustafaqa@com      |
      | mustafaqa          |

  @ApiRegistrant
    @Api_Username_email
  Scenario: TC_0004 username should be validated using api
    Given user set the url and generate the token
    Then user validate the email