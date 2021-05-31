@Test
Feature: Search a Book

  Scenario: selecting "Books" options from drop down menu and searching “Harry Potter and the Philosopher Stone" and verify some info
    Given navigate to Amazon home page
    And select "Books" option from dropdown
    And enter the "Harry Potter and the Philosopher's Stone" in the textbox
    When click the search button
    Then check if the book is a "Best Seller"
    And verify author "J.K. Rowling"
    And verify the book name
    And check the book has "Kindle Edition"
