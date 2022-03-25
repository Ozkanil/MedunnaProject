Feature: admin on physician page

  @AdDocPg
  Scenario Outline: admin create physician from admin page
    Given User navigates to the home page
    And user clicks sign in button at the home page and navigates to sign in page
    And user verifies that sign in page header is visible
    And user enters username "<username>" and password "<password>"
    And user clicks sign in button
    And user verifies that sign in is successful
    And user clicks items and titles dropdown
    And user clicks on physician button on dropdown
    And user verifies physician page is displayed
   # And user clicks go to last int page button on admin page
    And user clicks on create a new physician button




          Examples:Test data
        |username |password  |
        |olleydone|Cxz098!@# |