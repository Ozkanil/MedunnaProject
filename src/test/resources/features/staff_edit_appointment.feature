@staff_edit_appointment
Feature: Staff can edit patient appointment

  @appointment_edit
  Scenario Outline: Staff can edit appointment with applicable statuses

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
    And user makes necessary updates and sets the status "<status>"
    And user click save button
    Then verifies update is successful
    And user clicks sign out and verifies sign out

    Examples: Appointment data

      |firstName|lastName|ssn         | email        | phone    |date       |username|password|status|
      |Jack      |Lost   |555-66-7777 |jack@gmail.com|5469875690| 26-03-2022|hazel   |13579   |0     |
      |Jack      |Lost   |555-66-7777 |jack@gmail.com|5469875690| 26-03-2022|hazel   |13579   |1     |
      |Jack      |Lost   |555-66-7777 |jack@gmail.com|5469875690| 26-03-2022|hazel   |13579   |3     |


  @appointment_edit_completed
  Scenario Outline: Staff can edit appointment with non-applicable status

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
    Then user verifies that completed option is disabled

    Examples: Appointment data

      |firstName|lastName|ssn         | email        | phone    |date       |username|password|
      |Jack      |Lost   |555-66-7777 |jack@gmail.com|5469875690| 26-03-2022|hazel   |13579   |

  @staff_view_test_results
  Scenario Outline: Staff can view test results

    When User navigates to the home page
    And user signs in as staff providing "<username>" "<password>"
    When user clicks my pages
    And user clicks search patient
    And user provides a valid ssn number into search box
      |ssn        |
      |555-66-7777|
    And user click show appointments button
    Then user verifies appointments page header
    And user clicks show tests for the given patient
    And user clicks view tests
    Then user verifies that test results are visible

    Examples: Appointment data

      |username|password|
      |hazel   |13579   |
