@staff_edit_appointment
Feature: Staff can edit patient appointment

  @appointment_edit_unapproved
  Scenario Outline: Staff can edit appointment with unapproved status

    When User navigates to the home page
    #And user makes an appointment providing "<firstName>" "<lastName>" "<ssn>" "<email>" "<phone>" "<date>"
    And user signs in as staff providing "<username>" "<password>"
    When user clicks my pages
    And user clicks search patient
    And user provides a valid ssn number into search box
      |ssn        |
      |555-66-7777|
    And user click show appointments button
    Then user verifies appointments page header
    And user clicks edit button at the first appointment
    Then user verifies create and edit appointments page
    And user makes necessary updates and sets the status as unapproved
    And user click save button
    Then verifies update is successful

    Examples: Appointment data

      |firstName|lastName|ssn         | email        | phone    |date       |username|password|
      |Jack      |Lost   |555-66-7777 |jack@gmail.com|5469875690| 26-03-2022|hazel   |13579   |