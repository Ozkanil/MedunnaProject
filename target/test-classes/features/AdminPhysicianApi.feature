Feature: admin create user to physician role by api

  @APIAdmCrtDr

  Scenario: Get physician data and validate
    When set the Base Url for physician
#    And user deserializes data to Java for physician
    And send the GET request and get the response for physician
    And set the expected data for physician
    Then do validation for pysician