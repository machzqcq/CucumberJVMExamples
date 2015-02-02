Feature: Shipping and proceed
  Scenario: Verify shipping and proceed
    When I open automationpractice website
    And I sign in
    And I select a dress and proceed to checkout
    And I verify details on shoppingCart summary page
    And I verify address and proceed
    Then I verify shipping details and proceed
