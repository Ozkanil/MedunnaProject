@login_page_feature
Feature: User login

  @smoke
  @user_login_post
  Scenario Outline: Verifying user login with correct username and password

  When User navigates to the home page
  And user clicks sign in button at the home page and navigates to sign in page
  Then user verifies that sign in page header is visible
  And user enters username "<username>" and password "<password>"
  And user clicks sign in button
  Then user verifies that sign in is successful
  And user clicks sign out and verifies sign out

    Examples:Test data
    |username|password|
    |hazel     |13579  |

  @user_login_negative
  Scenario Outline: Verifying that user cannot login with incorrect or missing login data

    When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is unsuccessful in case "<case>"

    Examples:Test data
      |username|password|case|
      |        |        |1   |
      |frank   |123456  |2   |
      |frank1  |123456f |2   |
      |frank1  |123456f |2   |

    @cancel_login
    Scenario: User cancels login on login page

      When User navigates to the home page
      And user clicks sign in button at the home page and navigates to sign in page
      Then user verifies that sign in page header is visible
      And user clicks cancel button
      Then user verifies that signin is canceled and user is on home page

    @rememberme_box
    Scenario: User can see and click remember me box

      When User navigates to the home page
      And user clicks sign in button at the home page and navigates to sign in page
      Then user verifies that sign in page header is visible
      And user verifies that remember me box is visible and clickable


     @password_reset @smoke
     Scenario: User can see and click password reset option

      When User navigates to the home page
      And user clicks sign in button at the home page and navigates to sign in page
      And user verifies that sign in page header is visible
      And user verifies that password reset button is visible and clicks it
      Then user verifies that navigated to the password reset page

      @registration_page @smoke
      Scenario: User can see and click register button

      When User navigates to the home page
      And user clicks sign in button at the home page and navigates to sign in page
      And user verifies that sign in page header is visible
      And user verifies that register button is visible and clicks it
      Then user verifies that navigated to the registration page





