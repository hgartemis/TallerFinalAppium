package runner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Runner {
    // HOOKS
    public static  AppiumDriver driver;
    @Before
    public void beforeHookCucumber(){
        System.out.println("Hook Cucumber Before");
    }

    @After
    public void afterHookCucumber(){
        driver.quit();
    }
}