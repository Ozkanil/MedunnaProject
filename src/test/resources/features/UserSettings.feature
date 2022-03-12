@setting_homepage
Feature: setting homepage feature

  Background:
    Given User navigates to "https://www.medunna.com/"
    When User clicks on SignIn button  on the right top
    Then User clicks on signIn in dropdown list
    Then User enters username "mclara"
    Then User enters password "123abc$"
    Then User clicks on sign in button
    Then  User clicks on newly signedIn User
    And User clicks on Setting option


  Scenario Outline: TC_001 user setting homepage  firstname editable
    Then User clears existing firstname
    And User sends a new firstname "<firstname>" and verifies isEnabled
    Then User clears existing lastname
    And User sends a new lastname  "<lastname>" and verifies isEnabled
    Then User clears existing email
    And User sends a new email "<email>" and verifies isEnabled
    And User clicks on Save button
    Examples:


      | firstname | lastname | email        |
      | David     | Martin   | dm@gmail.com |
      | Kavin     | Maven    | km@gmail.com |

