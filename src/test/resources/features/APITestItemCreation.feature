Feature: api test item creation

  @ApiRegistrant
  @ApiTestItemCreation
  Scenario Outline: api test item creation
    Given user sets the necessary path parameters
    And user sets the expected data "<defMaxVal>", "<defMinVal>", "<description>", "<name>", "<price>"
    And user send the post request and gets the response
    When user saves the api records to correspondent file
    Then user validates all api records
    Examples: test data
    |defMaxVal|defMinVal|description|name|price|
    |1.5      |1.7      |headache   |John|200  |

