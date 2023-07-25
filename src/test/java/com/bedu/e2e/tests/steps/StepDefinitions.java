package com.bedu.e2e.tests.steps;

import com.bedu.e2e.pom.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitions extends Test {

    @Given("Ingreso con mi correo registrado {string}")
    public void ingresoConMiCorreoRegistrado(String email){
        indexPage.visit("localhost:8080");
        indexPage.typeEmail(email);
        indexPage.clickIniciarSesion();
    }

    @When("hago click en el boton mis datos")
    public void hagoClickEnElBotonMisDatos() {
        sesionEstudiantePage.clickMisDatonButton();
    }

    @Then("puedo ver mi email {string} y mi curp {string}")
    public void puedoVerMiEmailYMiCurp(String email, String curp) {
        assertThat(misDatosPage.getEmail()).containsSequence(email);
        assertThat(misDatosPage.getCurp()).contains(curp);
    }

    @When("hago click en el boton detalle del primer curso listado")
    public void hagoClickEnElBotonDetalleDelPrimerCursoListado() {
        sesionEstudiantePage.clickDetalleButton();
    }

    @Then("puedo ver la materia {string} y mi calificacion {string}")
    public void puedoVerLaMateriaYMiCalificacion(String materia, String calificacion) {
        assertThat(detalleCursoPage.getNombreMateria()).contains(materia);
        assertThat(detalleCursoPage.getCalificacion()).contains(calificacion);
    }
}
