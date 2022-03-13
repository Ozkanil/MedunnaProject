@US_13
Feature:US13 After test results request and staff updates for test results,
  doctor can see all test information such as; id, name(Urea, Sodium, Glucose etc..),
  default max value, default min value, test, description and the date
  and Doctor and also request In patient ( patient can stay in hospital )


  @doctor_show_test_results
  Scenario:user should be able to see test results
    Given user on the Create or Edit an Appointment page
    And user clicks on the Request Inpatient button
    When user clicks on the Show Test Results button
    Then user should see Tests
    When user clicks on View Result button of first test
    Then user should see Test Results including all necessary information
  @ApiRegistrant
  Scenario:
    Given user set the url and generate the token for patient page
    Then user validate the in patient ( patient can stay in hospital )
