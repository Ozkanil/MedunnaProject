Feature: View
  @View_by_doctor
  Scenario Outline:View information
    When user navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
#    And user verifies home page
#    And user clicks my pages dropdown
#    And user clicks  on my inpatients dropdown
#    And user verifies in patient page
#    And user provides from date "<fromdate>" and to date "<todate>"
#    And user views all patient info


      |username  |password  |fromdate     |todate  |
      |penny     |852963    |11-03-2022    |24-03-202|

