
Feature: Demonstrate database connection using activeJDBC
  @database
  Scenario: Connect to practiceselenium.sqlite3 file and print table values using sqllite jdbc sql
    When I connect to practiceselenium sqlite3 database
    Then I print the rows in products table using columns
  @database
  Scenario: find a row by finding through a column value (where clause) using sqlite
    When I connect to practiceselenium sqlite3 database
    Then I print the row that has id "1"
  @database
  Scenario: Update a row value using sqlite jdbc
    When I connect to practiceselenium sqlite3 database
    Then I update the row whose id is "1" and reset it back
  @database @web
  Scenario: Connect the dots on automation using web ui form and database using sqlite sql
    When I open practiceselenium website
    And I retrieve the tea names
    Then I compare the values with the values from database using sqlite sql