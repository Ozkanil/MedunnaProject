
Feature: admin create user to physician role

  @AdmCrtDr
  Scenario Outline: admin create physician from admin page
    Given User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user verifies that sign in is successful
    And user clicks administration dropdown button on admin page
    And user clicks user management button on admin page
    And user verifies user page is visible
    And user clicks to create a new user button
    And user verifies create or edit page visible
    And user creates physician username "<user>"
    And  user provides physician firstname and lastname "<firstName>" and "<lastName>"
    And user provides physician email "<email>"
    And user provides physician ssn id "<ssn>"
    And user clicks rollPhysician on profiles iframe
    Then user clicks save physician button
    And user clicks go to last int page button on admin page
    And user clicks delete button on admin page
    Then user clicks confirm deletebutton on admin page

    Examples:Test data
      |username |password  |user           |firstName  | lastName |email                |   ssn     |
      |olleydone|Cxz098!@# | alpiniasanlio |Alpini     |Aslanlio  | alpiniasanlio@aa.com|384-37-1927|



