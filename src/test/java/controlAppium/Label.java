package controlAppium;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Label extends Control {
    public Label(By locator) {
        super(locator);
    }

    public void type(String value) throws MalformedURLException {
        this.findControl();
        this.control.sendKeys(value);
    }
}
