#Autor: Jessid Cordoba
#language:en
@Regresion
Feature: Yo como usuario quiero probar el escenario de compra en el sitio Swag Labs

  @ComprarProducto
  Scenario Outline: Compra exitosa en el sitio
    Given el actor ingresa a saucedemo.com
      | url   |
      | <url> |
    When el actor se autentica con la siguiente informacion
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And agrega el producto al carrito y hace el checkout
      | nombreProducto   | nombre   | apellido   | zip   |
      | <nombreProducto> | <nombre> | <apellido> | <zip> |
    Then valida que el producto se compro de manera exitosa
      | mensajeExitoso   |
      | <mensajeExitoso> |
    Examples:
      | url                       | usuario       | contrasena   | nombreProducto      | mensajeExitoso            | nombre  | apellido | zip    |
      ##@externaldata@src/test/resources/datadriven/data.xlsx@usuarios
   |https://www.saucedemo.com   |standard_user   |secret_sauce   |Sauce Labs Backpack   |Thank you for your order!   |usuario   |choucair   |470003|

