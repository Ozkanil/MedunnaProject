@end_to_end
@doctor_feature
Feature: US_10
  @my_appointments_ui_doctor
  Scenario Outline: doctor should be able to see his/her appointment list
    Given user sign in as a "<title>"
    And user selects My Appointments item and clicks
    When user on the Appointments page
    And user selects time slots providing "<fromDate>" and "<toDate>"
    Then user should see list of appointments and time slots
    Then user should see information of the appointment list
    Examples:
    |title |fromDate|toDate|
    |doctor|26/02/2022  |11/03/2022|

  @smoke
    @appointment_edit_doctor
    Scenario Outline: doctor should be able to edit appointments
      Given user on the Create or Edit an Appointment page
      And user verify appointment details like ID,StartDate,EndDate,Status
      And user should see three buttons for requesting and showing test and requesting inpatient
      And user clicks on the Request Inpatient button
      And user should be able to go back without saving
      And user changes the status of appointment
      And user types information for "<Anamnesis>", "<Treatment>", "<Diagnosis>", "<Prescription>", "<Description>"
      And user saves the changes
      Examples:
        |Anamnesis        |Treatment   |Diagnosis      |Prescription|Description       |
        |allergic reaction|nasal sprays|Skin Prick Test|Otrivin     |Breathing problems|
  @ApiRegistrant
  @my_appointments_api_doctor
  Scenario: doctor should be able to see his/her appointment list in api
    Given user sends get request to the "https://medunna.com/api/appointments/bydateandId?fromDate=2022-03-07&toDate=2022-03-10&userId=10097"
    Then status code should be 200
    And response format should be "application/json"
    And response body should include expected information

  @my_appointments_db_doctor
  Scenario Outline: doctor should be able to see his/her appointment list in database
    Given user connects to the Database
    When user gets "id, start_date, end_date, status" from the "appointment" table for "physician_id = 10501"
    And user verify that the data includes <id>, "<start_date>", "<end_date>" and "<status>"
    Then user close the database connection
Examples:
    |id   |start_date               |end_date                |status    |
    |11868|2022-03-07 00:00:00.0|2022-03-07 01:00:00.0|UNAPPROVED|
    |11883|2022-03-08 00:00:00.0|2022-03-08 01:00:00.0|CANCELLED |
    |11885|2022-03-10 00:00:00.0|2022-03-10 01:00:00.0|COMPLETED |

