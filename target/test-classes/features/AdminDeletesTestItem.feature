Feature: admin deletes test items
  Background: admin registration
    Given user registers as admin "omradmin" , "951753"
  @TestItemDeleted
  Scenario:
    Given user navigates to Test Items page
    When user deletes test item
    Then user validates deleted message

