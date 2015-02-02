Feature: Fill a simple form with excel data
  Scenario: Data driven with excel
    When I open automationpractice website
    And click contact us
    Then I contact the customer service with excel row "1" dataset
  Scenario Outline: Data driven with excel and data sets
    When I open automationpractice website
    And click contact us
    Then I contact the customer service with excel row "<row_index>" dataset
  Examples:
    |row_index|
    |2|
    |3|