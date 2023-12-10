@smoke
  Feature: F05_hoverCategories | users could hovering on main category and select from it's subs
    Scenario Outline: users select sub category from main category
      Given link of homepage
      When user hover on main <category> and select from it's sub categories
      Then redirected to Selected category page
      Examples:
        |category|
        |Computers        |
        |Electronics      |
        |Digital downloads|
        |Jewelry          |
        |Apparel          |
        |Books            |
        |Gift Cards       |


