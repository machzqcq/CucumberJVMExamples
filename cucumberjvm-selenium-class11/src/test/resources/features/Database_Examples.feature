Feature: Demonstrate database connection using activeJDBC

  Scenario: Connect to practiceselenium.sqlite3 file and print table values using activerecord sql
    When I connect to practiceselenium sqlite3 database
    Then I print the rows in products table