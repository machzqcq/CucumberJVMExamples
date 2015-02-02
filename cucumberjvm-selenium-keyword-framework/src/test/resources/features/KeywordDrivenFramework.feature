Feature: Sign in and contact us
  Scenario: Successful login
    When I open "http://automationpractice.com" website
    Then I login using credentials "abc@xyz.com" and "Test@123"
  Scenario: unsuccessful login
    When I open "http://automationpractice.com" website
    Then I login using credentials "abc@xyz1.com" and "Test@123"
  Scenario: Contact us
    When I open "http://automationpractice.com" website
    Then I contact customer service with order reference "abc123" and message "hello there"