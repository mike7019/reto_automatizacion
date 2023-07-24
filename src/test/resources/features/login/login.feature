Feature: hacer login en el sitio web

  Scenario Outline: Andrea inicia sesion en el sitio web exitosamente

    Given Andrea esta en el sitio web
    When Andrea digita los siguientes datos
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Andrea podrá ver la palabra <texto> en pantalla
    Examples:
      | usuario | clave    | texto     |
      | admin   | serenity | Dashboard |