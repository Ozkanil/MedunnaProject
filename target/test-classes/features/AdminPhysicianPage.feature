Feature: admin on physician page

  @AdmDocPg
  Scenario Outline: admin create physician from admin page
    Given User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user verifies that sign in is successful
#    And  user provides physician firstname and lastname "<firstName>" and "<lastName>"
#    And user provides physician email "<email>"
#    And user login physician username "<user>"
#    And user provides physician ssn id "<ssn>"
#    And user send the physician ssn "<getssn>" to ssnbox
#    And user clicks search user patient ssn button

    And user clicks items and titles dropdown
    And user clicks on physician button on dropdown
    And user clicks on create a new physician button
#    And user verifies create or edit a physician is displayed
    And user clicks on use search checkbox button
    And user send the physician ssn "<ssn>" to ssnbox
    And user clicks search user patient ssn button
    And user provides the birthDate "<birthDate>"
    And user provides the physician phone number "<phone>"
    And user provides the physician address "<address>"
    And user click to specialities and choose family medicine "<speciality>"
    And user provides the exam fee "<examFee>"
    And user creates the records to a physician file
    Then user clicks to save physician button



    Examples:Test data
      |username |password  |user            |firstName | lastName |email                 |   ssn     |birthDate |phone       |speciality      |examFee|
      |olleydone|Cxz098!@# | alpiniasanlion |Alpinio   |Aslanlion | alpiniasanlion@aa.com|384-37-3727|03/18/1987|214-578-3247| Family_medicine|540    |





#    Examples:Test data
#      |username |password  |user           |firstName  | lastName |email                |   ssn     |
#      |olleydone|Cxz098!@# | aalpiniasanlion |Aalpinio     |Aaslanlion  | aalpiniasanlion@aa.com|384-37-1827|