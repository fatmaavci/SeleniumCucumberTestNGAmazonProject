@Test1
Feature: Create an Amazon account

  Scenario: Select "Create Your Amazon Account" if user do not have an account and verify all fields available on "Create Your Amazon Account" page.
    Given navigate to buy a book page
    And click create your amazon account button
    When type name "Fatma AVCI"
    And type email "famaaavci@gmail.com"
    And type password"psswd123"
    And type repassword"psswd123"
    And click Amazon Account button
