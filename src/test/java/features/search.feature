Feature: Search products

  Background:
    Given I am in Home page
    And I close pop-up ads

  Scenario: [Primary] Verify UI search bar
    When search bar is displayed on the top of Home page
    Then I see search icon at the left side of search bar
    And I see text "Search for products and brands" as placeholder

  Scenario: [Primary] Verify url after clicking search bar
    When I click search bar
    Then I should navigate to search url

  Scenario: [Primary] Verify search function by entering full text
    When I click search bar
    And I enter full product name
    Then I should see that product in result page
    When I click that product
    Then I see product's name same as my text entered

  Scenario: [Primary] Verify search function by entering partial text
    When I click search bar
    And I enter partial product name
    Then I should see those products in result page

  Scenario: [Primary] Verify search function by selecting suggestion
    When I click search bar
    And I click dyson in suggestion
    Then I see products in Dyson category

  Scenario: [Primary] Verify remove icon on search bar
    When I click search bar
    And I enter some texts
    And I click remove icon
    Then I don't see text I have entered
    And I see text "Search for products and brands" as placeholder
    And I don't see any products in result page

  Scenario Outline: [Exception] Verify search function by entering special characters
    When I click search bar
    And I enter <characterType>
    Then I don't see any products in result page
    Examples:
      | characterType |
      | html          |
      | css           |
      | JS            |


