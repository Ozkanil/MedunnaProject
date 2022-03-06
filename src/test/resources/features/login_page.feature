Feature: User login

  @user_login_positive
  Scenario Outline: Verifying user login with correct username and password

  When User navigates to the home page
  And user clicks sign in button at the home page and navigates to sign in page
  Then user verifies that sign in page header is visible
  And user enters username "<username>" and password "<password>"
  And user clicks sign in button
  Then user verifies that sign in is successful

    Examples:Test data
    |username|password|
    |tom     |123456  |

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

      #When User navigates to the home page
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








