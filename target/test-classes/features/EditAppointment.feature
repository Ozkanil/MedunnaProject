Feature: test appointment page as admin

  @SignIn_Page
  @UIEditAppointmentAdmin
  Scenario Outline:  test appointment page as admin
    Given user logs in as admin "<username>","<password>"
    And user navigates to appointment page
    And user clicks to edit button
    And user provides Treatment "<Treatment>" , Diagnosis "<Diagnosis>" , Prescription "<Prescription>"
    And user chooses Physician "<Physician>", Patient "<Patient>"
    When user click on save button
    Then user validates success message

    Examples: test data
      | username | password | Treatment   | Diagnosis   | Prescription | Physician | Patient |
      | omradmin | 951753   | paracetamol | stomachache | ctgyhj   | 10504     | 4859    |
