# is the focus of this training module. Cucumber gherkin has to focus on business acceptance criteria not get as technical as below
Feature: Demonstrate Waits

  Scenario: Pageload timeout
    When I open seleniumframework website
    And I set pageload timeout

  Scenario: Implicit Wait timeout
    When I open seleniumframework website
    And I set implicit timeout
    Then I print the text for target element

  Scenario: Script timeout
    When I open seleniumframework website
    And I set script timeout

  Scenario: Explicit Wait and Expected Conditions clickable
    When I open seleniumframework website
    Then I set explicit wait block on target element until it becomes clickable

  Scenario: Explicit Wait and Expected Conditions alert present
    When I open seleniumframework website
    Then I set explicit wait block on on alert present
    
   Scenario: Fluent Wait demonstration
    When I open seleniumframework website
    Then I wait until I find five periodicElements
