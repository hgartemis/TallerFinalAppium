package runner;

import WhenDoManagerClean.WhenDoMainScreen;
import WhenDoManagerClean.WhenDoScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;

public class MyStepWhenDoClean {

    WhenDoMainScreen main = new WhenDoMainScreen();
    WhenDoScreen screen = new WhenDoScreen();

    @Given("Ingreso al WhenDo")
    public void ingresoAlWhenDo() {
    }

    @When("doy click en el boton Agregar")
    public void doyClickEnElBotonAgregar() throws MalformedURLException {
        main.addAgregar.click();
    }

    @And("escribo una {} en el textbox {}")
    public void escriboUnaTareaEnElTextboxTarea(String valor, String control) throws MalformedURLException {
        screen.textboxMap.get(control).type(valor);
    }

    @And("doy click en el boton {}")
    public void doyClickEnElBotonGuardar(String boton) throws MalformedURLException {
        screen.buttonMap.get(boton).click();
    }

    @Then("valido que la {} deberia ser mostrada en la lista")
    public void validoQueLaTareaDeberiaSerMostradaEnLaLista(String tarea) {

        Assert.assertTrue("ERROR! tarea no creada", main.tareaIsDisplayed(tarea));

    }
}
