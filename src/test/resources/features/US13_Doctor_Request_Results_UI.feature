Feature:US13 After test results request and staff updates for test results,
  doctor can see all test information such as; id, name(Urea, Sodium, Glucose etc..),
  default max value, default min value, test, description and the date

  @Request_Test_Result
  Scenario: TC_0013
    Given Go to medunna homepage
    Then Sign in as a Doctor
    Then Click the Items&Titles
    And Click the Test Item
    Then Check the id, name(Urea, Sodium, Glucose etc..), default max value, default min value, test, description and the date





