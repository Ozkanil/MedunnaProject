@Status_selected
Feature: status
  Scenario Outline: select status
    When user navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user clicks my pages dropdown
    And user clicks  on my Appointment icon
    And user types from date "<fromdate>"
    And user types to date on "<todate>"
    And user navigates in patient page
    And user clicks edit button
    And  user navigates in create or edit an appointment page
    And user selects from status text box pending,completed or cancelled
    Then user clicks save button
  Examples: test data
  |username  |password  |fromdate     |todate   |
  |tom       | 123456   |04-03-2022    |17-03-2022|
