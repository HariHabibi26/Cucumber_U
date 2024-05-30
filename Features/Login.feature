Feature: Login

  Scenario: Successful Login with valid credentials
    Given User launch chrome Driver
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "admin@yourstore.com"  and Password is "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User Click on Log out Link
    Then Page title should be "Your store. Login"
    And Close Browser

  Scenario Outline: Login Data Driven
    Given User launch chrome Driver
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "<email>"  and Password is "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User Click on Log out Link
    Then Page title should be "Your store. Login"
    And Close Browser

    Examples: 
      | email                | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |
