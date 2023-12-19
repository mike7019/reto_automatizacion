Feature: testing the serenity demo page

  Background:

    Given That Mike opens the url to see the login page

    When Mike types the following data
      | user  | pass     |
      | admin | serenity |

  Scenario Outline: Mike wants to create an unit bussiness

    When Mike creates a new unit <bussiness> and setups a meeting

    Then Mike will be able see the meeting was succesfully scheduled
    Examples:
      | bussiness      |
      | Administration |

