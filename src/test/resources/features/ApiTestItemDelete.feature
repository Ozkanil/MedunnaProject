Feature: api test item deletion

  @ApiTestItemDelete
  Scenario Outline: api test item deletion
    Given user sets the necessary path parameters "<id>"
    When user sends delete request and gets the response
    Then user validates that the item "<id>" has been deleted
    Examples: test data
      | id    |
      | 30164 |
      | 30161 |

