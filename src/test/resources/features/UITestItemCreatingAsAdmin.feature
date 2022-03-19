Feature: creating Test Item as Admin

  Background: admin registration
    Given user registers as admin "omradmin" , "951753"


    @TestItems
      Scenario Outline:
    Given user navigates to Test Items page
    And use clicks on Create a new Test Item button
    And user will provide credentials "<name>", "<description>", "<price>", "<def_min_value>", "<def_max_value>"
    When user clicks on the Save button
    Then user A new Test Item is created message
    Examples: test data
      |name|description|price|def_min_value|def_max_value|
      |John|headache   |1000 |1.5          |1.9          |
