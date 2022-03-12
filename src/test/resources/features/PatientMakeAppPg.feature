Feature: patient  make appointment from myPagePatient

  @patient_makeappo
    @SignIn_Page
  Scenario Outline: patient valid credentials
    Given user verifies sign in page is visible
    And user provides the patient username "<username>"
    And user provides the patient password "<password>"
    And user clicks on the login button
    Then user verifies my pages patient is visible
    Given user clicks my page dropdown
    And user clicks on make an appointment
    And user verifies the appointment name "<firstName>"
    And user verifies the appointment lastname "<lastName>"
    And user verifies ssn number "<ssn>"
    And user verifies email address "<email>"
    When user provides the phone number "<phone>"
    And user provides the date "<startDate>"
    Then user requests appointment and verifies the success message

    Examples: patient login test

      |  username | password  |email             |firstName|lastName|phone       | ssn         |startDate |
      |  alpaslan | Gf%^45H|alpaslan@gmail.com|Alp      |Aslan   |253-143-2837| 578-12-4732 |07-09-2022|
