@smoke
Feature: F04_Search | users can use search box for searching for relevant results
  Scenario Outline: users could search using product name
    Given  homepage link
    When users enter search keyword as <productName>
    And users press on search button
    Then directed to url contains search?q=
   And displayed relevant results to the <productName>
    Examples:
    |productName|
    |book       |
    |laptop     |
    |nike       |

    ###################SecnarioOutline2########################
 Scenario Outline: user could search for product using sku
    Given homepage
    When users enter search query as <sku>
    And users clicked search button
    Then directed to url which contains search?q=
    And relevant <sku> result displayed
    Examples:
    |sku|
    |SCI_FAITH|
    |APPLE_CAM|
    |SF_PRO_11|