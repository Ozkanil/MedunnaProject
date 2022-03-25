@User_Management_UI
Feature: user management
  @user_login_post
  Scenario Outline:

    Given user in on the medunna home page
    And user clicks on login dropdown
    And user signs in as admin user name "<username>" and password as "<password>"
    And navigates and clicks administration dropdown
    And clicks user management
    And navigates and clicks the view button of the first user
    And verifies that the registered user info is visible
    Then user signs out

    Examples: test data

      |username|password|
      |admin79  |admin  |

  @Admin_edits_deletes_The_User
  Scenario Outline:

    Given user in on the medunna home page
    And user clicks on login dropdown
    And user signs in as admin user name "<username>" and password as "<password>"
    And navigates and clicks administration dropdown
    And clicks user management
    And navigates and clicks on the create a new user button
    And clicks login box and provides a login
    And clicks the first name box and provides the first name
    And clicks the last name box and provides the last name
    And clicks the email box and provides the email
    And clicks on the SSN box and provides a valid SSN
    And clicks on the language dropdown and selects english
    And selects Role_Staff in profiles
    And clicks save button then click last page button
    And on the last page edits the last user as a patient role and saves
    And deletes the patient that has just been edited
    Then user signs out

    Examples: test data

      |username|password|
      |admin79  |admin  |