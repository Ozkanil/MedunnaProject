@US16_API
Feature:Validate Room creation by Admin. Create View, Update, Delete with API
  @US16_API_TC01
    @ApiRegistrant
  Scenario Outline: Validate rooms with API creating
    Given set the expected data "<description>", <price>, "<roomType>" and "<status>"
    When user sends the "POST" request
    Then status code should be 201 for rooms
    Then verify that the response body should be as an expected data
  Examples:
    |description|price|roomType|status|
    |With TV    |200  |DELUXE  |false |

  @US16_API_TC02
    @ApiRegistrant
  Scenario Outline: Validate all rooms with API reading
    Given set the expected data "<description>", <price>, <roomNumber>, "<roomType>" and "<status>"
    When user sends the "GET" request
    Then status code should be 200 for rooms
    Then verify that the response body contains all expected data
  Examples:
    |description|price|roomNumber|roomType|status|
    |critical   |100  |3626      |DAYCARE |true  |
    |mus        |111  |1111      |TWIN    |true  |
  @US16_API_TC03
    @ApiRegistrant
  Scenario Outline: Validate rooms with API updating
    Given set the expected data "<description>", <price>, <roomNumber>, "<roomType>" and "<status>" for <roomId>
    When user sends the "PUT" request
    Then status code should be 200 for rooms
    Then verify that the response body should be as an expected
    Examples:
      |description|price|roomNumber|roomType|status|roomId|
      |critic     |120  |3626      |DAYCARE |true  |31701 |
  @US16_API_TC04
  @ApiRegistrant
  Scenario: Validate rooms with API deleting
    Given user sends the delete request
    Then status code should be 204 for rooms
