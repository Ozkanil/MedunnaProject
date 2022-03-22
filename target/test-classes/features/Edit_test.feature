Feature: Edit test results
@view_edit_appointments
Scenario: Edit test results

When User navigates to the home page
And user clicks sign in button at the home page and navigates to sign in page
Then user verifies that sign in page header is visible
And user enters username "<username>" and password "<password>"
And user clicks sign in button
Then user verifies that sign in is successful
When user clicks my pages
And user clicks search patient
When user provides a valid ssn number into search box
|ssn        |
|175-92-9123|
And user click show appointments button
Then user verifies appointments page header
And user clicks edit button under appointments
And user clicks show tests
And user click view results
And user clicks edit button on test page
And user sends value to result box
Then user clicks sava button and verifies update message