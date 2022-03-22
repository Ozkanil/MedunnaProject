@Update_status
  Feature: update status


    @Update_status
    Scenario Outline: TC_002 updates by doctor status
      When User navigates to the home page
      And user clicks sign in button at the home page and navigates to sign in page
      Then user verifies that sign in page header is visible
      And user enters username "<username>" and password "<password>"
      And user clicks sign in button
      Then user verifies that sign in is successful
      And user clicks my pages dropdown
      Then user clicks my Inpatients dropdown
      And user verifies Inpatients page
      And user provides from date "<fromdate>" and to date "<todate>"
      Then user clicks edit button

      And user clicks status textbox
      And user selects cancelled choice from status
      Then user clicks save button

      Examples: test data
      |username     |password |fromdate  |todate    |status |
      |arifcanpol135|!2qweASD |01-03-2022|15-03-2022|cancelled|