Feature: Tareas

  Scenario Outline: como usuario quiero agregar tareas
  para organizarlas de mejor manera

    Given Ingreso al WhenDo
    When doy click en el boton Agregar
    And escribo una <tarea> en el textbox tarea
    And escribo una <nota> en el textbox notas
    And doy click en el boton Guardar
    Then valido que la <tarea> deberia ser mostrada en la lista
    Examples:
      | tarea           | nota                      |
      | Ir al mercado   | Todos los dias a las 10am |
      | Jugar al futbol | Todos viernes a las 8pm   |