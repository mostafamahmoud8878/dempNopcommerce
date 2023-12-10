@smoke
  Feature: F03_Currencies| users could apply selected Currency to products from a DDl at homepage
    Scenario: users could choose euro currency from DDl
      Given valid homepage link
      When users selected euro currency from DDl
      Then euro symbol is shown on 4 products displayed on homepage
