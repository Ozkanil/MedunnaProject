@View_and_update_by_doctor
Feature: View by doctor
  @View_and_update_by_doctor
  Scenario Outline:TC_001 user views all information
    When user navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user verifies home page
    And user clicks my pages dropdown
    Then user clicks my Inpatients dropdown
    And user verifies Inpatients page
    And user provides from date "<fromdate>" and to date "<todate>"
    And user views all patient info
    Then user clicks edit button in the patient page
    And user can update all patient informations
    Then user clicks save button in create or edit a in patients page

      Examples: test data
      |username     |password|fromdate  |todate   |
      |arifcanpol135|!2qweASD|14-03-2022|25-03-2022|

