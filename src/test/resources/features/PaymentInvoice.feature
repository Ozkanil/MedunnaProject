Feature:  Staff can process the Invoice Payment
  As a Staff , I am able to create payment invoice
  Scenario:  Invoice Payment
    Given User navigates to the home page
    When User clicks on SignIn button  on the right top
    Then User clicks on signIn in dropdown list
    And User enters username "hazel"
    And User enters password "13579"
    And User clicks on sign in button
    Then User clicks on Search Patient under MY PAGES
    And  User Search the patient by SSN "555-66-7777"
    And User clicks on Show Appointments Button
    And User verifies Status is "COMPLETED"
    Then User clicks on  Payment Invoice Process
    And User clicks on Show Invoice Button
    Then User verifies Invoice Details SSN "555-66-7777"  Name "Jack Lost" and Total Cost "650$"
    And User closes Browser