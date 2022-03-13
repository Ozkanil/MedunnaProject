@my_appointments_db_patient
  Feature: patient appointments db
Scenario Outline: patient should be able to see his/her appointment list in database
Given user connects to the Database
When user gets "id, start_date, end_date, status" from the "appointment" table for "patient_id = 10363"
And user verify that the data includes <id>, "<start_date>", "<end_date>" and "<status>"
Then user close the database connection
Examples:
|id   |start_date               |end_date                |status    |
|10416|2023-01-24 00:00:00.0|2023-01-24 01:00:00.0|UNAPPROVED|
|12461|2022-03-04 00:00:00.0|2022-03-04 01:00:00.0|UNAPPROVED |
|12462|2022-03-07 00:00:00.0|2022-03-07 01:00:00.0|UNAPPROVED |