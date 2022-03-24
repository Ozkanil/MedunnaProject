@US_19_UI_API_DB
Feature: Staff features

  @Create_a_new_Staff
  Scenario Outline: Create new Staff using Search

    Given user create a new registrant
    And user logs in as admin "<username>", "<password>"
    And user navigates and validate to Staff page
    And user create a new Staff and search people using their SSN "<ssn>"
    And User validate to found with search SSN
    And user sends information should be populated
    Then user validate success message
    And User (Admin) can select a user from the existing users (registered people)
    And user on Create or edit a Staff Page clicks edit button
    And user edit their information
    And user save their information and validate success message
    And user delete and save their information
    Then user validate success message2

    Examples:
      | username   | password   |
      | eymenadmin | eymen12345 |



  @ApiRegistrant
  Scenario: api get request for staff

    Given user sends the get request for Staff data
    And user deserializes data to Java for Staff
    And user saves the users data to correspondent files for Staff



  @Validate_them_all_with_DB
  Scenario Outline: Data Base Staff validation with id

    Given user connects to the Staff database
    And user selects all Staff "id" column data
    And user verify Staff "<id>" with the database
    Then close the connection

    Examples: test data
      |id|
      |15529|


