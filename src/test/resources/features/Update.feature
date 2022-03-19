@Update_status
  Feature: update status

    Background: user is on the home page
    @Update_status
    Scenario Outline: TC_002 updates by doctor status
    Given user navigates to the home page
    When user click sign in button at the home page and navigates to sign in page
    And user verify that Sign in text is visible
    And user enters user name "<username>" and password "<password>"
    And user clicks Sign in button
    And user verifies home page
    And user clicks my page dropdown
    Then user clicks my Inpatients dropdown
    And user verifies Inpatients page
    And user provıdes from date "<fromdate>" and to date "<todate>"
    Then user schould see and verify all patient information
     Then user clicks edit button

    And user provides staying "<status>"
    Then user clicks save button

      Examples: test data
      |username     |password |fromdate  |todate    |status |
      |arifcanpol135|!2qweASD |14-03-2022|25-03-2022|staying|