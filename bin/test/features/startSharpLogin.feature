Feature: testing login on the serenity demo page

  Scenario Outline: Mike wants to login on the website

    Given That Mike opens the url to see the login page

    When Mike types the following data
      | user   | password   |
      | <user> | <password> |

    Then Mike will be able to see the <text>

    Examples:
      | user  | password |  text      |
      | admin | serenity |  Dashboard |