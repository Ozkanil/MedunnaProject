@US_001
Feature: User_Story_001_Test

  @US_001_TC_0001
  Scenario Outline: TC_0001_positive_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the valid "<SSN>" of the applicant
    Then should not get any error

    Examples: TC_0001_positive_Scenario_Data
      |SSN        |
      |412-51-7857|

  @US_001_TC_0002
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the invalid "<SSN>" of the applicant
    Then there should be displayed Your SSN is invalid message

    Examples: TC_0001_negative_Scenario_Data
      |SSN        |
      |412-51-785|

  @US_001_TC_0003
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the invalid "<SSN>" of the applicant
    Then there should be displayed Your SSN is invalid message

    Examples: TC_0001_negative_Scenario_Data
      |SSN        |
      |412-517857|


  @US_001_TC_0004
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the invalid "<SSN>" of the applicant
    Then there should be displayed Your SSN is invalid message

    Examples: TC_0001_negative_Scenario_Data
      |SSN        |
      |412-51-78579|


  @US_001_TC_0005
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the invalid "<SSN>" of the applicant
    Then there should be displayed Your SSN is invalid message

    Examples: TC_0001_negative_Scenario_Data
      |SSN        |
      |41251-7857|


  @US_001_TC_0006
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the invalid "<SSN>" of the applicant
    Then there should be displayed Your SSN is invalid message

    Examples: TC_0001_negative_Scenario_Data
      |SSN        |
      |000-51-7857|


  @US_001_TC_0007
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the invalid "<SSN>" of the applicant
    Then there should be displayed Your SSN is invalid message

    Examples: TC_0001_negative_Scenario_Data
      |SSN        |
      |412-b1-7857|

  @US_001_TC_0009
  Scenario: TC_0001_positive_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user lefts "<SSN>" textbox blank
    Then there should be displayed Your SSN is invalid message


  @US_001_TC_0010
  Scenario Outline: TC_0001_positive_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the valid first name "<firstName>" of the applicant
    Then should not get any error

    Examples: TC_0001_positive_Scenario_Data
      |firstName        |
      |Khalil           |


  @US_001_TC_0011
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user lefts first name "<firstName>" textbox blank
    Then verify Your FirstName is required. message

    Examples: TC_0001_negative_Scenario_Data
      |firstName        |
      ||


  @US_001_TC_0012
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user types some spaces on first name "<firstName>" textbox
    Then verify Your FirstName is required. message

    Examples: TC_0001_negative_Scenario_Data
      |firstName        |
      |  |


  @US_001_TC_0013
  Scenario Outline: TC_0001_positive_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user provides the valid last Name "<lastName>" of the applicant
    Then should not get any error

    Examples: TC_0001_positive_Scenario_Data
      |lastName        |
      |Riza           |


  @US_001_TC_0014
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user lefts last Name "<lastName>" textbox blank
    Then verify Your LastName is required. message

    Examples: TC_0001_negative_Scenario_Data
      |lastName        |
      ||


  @US_001_TC_0015
  Scenario Outline: TC_0001_negative_Scenario
    Given user is on the common page
    And user navigates to registration page
    And user types some spaces on last Name "<lastName>" textbox
    Then verify Your LastName is required. message

    Examples: TC_0001_negative_Scenario_Data
      |lastName        |
      |  |
  @UIRegistrationTest
    @user_register
  Scenario Outline: test username textbox
    Given user provides invalid username "<username>"
    Then  user validates Your username is required. message
    Examples: test data
      |username|
      ||
      |  |

  @UIRegistrationTest
    @user_register
  Scenario Outline: test username textbox
    Given user provides invalid username "<username>"
    Then  user validates Your username is invalid. message
    Examples: test data
      |username|
      | userOn|
      |userOn)(!|

  @UIRegistrationTest
    @user_register
  Scenario Outline: test email textbox
    Given user provides the invalid email "<email>"
    Then user validates This field is invalid
    Examples: test data
      |email        |
      |linagmail.com|
      |lina@.com    |
      |lina@gmailcom|
      |lina@gmail.  |
      |@gmail.com   |

  @UIRegistrationTest
    @user_register
  Scenario Outline: test email textbox
    Given user provides the invalid email "<email>"
    Then user validates Your email is required.
    Examples: test data
      |email        |
      ||
      |  |


  @UIRegistrationTest
    @user_register
  Scenario Outline: test password strength
    Given user provides the password "<password>"
    Then user validates the password strength "<strength>"
    Examples: test data
      |password|strength|
      |asdfgkdjs|1      |
      |asdfgkdjs?|2    |
      |asdhgsag?1|3    |
      |asdhgsag?1A|4   |
      |s$A2sf     |1   |


  @smoke
    @user_register
    @UIRegistration
  Scenario Outline: test registration
    Given user provides ssn id "<SSN>"
    And  user provides firstname and lastname "<firstname>" and "<lastname>"
    Then user creates username "<username>"
    And user provides also email "<email>"
    And user generates the password "<password>"
    And user registers and validates
    Then user creates the records to a correspondent file
    Examples: test data
      |SSN|firstname|lastname|username|email|password|
      |384-37-3827|Irfan|Pishkin|irfanpish|irfan@gmail.com|asdfA123.|