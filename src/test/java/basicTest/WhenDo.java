package basicTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WhenDo {
    private AppiumDriver driver;
    @Before
    public void initializeAppium() throws MalformedURLException {

        // Juan de Dios

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","nubia Z17 lite");
        capabilities.setCapability("platformVersion","7.1.1");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

       // Humberto Guadalupe
        /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android SDK built for x86");
        capabilities.setCapability("platformVersion","8.1.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");*/

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void verifyAdditionId() throws InterruptedException {

        String titulo="Taller2";

        // click Agregar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        //Ingresar Tarea
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
        // click Guardar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        // verificacion, verificar que la tarea este creada
        Thread.sleep(2000);
        Assert.assertTrue("ERROR! tarea no creada",driver.findElement(By.xpath("//android.widget.TextView[@text='"+titulo+"']")).isDisplayed());

    }

    @Test
    public void verifyAdditionXpath() throws InterruptedException {

        String titulo="TallerXPath";
        String notes="Forma de registrar notes en la tareas";

        // click Agregar
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='2']")).click();

        //Ingresar Tarea
        driver.findElement(By.xpath("//android.widget.EditText[@text='Title']")).sendKeys(titulo);

        //Ingresar Notes
        driver.findElement(By.xpath("//android.widget.EditText[@text='Notas']")).sendKeys(notes);

        // click Guardar
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Guardar\"]")).click();

        // verificacion, verificar que la tarea este creada
        Thread.sleep(2000);
        Assert.assertTrue("ERROR! tarea no creada",driver.findElement(By.xpath("//android.widget.TextView[@text='"+titulo+"']")).isDisplayed());

    }

    @Test
    public void verifyOrderBy() throws InterruptedException {


        String tarea0 = "Ir al mercado";
        String tarea1 = "Salir a jugar futbol";
        String tarea2 = "Dormir";
        String tarea3 = "Cocinar";
        String tarea4 = "Hacer la tarea de Appium";
        String note0 = "Todos los dias a las 10am";
        String note1 = "Sabados de 5 a 8 pm";
        String note2 = "desde las 10pm a las 7am";
        String note3 = "Desde las 11am a las 2pm";
        String note4 = "De lunes a viernes";

        for(int i=0; i<5; i++) {

            String t = ""; String n = "";
            switch (i) {
                case 0:t = tarea0; n = note0;break;
                case 1:t = tarea1; n = note1;break;
                case 2:t = tarea2; n = note2;break;
                case 3:t = tarea3; n = note3;break;
                case 4:t = tarea4; n = note4;break;
            }

            // Agregando Tareas
            AgregarItem(t , n);
            Thread.sleep(1000);

        }

        // verificacion, verificar que la tarea este creada
        Thread.sleep(2000);
        //Assert.assertTrue("ERROR! tarea no creada",driver.findElement(By.xpath("//android.widget.TextView[@text='"+titulo+"']")).isDisplayed());

        // click en SortBy
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_header_icon")).click();

        // click en Orden Alfabetico
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Alfabéticamente']")).click();

        // Esperando a se vizualiza
        Thread.sleep(3000);

    }

    public void AgregarItem(String tarea, String notes) throws InterruptedException {

        // click Agregar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        //Ingresar Tarea
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(tarea);

        // click Guardar
       // driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Save']")).click();

        //Ingresar Notes
        driver.findElement(By.xpath("//android.widget.EditText[@text='Notas']")).sendKeys(notes);

        // click Guardar
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

    }



    @After
    public void closeApp(){
        driver.quit();
    }
}
