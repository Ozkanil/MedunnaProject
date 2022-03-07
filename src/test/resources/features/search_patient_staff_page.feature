Feature: Search patient on staff page

  @view_patients_staff_page
  Scenario Outline: View patient info

    #When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is successful
     When user clicks my pages
     And user clicks search patient
     And user provides a valid ssn number into search box
        |ssn        |
        |777-85-7963|

     And user clicks view button
     Then user verifies patient info is visible
     And user clicks back button

    Examples:
      |username|password|
      |hazel   |13579   |


  @edit_patient_info
  Scenario Outline: Edit patient info

    #@When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is successful
    When user clicks my pages
    And user clicks search patient
    When user provides a valid ssn number into search box
      |ssn        |
      |777-85-7963|
    And user clicks edit button
    Then user verifies create or edit patient page
    And user provides necessary data to edit patient info
    And user clicks save button
    Then user verifies patient info update message

    Examples:
      |username|password|
      |hazel   |13579   |

    @view_edit_appointments
    Scenario Outline: View appointments

    #When User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    Then user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    Then user verifies that sign in is successful
    When user clicks my pages
    And user clicks search patient
    When user provides a valid ssn number into search box
        |ssn        |
        |610-64-0981|
    And user clicks show appointments button
    Then user verifies appointments page header
    And user clicks edit button under appointments
    Then user verifies create and edit appointments page
    And user makes necessary updates
    And user clicks save button
    Then verifies update is successful


      Examples:
        |username|password|
        |hazel   |13579   |
