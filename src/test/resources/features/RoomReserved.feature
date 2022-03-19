@Room_reserved
  Feature: Room reserved by doctor
    @Room_reserved
    Scenario Outline: TC_003 room reserved by doctor
    When user navigates to the medunna home page
    And user clicks sign in icon above the registration icon and navigates to sign in page
      And user enters user name "<username>" and password "<password>"
    And user clicks on Sign in button
    And user verifies the home page
    And user clicks my page icon
    And user clicks my InPatient icon
    And user verifies to InPatients page
    And user provıdes from date "<fromdate>" and to date "<todate>" in date text boxes
    And user clicks on the edit button
    And user provides room number "<roomnumber>" in room TextBox
    Then user clicks on the save button


      Examples: test data
        |username     |password |fromdate  |todate    |roomnumber |
        |arifcanpol135|!2qweASD |14-03-2022|25-03-2022|256        |
