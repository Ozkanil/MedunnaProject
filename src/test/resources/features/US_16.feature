@US16
Feature: Room creation by Admin. View, Update, Delete, Validate them also with API and DB

  Background:UI sign in as an admin and navigate to Create or edit a Room page
    Given user sign in as a "admin"
    And user navigates page to Rooms page
    When user clicks on Create a new Room button
    Then verify that user on the "Create or edit a Room" page
  @US16_TC01
  Scenario: User (Admin) can create new rooms for impatients. Created date as MM/DAY/YEAR and cannot be typed earlier
    Given user provides a Room Number
    And user provides a Price
    And user sets date as "03/12/2022"
    When user clicks on the Save button
    Then user should see the "A new Room is created"
    And verify that Created Date is updated automatically
@US16_TC02
  Scenario: When creating a room, there should be room number (required field),room type as TWIN, DELUXE, PREMIUM_DELUXE, SUIT and DAYCARE, Current status can be set for the room,Price can be added and cannot be blank,Description can be provided optionally
    Given user leave blank Room Number field and click enter
    And user should see "This field is required." feedback twice
    When user clicks on the Room Type dropdown
    Then user should see options like "TWIN", "DELUXE", "PREMIUM_DELUXE", "SUITE" and "DAYCARE"
    And user can set current status for the room

  @US16_TC03
    Scenario:Admin can view all rooms with same items,Admin can edit(update) existing rooms,Rooms can be Deleted by admin
      Given user on the Rooms page
      And user should see all rooms on the same page
      When user clicks on "edit" button for last created room
      Then verify that user on the "Create or edit a Room" page
      And user provides "Room without TV" as description
      When user clicks on the Save button
      Then user should see the "Room is updated"
      When user clicks on "delete" button for last created room
      And user confirms delete operation
      Then user should see the "Room is deleted"


#
#  Scenario: Validate all rooms with API creating
#    Given user sets the necessary path params for "creating" a room
#    And user sets the expected data "createdBy", "createdDate", "description", "id", "price", "roomNumber", "roomType", "status"
#      |createdBy|createdDate|description|id|price|roomNumber|roomType|status|
#    When user sends the "POST" request
#    Then status code should be 201
#    Then verify that the response body should be as an expected
#
#  Scenario: Validate all rooms with API reading
#    Given user sets the necessary path params for "reading" a room
#    And user sets the expected data "createdBy", "createdDate", "description", "id", "price", "roomNumber", "roomType", "status"
#    |createdBy|createdDate|description|id|price|roomNumber|roomType|status|
#    When user sends the "GET" request
#    Then status code should be 200
#    Then verify that the response body should be as an expected
#
#  Scenario: Validate all rooms with API updating
#    Given user sets the necessary path params for "updating" a room
#    And user sets the expected data "createdBy", "createdDate", "description", "id", "price", "roomNumber", "roomType", "status"
#      |createdBy|createdDate|description|id|price|roomNumber|roomType|status|
#    When user sends the "PUT" request
#    Then status code should be 200
#    Then verify that the response body should be as an expected
#
#  Scenario: Validate all rooms with API deleting
#    Given user sets the necessary path params for "deleting" a room
#    When user sends the "DELETE" request
#    Then status code should be 202
#    Then verify that the response body should be as an expected
#
#    Scenario: Validate them with DB
#      Given user connects to the Database
#      When user gets all data from the "rooms" table
#      And verify that the data includes "createdBy", "createdDate", "description", "id", "price", "roomNumber", "roomType", "status" information
#      Then user close the database connection
#
#



















