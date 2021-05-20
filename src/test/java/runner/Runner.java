package runner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import singletonSession.Session;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
public class Runner {
    // HOOKS
    public static  AppiumDriver driver;
    @Before
    public void beforeHookCucumber(){
        System.out.println("Hook Cucumber Before");
    }

    @After
    public void afterHookCucumber(Scenario scenario) throws MalformedURLException {

        if(scenario.isFailed()){
            byte[] screen= Session.getInstance().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screen,"image/png","Movile Failed Step");
        }

        Session.getInstance().closeSession();
    }
}