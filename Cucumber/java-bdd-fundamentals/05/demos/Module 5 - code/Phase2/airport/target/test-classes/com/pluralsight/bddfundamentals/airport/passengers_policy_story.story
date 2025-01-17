Meta: Passengers Policy
      The company follows a policy of adding and removing passengers, depending on the passenger type
      and on the flight type

Narrative:
As a company
I want to be able to manage passengers and flights
So that the policies of the company are followed

Scenario: Economy flight, usual passenger
Given there is an economy flight
When we have a usual passenger
Then you can add and remove him from an economy flight

Scenario: Economy flight, VIP passenger
Given there is an economy flight
When we have a VIP passenger
Then you can add him but cannot remove him from an economy flight

Scenario: Business flight, usual passenger
Given there is an business flight
When we have a usual passenger
Then you cannot add or remove him from a business flight

Scenario: Business flight, VIP passenger
Given there is an business flight
When we have a VIP passenger
Then you can add him but cannot remove him from a business flight

Scenario: Premium flight, usual passenger
Given there is an premium flight
When we have a usual passenger
Then you cannot add or remove him from a premium flight

Scenario: Premium flight, VIP passenger
Given there is an premium flight
When we have a VIP passenger
Then you can add and remove him from a premium flight