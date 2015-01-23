Feature: Demonstrate the json data formats
  Scenario: Serialization , convert object to json and print its string value
    When I create json string from object and write to file
    Then I print it as a string
  Scenario: Access a json string in a file
    When I read json string from a file
    Then I parse the string and print keys and values
    @web
  Scenario: Accessing a json data file and filling the web form
    When I open practiceselenium website
    And I read the json data file "practiceform.json"
    And I fill the form with data from json and submit