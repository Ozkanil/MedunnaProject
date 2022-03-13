
@crossbrowser_testing_login
Feature: User login


    @user_login_chrome
  Scenario Outline: Verifying user login with correct username and password

    When User navigates to the home page in chrome
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is successful
    And user clicks sign out and verifies sign out

    Examples:Test data
      |username|password|
      |hazel     |13579  |



  @user_login_firefox
  Scenario Outline: Verifying user login with correct username and password

    When User navigates to the home page in firefox
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is successful
    And user clicks sign out and verifies sign out

    Examples:Test data
      |username|password|
      |hazel     |13579  |