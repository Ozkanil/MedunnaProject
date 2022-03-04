@US_001
  Feature: User_Story_001_Test

    @US_001_TC_0001_P
    Scenario Outline: TC_0001_positive_Scenario
      Given user is on the common page
      And user navigates to registration page
      And user clicks on the ssn textbox
      And user provides the valid "<SSN>" of the applicant
      Then Your SSN is invalid, or Your SSN is required should not be displayed

      Examples: TC_0001_positive_Scenario_Data
      |SSN        |
      |412-51-7857|



