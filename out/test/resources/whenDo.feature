Feature: Tareas

  Scenario: como usuario
  quiero agregar nuevas tareas
  para organizarlas de mejor manera

    Given yo tengo abierto el WhenDo
    When yo realizo click en el boton Agregar
    And yo escribo en el campo tarea el valor de "Ir al mercado"
    And yo escribo en el campo Notas el valor de "Todos los dias a las 10am"
    And yo realizo click en el boton Guardar
    Then la tarea "Ir al mercado" deberia ser mostrada en la lista de tareas