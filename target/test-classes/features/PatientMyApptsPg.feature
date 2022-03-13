Feature: patient checks my appointments page

  @patient_myappos
    @SignIn_Page
  Scenario Outline: patient valid credentials
    Given user verifies sign in page is visible
    And user provides the patient username "<username>"
    And user provides the patient password "<password>"
    And user clicks on the login button
    Then user verifies my pages patient is visible
    Given user clicks my page dropdown
    And user clicks on my appointments
    And user verifies appointments text
    And user sends the date "<from>" to from iframe
    And user sends the date "<to>" to to iframe
    Then user verifies success message

    Examples: patient login test

      |  username | password  |from       | to       |
      |  alpaslan | Gf%^45H|07-01-2022 |07-15-2022|






