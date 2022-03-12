@new_appointment
Feature: new appointment
  Scenario Outline: test new appointment
    When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user clicks on my pages dropdown
    And user clicks on Make an Appointments icon
    Then verify Make an Appointmet page
    And user enters  firstname "<firstname>"
    And user enters  lastname "<lastname>"
    And user enters ssn number "<ssn>"
    And user enters email addresse "<email>"
    And user enters a phone number "<phone>"
    And user enters  appointment date time "<appointmentdatetime>"
    Then  user clicks send an appointment request button
    Then user verifies appointment success message
    Examples: test data
      |username|password|firstname|lastname|ssn  |email             |phone   |appointmentdatetime|
      |sally   |159753  |Sally    |Jim  |876-58-9658|sally@gmail.com|1732561100|12-03-2022       |