Feature: Demonstrate database connection using activeJDBC

  Scenario: Connect to practiceselenium.sqlite3 file and print table values using activerecord sql
    When I connect to practiceselenium sqlite3 database
    Then I print the rows in products table

  Scenario: Connect to practiceselenium.sqlite3 file and print table values using activerecord sql
    When I connect to practiceselenium sqlite3 database
    Then I print the rows in products table using columns

  Scenario: find a row by finding through a column value (where clause) using ActiveRecordBase inherited class
    When I connect to practiceselenium sqlite3 database
    Then I print the row that has id "1"

  Scenario: Update a row value using ActiveRecord Base inherited class
    When I connect to practiceselenium sqlite3 database
    Then I update the row whose id is "1" and reset it back

  Scenario: Connect the dots on automation using web ui form and database using activerecord class
    When I open practiceselenium website
    And I retrieve the tea names
    And I connect to practiceselenium sqlite3 database
    Then I compare the values with the values from database using activerecord class

  Scenario: Connect the dots on automation using web ui form and database using traditional sql
    When I open practiceselenium website
    And I retrieve the tea names
    And I connect to practiceselenium sqlite3 database
    Then I compare the values with the values from database using traditional sql