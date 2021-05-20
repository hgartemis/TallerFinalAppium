package runner;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyStepWhenDo {

    @Given("yo tengo abierto el WhenDo")
    public void yoTengoAbiertoElWhenDo() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","nubia Z17 lite");
        //capabilities.setCapability("platformVersion","7.1.1");
        capabilities.setCapability("deviceName","IA Emulador");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        Runner.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        Runner.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("yo realizo click en el boton Agregar")
    public void yoRealizoClickEnElBotonAgregar() {
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }

    @And("yo escribo en el campo tarea el valor de {string}")
    public void yoEscriboEnElCampoTareaElValorDe(String titulo) {
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
    }

    @And("yo escribo en el campo Notas el valor de {string}")
    public void yoEscriboEnElCampoNotasElValorDe(String notas) {
        Runner.driver.findElement(By.xpath("//android.widget.EditText[@text='Notes']")).sendKeys(notas);
    }

    @And("yo realizo click en el boton Guardar")
    public void yoRealizoClickEnElBotonGuardar() {
        Runner.driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
    }

    @Then("la tarea {string} deberia ser mostrada en la lista de tareas")
    public void laTareaDeberiaSerMostradaEnLaListaDeTareas(String titulo) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("ERROR! tarea no creada",Runner.driver.findElement(By.xpath("//android.widget.TextView[@text='"+titulo+"']")).isDisplayed());
    }


}
