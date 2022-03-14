@see_Patient_information
Feature: user sees all information
  @Patiet_information
  Scenario Outline: test see information
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
    Examples:
      |username|password|
      |penny    |852963 |
