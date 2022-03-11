Feature: All locaters should work good


  @Staff
  Scenario: Checking In Patients Page as a Staff
    When User sign in as a Staff at homepage
    Then User clicks the In Patient under MY PAGES at homepage
    Then User verifies that he,she is in In patient page at In Patients Page
    Then User write a date fromDateBox
    Then User write a date toDateBox
    Then User clicks firts Edit Button
    Then User verifies that he,she is in In Patients Edit Page
    When User clicks the Save Button verify the red alert

