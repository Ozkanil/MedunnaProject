@info
Feature: edit info

  @info
  Scenario Outline: View patient info

    When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is successful
    When user clicks my pages dropdown
    And user clicks search patient dropdown
    And user provides a valid ssn number into search box

  |SSN       |
  |345-34-2323|
    And user clicks show appointments button
    And user clicks edit button
    Then user verifies create or edit an appointment pages
    And user provides anamnesis "<anamnesis>"
    And user provides treatment "<treatment>"
    And  user provides diagnosis "<diagnosis>"
    And user clicks save button

    Examples:
      |username|password|anamnesis |treatment|diagnosis|
      |penny   |852963  |cough     |outpatient|covid   |
