@smoke
  Feature: F06_homeSliders | two clickable sliders on homepage
    Scenario: users could click on slider of Nokia Lumia 1020
      Given navigate to homepage
      When users click on nokia lumia 1020 slider
      Then redirected to url contains nokia-lumia

#######################Secnario2#################################
  Scenario: users could click pn slider of iphone
    Given navigate to homepage link
    When users click on iphone slider
    Then directed to url contains iphone