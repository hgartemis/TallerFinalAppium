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

public class AppiumBasic {
    private AppiumDriver driver;
    @Before
    public void initializeAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","nubia Z17 lite");
        capabilities.setCapability("platformVersion","7.1.1");
        capabilities.setCapability("appPackage","cn.nubia.calculator2.preset");
        capabilities.setCapability("appActivity","cn.nubia.calculator2.Calculator");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void verifyAddition() throws InterruptedException {
        // click  button 7
        driver.findElement(By.id("cn.nubia.calculator2.preset:id/digit7")).click();
        // click button +
        driver.findElement(By.id("cn.nubia.calculator2.preset:id/plus")).click();
        // click button 1
        driver.findElement(By.id("cn.nubia.calculator2.preset:id/digit1")).click();
        // click button =
        driver.findElement(By.id("cn.nubia.calculator2.preset:id/equal")).click();
        // verificacion resultado
        String expectedResult="8";
        String actualResult=driver.findElement(By.id("cn.nubia.calculator2.preset:id/cal_txt2")).getText();
        Assert.assertEquals("ERROR! la suma es incorrecta",expectedResult,actualResult);

    }


    @After
    public void closeApp(){
        driver.quit();
    }


}
