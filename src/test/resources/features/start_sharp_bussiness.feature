Feature: testing the serenity demo page

  Background:

    Given That Mike opens the url to see the login page

    When Mike types the following data
      | user  | password |
      | admin | serenity |

  Scenario: Mike wants to create an unit business

    When Mike creates a new unit business and setups a meeting

    Then Mike will be able see the meeting was successfully scheduled

