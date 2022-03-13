@optional
Feature: optional test
  Scenario Outline: info is optional

    When user navigates to the the home page
    And user clicks in sign in button
    And user enters username "<username>" and password "<password>"
    And  user clikcs the sign in button and verifies my pages
    And user clicks my pages dropdown
    And user clicks search patient
    And user click show appointments button
    And  user click on edit button
    And  user types a text to prescription box is optional
    Then user types a text to Description box is optional

    Examples:test data
      |username  |password |
      |penny      |852963   |