Feature: Registrant DB test

  @DBRegistrant
  Scenario Outline:
    Given user gets the "<column>" of registrant "<user>" from "<table>" table
    Then user validates "<data>" from "<COLUMN>" column
    Examples:test data
      | user     | table    | data                       | COLUMN |
      | Makeda   | jhi_user | 250-83-6242                | ssn    |
      | Federico | jhi_user | 059-97-1070                | ssn    |
      | Makeda   | jhi_user | stanton.rice@yahoo.com     | email  |
      | Federico | jhi_user | nathanial.legros@yahoo.com | email  |