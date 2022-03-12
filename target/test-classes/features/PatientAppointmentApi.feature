Feature: Registrant api test
  @ApiRegistrant
    @patient_api
  Scenario: registrant test
    Given user sets the necessary path params
    And user sets the expected data "<firstname>", "<lastname>", "<SSN>", "<email>", "<username>", "<password>", "<lan>"
    And user sends the POST request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records
#    Examples: api test data
#      |firstname|lastname|SSN        |email         |username|password|lan|
#      |Alp      |Aslan   |578-12-4732|slan@gmail.com|alpaslan|Gf%^45H |en |
  @ApiRegApp
  Scenario:  api get request for regAppointment
    Given user sets the necessary path params for appo reg
    When user sends the get request for appointment registration data
    Then user validates api records of registered appointment
