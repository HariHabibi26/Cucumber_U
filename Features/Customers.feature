Feature: Customers

  Background: Below are the common steps for each scenario
    Given User launch chrome Driver
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "admin@yourstore.com"  and Password is "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on Customers menu
    And click on Customers Menu Item

  Scenario: Add new Customer
    And click on Add new button
    Then USer can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully"
    And Close Browser

  Scenario: Search Customer by EMailID
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Searh table
    And Close Browser
