Feature: Browser profiles
  Scenario: Demonstrate how to create firefox profile
    Given I create a new firefox profile
    Then I pass that profile to create firefox browser

  Scenario: Demonstrate how to set browser preference to download a file automatically
    Given I create a new firefox profile to automatically download a file
    Then I use that profile to download
