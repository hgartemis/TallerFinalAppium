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

    @After
    public void closeApp(){
        driver.quit();
    }
}
