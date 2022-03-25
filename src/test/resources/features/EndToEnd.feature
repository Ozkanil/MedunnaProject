@endToend
Feature:validating whole process from making an appointment to receiving an invoice
  @user_register
  Scenario: patient makes an appointment and gets an invoice after whole process, which is done by admin, doctor and staff.
    Given User registers to the page as a "patient"
    And Admin signs in and assign user as a "patient"
    And Patient signs in and makes an appointment
    And User registers to the page as a "staff"
    And Admin signs in and assign user as a "staff"
    And The staff signs in and approves the appointment
    And The staff assigns the appointment to a doctor
    And The doctor edits the appointment by asking test results
    And The staff approves the test request and updates it
    And The doctor views test results, gives prescription, changes status as completed and request inpatient
#    And Admin create a room for inpatients
    And The staff approves inpatient request and assigns a room for patient
    And The doctor updates status inpatient as discharged
    And The staff views updated status and creates an invoice
    When The patient views the invoice
    Then The patient has an heart attack