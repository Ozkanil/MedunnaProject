Feature: admin assign user to physician role
  @AdmLogDr
  Scenario Outline: create physician by user registrant

          Given user is on the common page
          And user navigates to registration page
          And user provides ssn id "<ssn>"
          And  user provides physician firstname and lastname "<firstName>" and "<lastName>"
          And user provides physician email "<email>"
          And user creates physician username "<user>"
          And user generates the password "<password>"
          And user cliskc registers button
          Then user creates the records to a physician file

    Examples: test user data
      |ssn        |firstName   |lastName  |user         |email                |password |
      |384-37-1127|Alpini      |Aslanli   |alpiniaslanli|alpiniaslan@gmail.com|Gf12gF!2 |

    @AdmLogDr
    Scenario Outline: admin activate user and assign physician roll
      When User navigates to the home page
      And user clicks sign in button at the home page and navigates to sign in page
      Then user verifies that sign in page header is visible
      And user enters username "<username>" and password "<password>"
      And user clicks sign in button
      Then user verifies that sign in is successful
      And user clicks administration dropdown button on admin page
      And user clicks user management button on admin page
      And user clicks go to last int page button on admin page
      And user clicks Deactivated button to activate physician on admin page
      Then user clicks edit button on admin page
      And user verifies create or edit page visible
      And user clicks rollPhysician on profiles iframe
      And user clicks save physician button
      Then user verifies success message of roll update

      Examples:Test data
        |username |password  |user           |firstName  | lastName |email                |   ssn     |
        |olleydone|Cxz098!@# | alpiniasanlion |Alpinio     |Aslanlion  | alpiniasanlion@aa.com|384-37-1927|












