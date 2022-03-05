@setting_homepage
Feature:setting homepage feature

  Background:
    Given User navigates to "https://www.medunna.com/"
    When User clicks on SignIn button  on the right top
    Then User enters username "mclara"
    Then User enters password "123abc$"
    Then User clicks on sign in button
    Then  User clicks on newly signedIn User
    And User clicks on Setting option


  Scenario Outline: TC_001 user setting homepage  firstname editable
    Then User clears existing firstname
    And User sends a new firstname "<firstname>"
    Then User clears existing lastname
    And User sends a new lastname  "<lastname>"
    Then User clears existing email
    And User sends a new email "<email>"
    And User clicks on Save button
    Examples:

      | firstname | lastname | email        |
      | David     | Martin   | dm@gmail.com |
      | Kavin     | Maven    | km@gmail.com |

#Scenario: TC_002
#  Scenario: TC_001 user setting homepage  firstname editable
#    Then User clears existing firstname
#    And User sends a new firstname "Marry"
#    Then User clears existing lastname
#    Then User clears existing email
#    And User clicks on Save button