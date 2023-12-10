@smoke
  Feature: F07_followUs | users could open followUs links
    Scenario Outline:user can follow us on facebook
      Given the homepage
      When user click on facebook icon
      Then facebook page <link> will opened in new tab
      Examples:
      |link|
      | https://www.facebook.com/nopCommerce|
     ###########################Scenario2###################
    Scenario Outline:user can follow us on twitter
      Given valid homepage
      When user click on twitter icon
      Then twitter page <link> will opened in new tab
      Examples:
        |link|
        |https://twitter.com/nopCommerce|
##############################Scenario3#####################
    Scenario Outline:user can follow us on rss
      Given website homepage
      When user click on rss icon
      Then rss page <link> will opened in new tab
      Examples:
        |link|
        |https://demo.nopcommerce.com/new-online-store-is-open|
#############################Scenario4#########################
    Scenario Outline:user can follow us on youtube
      Given valid home link
      When user click on youtube icon
      Then youtube page <link> will opened in new tab
      Examples:
        |link|
        |https://www.youtube.com/user/nopCommerce|