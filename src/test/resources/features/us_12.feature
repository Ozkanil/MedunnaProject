@request_a_test
Feature: US_12
    @doctor_request_test
  Scenario Outline: TC01 Doctor may request a test

Given user on the Create or Edit an Appointment page
When user clicks on the Request A Test button
Then verify by id's that each test type is included as a checkmark option
And user checks randomly one of them
When user clicks on the Save button
Then user should see the "<message>"

    Examples:
   |message|
   |A new Test is created with identifier|


@doctor_show_test_results
Scenario:user should be able to see test results
    Given user on the Create or Edit an Appointment page
    When user clicks on the Show Test Results button
    Then user should see Tests
    When user clicks on View Result button of first test
    Then user should see Test Results including all necessary information



@admin_request_test
Scenario Outline:TC02 admin may not request a test
    Given user sign in as a "<title>"
    And user selects Appointment item and clicks
    And user clicks on the view button
    When user click edit button
    Then user should NOT see Request A Test button
    When user navigates to the test request page "<url>"
    Then user should see the unauthorized "<message>"
    Examples:
        |title|message                                    |url                                     |
        |admin|You are not authorized to access this page.|https://medunna.com/physician_test/11883|
    @staff_request_test
    Scenario Outline:TC03 staff may not request a test
        Given user sign in as a "<title>"
        And user selects Search Patient item and clicks
        And user clicks on the view button
        When user click edit button
        Then user should NOT see Request A Test button
        When user navigates to the test request page "<url>"
        Then user should see the unauthorized "<message>"
        Examples:
            |title|message                                    |url                                     |
            |staff|You are not authorized to access this page.|https://medunna.com/physician_test/11883|
    @patient_request_test
    Scenario Outline:TC04 patient may not request a test
        Given user sign in as a "<title>"
        And user selects My Appointments item and clicks
        When user clicks on the Show Tests button
        Then user should NOT see Request A Test button
        When user clicks on View Result button of first test
        Then user should NOT see Request A Test button
        When user navigates to the test request page "<url>"
        Then user should see the unauthorized "<message>"
        Examples:
            |title  |message                                    |url                                     |
            |patient|You are not authorized to access this page.|https://medunna.com/physician_test/11883|
