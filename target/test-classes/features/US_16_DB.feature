@US16_DB
Feature: Validate Room creation by Admin with DB

    Scenario Outline: Validate all rooms with DB
      Given user connects to the Database
      When user selects "id, room_number,price, room_type, status, description" from the "room" table for "created_by = 'medunnaadmin'"
      And verify that the data includes <id>, <roomNumber>, "<price>", "<roomType>", "<status>", "<description>" information
      Then user close the database connection

      Examples:
        |description|price|roomNumber|roomType|status|id    |
        |           |299.00  |297       |TWIN    |false |31707 |
        |With TV    |200.00  |590       |DELUXE  |false |32638 |