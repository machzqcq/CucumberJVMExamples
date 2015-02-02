Feature: Shopping Cart summary page verification
  Scenario: Verify values on shopping cart summary page
    When I open automationpractice website
    And I sign in
    And I select a dress and proceed to checkout
    Then I verify details on shoppingCart summary page