@RA
Feature: Registrant api test

  @ApiRegistrant
  Scenario Outline: API testing
    Given user sets the necessary path params
    And user sets the expected data "<firstname>", "<lastname>", "<SSN>", "<email>", "<username>", "<password>", "<lan>"
    And user sends the POST request and gets the response
    When user saves the api records to correspondent files
    Then user validates api records

    Examples: api test data
      | firstname | lastname | SSN         | email                | username    | password | lan |
      | Omar      | Sensei   | 455-56-5621 | omarsensei@gmail.com | omarrsensei | omar$1.  | en  |

  #registrant_endpoint=https://medunna.com/api/users?=size=200

  @ApiRegistrant
  Scenario Outline: API testing
    Given user set the url and generate token
    Then user validate the "<data>" from "<column>"
    Examples:
      | data        | column |
      | 484-04-2716 | ssn    |