Feature: OrangeHRM login

  Scenario: logo presence on OrangeHRm Home page
    Given I launch chrome browser
    When I opened OrangeHRM Homepage
    Then I verify logo present on Home Page
    And close  browser
