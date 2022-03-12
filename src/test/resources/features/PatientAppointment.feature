@patient_appointment
 Feature: patient appointment
  @user_login_positive
Scenario Outline: test appointments

Given user clicks on make an appointment
And user provides the appoinment name "<firstName>"
And user provides the appointment lastname "<lastName>"
And user provides ssn and email "<ssn>" and "<email>"
When user provides the phone number "<phone>"
And user provides the date "<startDate>"
Then user requests appointment and verifies the success message
Examples: test data

|email             |firstName|lastName|phone       |ssn        |startDate |
|alpaslan@gmail.com|Alp      |Aslan   |253-143-2837|578-12-4732|07-09-2022|