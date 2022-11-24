Feature: testing login on the serenity demo page

  @CrearUsuarioExcel
  Scenario Outline:

    Given asd

    When asd

      | <user> | <password> |

    Then asd

    Examples:
      | user   | password | text      |
      ##@externaldata@./src/test/resources/Datadriven/dtDatos.xlsx@Datos@1
      | admin  | serenity | Dashboard |

