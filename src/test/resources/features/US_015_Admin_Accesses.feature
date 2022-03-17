@US_015
Feature: Create or Edit Patient by just Admin Validate with API
  @ApiRegistrant
  Scenario: : TC_0001 New patients can only be created by admin
    Given User signs in as an Admin
    Then User clicks Patient button under Items&Titles
    Then User clicks the Create a new Patient button
    Then User fill out the formula and clicks to Save button
    Then User verifies that the new user created Alert
    Then User verifies that the new Patient also in Patients Page
    Then User click signout
    Given user set the url and generate the token for getting all patients
    Then user validate the all infos



  Scenario: TC_0002 Admin can see all patient information such as;
  SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group,
  Address, Description, Created Date, User, Country and state / City
    Given User signs in as an Admin
    Then User clicks Patient button under Items&Titles
    Then User clicks the first View button between Patients
    Then User verifies that the requeriments
    Then User click signout

  Scenario: TC_0003 When creating or updating patient data,
  you have above items and following new item;id.
    Given User signs in as an Admin
    Then User clicks Patient button under Items&Titles
    Then User clicks the first Edit button between Patients button between Patients
    Then User Verifies the id box
    Then User click signout


  Scenario: TC_0004 Also Only admin can assign patient their doctor
    Given User signs in as an Admin
    Then User clicks Appointment button under Items&Titles
    Then User clicks the first Edit button between Patients
    Then User assign a doctor to Patient
    Then User assign a  Patient  to doctor
    Then User verifies the Successfully message
    Then User click signout


  Scenario: TC_0005 State should be provided as US state and cannot be blank
    Given User signs in as an Admin
    Then User clicks State and City button under Items&Titles
    Then User creates the list of Name of States
    Then User verifies that all State are not in US
    Then User verifies that all there is no blank between States name
    Then User click signout


  Scenario: TC_0006 Admin can delete any patient
    Given User signs in as an Admin
    Then User clicks Patient button under Items&Titles
    Then User clicks the first Delete button between Patients
    Then User verifies the fail message
    Then You should report this Bug


