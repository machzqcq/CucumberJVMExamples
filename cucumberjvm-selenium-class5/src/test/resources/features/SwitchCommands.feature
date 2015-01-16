# is the focus of this training module. Cucumber gherkin has to focus on business acceptance criteria not get as technical as below
Feature: Switch commands in Selenium webdriver

  Scenario: Switch to new window
    When I open seleniumframework practiceform
    And I open a new window
    Then I switch to the new window

  Scenario: Switch to new tab
    When I open seleniumframework practiceform
    And I open a new tab
    Then I switch to the new tab

  Scenario: Switch to Javascript alert
    When I open seleniumframework practiceform
    And I click alert button
    Then I switch to alert and accept

  Scenario: Switch to frame
    When I open yourhtmlsource website
    And I switch to frame with name bomb
    Then I print the text and switch back to parent
