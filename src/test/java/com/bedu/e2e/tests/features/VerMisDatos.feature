Feature: Ver mis datos de estudiante

  Scenario: Ver mis datos
    Given Ingreso con mi correo registrado "edgar122@correo.com"
    When hago click en el boton mis datos
    Then puedo ver mi email "edgar122@correo.com" y mi curp "BLAH212222"