Feature: Order Summary
  Scenario: Verify order Summary page and proceed
    When I open automationpractice website
    And I sign in
    And I select a dress and proceed to checkout
    And I verify details on shoppingCart summary page
    And I verify address and proceed
    And I verify shipping details and proceed
    And I verify payment details page and proceed
    Then I verify order summary page and proceed
