Feature: Refinement
  As a user
  I want to be able to refine products
  So that I can optimise my listings to channels

  Rules:
  *

  Glossary:
  * Refinement: Providing additional information in order to improve the quality of the channel listing

  @component
  Scenario: New product is imported to the Volo platform and is ready for refinement
    Given I am on the dashboard page
    When the product is imported into the Volo platform
    Then the refinement count should increment

  @e2e
  @integration
  @component
  Scenario: Upon clicking the refine button it should be possible to find the first product to be refined
    Given I am on the dashboard page
    When I click the refine button
    Then I should be taken to the inventory refinement page
    And I should be able to locate my first product to refine

  @component
  Scenario: Upon locating the first product from the import file the product attribute fields should be populated with the values from the JSON file
    Given I have located the first product from the JSON file
    When I check the field values
    Then they should match the values from the JSON file

  @e2e
  @integration
  @component
  Scenario: Upon refining my product data in the UI I should be able to save the changes that I have made
    Given: I am on the product refinement screen
    When: I click the Save button
    Then: I should be taken to the home page
    And: The refinement count should decrease by one