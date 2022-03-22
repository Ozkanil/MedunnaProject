@Room_reserved
  Feature: Room reserved by doctor
    @Room_reserved
    Scenario Outline: TC_003 room reserved by doctor
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
      And user clicks roomtextbox
      And user selects room number "<902>" in room TextBox
      Then user clicks on the save button


      Examples: test data
        |username     |password |fromdate  |todate    |roomnumber |
        |arifcanpol135|!2qweASD |01-03-2022|15-03-2022|902       |
