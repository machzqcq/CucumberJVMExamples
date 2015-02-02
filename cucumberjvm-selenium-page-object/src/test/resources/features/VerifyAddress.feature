Feature: Verify Address
  Scenario: Verify address in the workflow and proceed
    When I open automationpractice website
    And I sign in
    And I select a dress and proceed to checkout
    And I verify details on shoppingCart summary page
    Then I verify address and proceed