Feature: Appointment DB test
Scenario Outline: Data Base appointment validation  with id
Given user connects to the physician database
And user selects all "id" column data from physician
And user verify "<id>" with the physician database
Then close the physician database connection

Examples:
|id|
|37428|
