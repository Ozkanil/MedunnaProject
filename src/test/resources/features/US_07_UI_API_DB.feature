@US_07_UI_API_DB
Feature: Appointment api test
  @smoke
  @user_login_positive
  @Appointment_UI
  Scenario Outline: test appointments
    Given user clicks on make an appointment
    And user provides the appoinment name "<firstname>"
    And user provides the appointment lastname "<lastname>"
    And user provides ssn and email "<SSN>" and "<email>"
    When user provides the phone number "<phoneNumber>"
    And user provides the date "<date>"
    Then user requests appointment and verifies the success message
    Examples: test data
      |firstname|lastname|SSN|email|phoneNumber|date|
      |eymen    |arzu  |251-48-4848|eymen@arzu.com|123-123-1234|06-07-2022|

  @ApiRegistrant
  @ApiAppointmentCreationPost
  Scenario Outline: appointment test
    Given user sets the necessary path params for appointment creation
    And user sets the expected data "<firstname>", "<lastname>" "<SSN>" "<email>" "<phone>"  and "<date>"
    And user sends the POST request and gets the response for appointment creation
    When user saves the appointment records to correspondent files
    Then user validates appointment records

    Examples: api test data
      | firstname | lastname | SSN         | email                  | phone        | date       |
      |eymen|arzu| 252-48-4848             |eymen@gmailcom|123-123-1234 | 2022-11-12 |
  @ApiRegistrant
  @ApiAppointmentCreationGet
  Scenario: api get request for appointment
    Given user sends the get request for appointments data
    And user deserializes data to Java for appointments
    And user saves the users data to correspondent files for appointments


  @AppointmentDBValidation
  Scenario Outline: Data Base appointment validation  with id
    Given user connects to the database
    And user selects all "id" column data
    And user verify "<id>" with the database
    Then close the database connection

    Examples:
      |id|
      |2301|
      |4673|
      |6557|