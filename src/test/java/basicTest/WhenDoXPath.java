package basicTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WhenDoXPath {
    private AppiumDriver driver;
    @Before
    public void initializeAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","nubia Z17 lite");
        capabilities.setCapability("platformVersion","7.1.1");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void verifyAddition() throws InterruptedException {

        String titulo="Taller2Xpath";

        //click Agregar
        driver.findElement(By.xpath("//android.widget.ImageButton[@index='2']")).click();
        //Ingresar tarea
        driver.findElement(By.xpath("//android.widget.EditText[@text='Título']")).sendKeys(titulo);
        //Guardar
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Guardar\"]")).click();

        // verificacion resultado
        //String expectedResult="Taller2";
        //falta definir el XPATH
        //String actualResult=driver.findElement(By.xpath("//android.widget.TextView[@text=''")).getText();
        //Assert.assertEquals("ERROR! la suma es incorrecta",expectedResult,actualResult);

    }

    @After
    public void closeApp(){
        driver.quit();
    }


}

