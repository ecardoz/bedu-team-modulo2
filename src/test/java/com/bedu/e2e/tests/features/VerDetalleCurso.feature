Feature: Ver detalle de mi curso

  Scenario: Ver detalle de mi curso
    Given Ingreso con mi correo registrado "edgar122@correo.com"
    When hago click en el boton detalle del primer curso listado
    Then puedo ver la materia "Programacion con POO" y mi calificacion "10"