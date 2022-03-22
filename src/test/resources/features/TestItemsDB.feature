Feature: DB test items

  @DBTestItems
  Scenario Outline:
    Given user gets the "<COLUMN>" of registrant "<user>" from "<table>" table
    Then user validates "<user>" from "<COLUMN>" column
    Examples:test data
      | user     | table       | COLUMN |
      | Chas     | c_test_item | name   |
      | Fiona    | c_test_item | name   |
      | Prudence | c_test_item | name   |
