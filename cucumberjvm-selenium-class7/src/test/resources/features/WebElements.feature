@slow
Feature: Demonstrating the usage of web elements
  Scenario: Identify text field and print its html
    When I open practiceselenium.com website
    Then I find first and last name and print the html
    @sanity @beta3
  Scenario: Identify link field and print its html
    When I open practiceselenium.com website
    Then I find menu and print the html
  @not_ready @parallel
  Scenario: Identify button field and print its html
    When I open practiceselenium.com website
    Then I find button and print the html
  Scenario: Identify radio button and print its html
    When I open practiceselenium.com website
    Then I find radio button male and print the html
    @parallel
  Scenario: Identify checkbox and print html
    When I open practiceselenium.com website
    Then I find check box and print the html
  Scenario: Identify select list and print html
    When I open practiceselenium.com website
    Then I find select list and print html
    @wip
  Scenario: Identify another select list and print html
    When I open practiceselenium.com website
    Then I find another select list and print html
  Scenario: Identify a div and print html
    When I open practiceselenium.com website
    Then I find div and print html
