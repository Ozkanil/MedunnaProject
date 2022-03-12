Feature: patient login to page
  @patient_logtpg
    @SignIn_Page
  Scenario Outline: patient valid credentials
    Given user verifies sign in page is visible
    And user provides the patient username "<username>"
    And user provides the patient password "<password>"
    And user clicks on the login button
    Then user verifies my pages patient is visible
    Given user clicks to account dropdown
    And user clicks to signout button
    And user verify logged out successfully
    And user clicks to signin again button
    Examples: patient login test
      |  username | password  |
      |  alpaslan | Gf%^45H|

  @SignIn_Page
  @patient_logtpg
  Scenario Outline: patient invalid credentials
    Given user provides the patient username "<username>"
    And user provides the patient password "<password>"
    And user clicks on the login button
    Then user verifies my pages patient is invisible
    Examples: patient login test
      | username  | password  |
      | alpaslanD | er54#@!b1 |