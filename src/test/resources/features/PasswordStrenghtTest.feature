@password_strength
Feature: Registration_page_should_restrict_password

  Background:
    Given User navigates to "https://www.medunna.com/"
    When User clicks on SignIn button  on the right top
    Then User clicks on Register in dropdown list


  Scenario Outline:TC_0001 User enters four charts passwords
    Then User enters four chars password "<password>"
    Then User verifies password chart color is "1"

    Examples:
      | password |
      | abcd     |
      | ABCD     |
      | 1234     |
      | @#€$     |
      | Ab1$     |

  Scenario Outline: TC_0002 User enters seven chars two combination
    Then User enters seven chars two combination "<password>"
    Then User verifies password  chart color is "2"
    Examples:test data
      | password |
      | abcABCD  |
      | 1234abc  |
      | 1234$@€  |
      | abcd123  |
      | ABCD$@%  |

  Scenario Outline: TC_0003 User enters seven chars password in three combinations
    Then User enters seven chars three combination "<password>"
    Then User verifies password  chart color is "3"
    Examples: test data
      | password |
      | ABcd123  |
      | %&123AB  |
      | 123ab&%  |

  Scenario Outline: TC_0004 User enters seven chars password in four combinations
    Then User enters seven chars four combination "<password>"
    Then User verifies password  chart color is "4"
    Examples: test data
      | password |
      | ABcd12$  |
      | *12acAB  |
      | 12ab*HL  |

  Scenario Outline: test password strength
    Then user provides the  password "<password>"
    Then user validates the password strength "<strength>"
    Examples: test data
      | password | strength |
      | abcd     | 1        |
      | abcdEFG  | 2        |
      | %&123AB  | 3        |
      | 12ab*HL  | 4        |



















