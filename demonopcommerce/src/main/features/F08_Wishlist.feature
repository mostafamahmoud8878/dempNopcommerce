@smoke
  Feature: user can adda product to wishlist
    Scenario: user add HTC One M8 Android L 5.0 Lollipop product to wishlist
      Given valid link of homepage
      When user clicked on heart icon
      Then success message "The product has been added to your wishlist" with green background color appeared
      ##########Scenario2##################################
  Scenario:  user add HTC One M8 Android L 5.0 Lollipop product to wishlist page
    Given valid home
    When user click on heart icon of the HTC One M8 Android L 5.0 Lollipop product
    And go to wishlist page
    Then product added to wishlist successfully