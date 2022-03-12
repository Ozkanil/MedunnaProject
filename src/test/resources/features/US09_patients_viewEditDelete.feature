@US_09
Feature: test all patient data

  @SmokeTest
  @UIpatient
  Scenario: test registration
    Given user goes to "https://medunna.com"
    And   User navigate to and click on Sign In button
    And   User insert username as a Admin acount
    And   User insert password as a AdminPass
    And   User click on Sign In button
    And   User navigate to and click on Item and Title tab
    And   User click on Patiente from the dropdown menu
    And   User click on view button
    Then  User verifies patient information

  @US_09-TC_02
  Scenario: User can edit all patient information
    When User signs in as Staff "staffrecep"-"123Recep"
    Then click on MY pages dropdown
    Then click on Search Patient button
    Then click on edit button on patient info as Staff User
    Then edit the patient informations and click on save button
    Then verify patient informations are updated
    Then sign out
    Then User signs in as Admin "mclara"-"123abc$"
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then click on edit button on patient info as Admin User
    Then edit the patient informations and click on save button as Admin
    Then verify patient informations are updated as Admin
    Then sign out

  @US_09-TC_03
  Scenario: User can search for a new applicant by their SSN and see all their registration info populated
    When User signs in as Staff "staffrecep"-"123Recep"
    Then click on MY pages dropdown
    Then click on Search Patient button
    Then enter a valid SSN ID in the Patients search box
    Then verify the patient informations are invoked
    Then sign out

  @US_09-TC06
  Scenario: User can delete any patient info
    When User signs in as Admin "mclara"-"123abc$"
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then click on Delete button on the patient you want to delete
    Then click on Delete button on the opening alert
    Then verify patient is deleted
    Then sign out

  @US_09-TC07
  Scenario:All options above can be done by an Admin and staff, but staff cannot delete patients
    When sign out
    When User signs in as Staff "staffrecep"-"123Recep"
    Then click on MY pages dropdown
    Then click on Search Patient button
    Then verify Delete button is not dispalyed
    Then sign out

  @US_09-TC08
  Scenario: Staff should be able to search the patients by their SSN ids, but Admin cannot
    When User signs in as Admin "mclara"-"123abc$"
    Then click on Items&Titiles dropdown
    Then click on Patients
    Then verify Patient Search Box is not visiabte
