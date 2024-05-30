Feature: Data Related

  Scenario: Michael orders many things
    Given Michael is a Morning Freshness member
    When he orders an "Apple and Mango Smoothie" and a cappuccino and 2 croissants
    Then his order should go to the preparation queue

  Scenario: Michael orders many things with Data
    Given Michael is a Morning Freshness member
    When he places the following order:
      | Product                  | Quantity |
      | Apple and Mango Smoothie |        1 |
      | Cappuccino               |        1 |
      | Croissants               |        2 |
    Then his order should go to the preparation queue
