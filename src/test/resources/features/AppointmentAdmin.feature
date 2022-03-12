@AA
Feature: test appointment page as admin

  @SignIn_Page
  @UIAppointmentAdmin
  Scenario Outline:  test appointment page as admin
    Given user logs in as admin "<username>","<password>"
    And user navigates to appointment page
    And user clicks to Create a new Appointment button
    And user provides start date time and end date time
    And user chooses status "<status>"
    And user provides Anamnesis "<Anamnesis>" , Treatment "<Treatment>" , Diagnosis "<Diagnosis>" , Prescription "<Prescription>" , Description "<Description>"
    And user chooses Physician "<Physician>", Patient "<Patient>"
    When user click on save button
    Then user validates success message

    Examples: test data
      | username | password | status  | Anamnesis | Treatment   | Diagnosis | Prescription | Description | Physician | Patient |
      | omradmin | 951753   | PENDING | wdesfrg   | paracetamol | headache  | dwefrdfdr    | fergtfese   | 10504     | 4859    |
