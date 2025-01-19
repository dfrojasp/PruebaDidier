Feature: Pruebas Usuarios

  @CPL001
  Scenario Outline: CP001 Transferencia Exitosa
    Given yo como usuario ingreso al portal <usuario> <contrasena>
    When Ingreso al modulo de compras <lastName> <firstName> <postalCode>
    Then Valido la transaccion exitosa de los articulos seleccionados
    Examples:
      ##@externaldata@./src/test/resources/Data/Data.xlsx@CP001
      | usuario         | contrasena     | lastName | firstName | postalCode |
      | "standard_user" | "secret_sauce" | "Didier" | "Rojas"   | "121212"   |