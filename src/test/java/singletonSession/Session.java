package singletonSession;

import factoryDevices.FactoryDevices;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.eo.Se;

import java.net.MalformedURLException;

public class Session {

    private static Session session = null;
    private AppiumDriver driver;

    private Session() throws MalformedURLException {
        driver = FactoryDevices.make(FactoryDevices.ANDROID).create();
    }

    public static Session getInstance() throws MalformedURLException {

        if (session == null)
                session = new Session();

        return session;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void closeSession() {
        driver.quit();
        session =  null;
    }

}
