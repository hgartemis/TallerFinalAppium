package WhenDoManagerClean;

import controlAppium.Button;
import controlAppium.Label;
import org.openqa.selenium.By;

public class WhenDoMainScreen {

    public Button addAgregar = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public WhenDoMainScreen () {}

    public boolean tareaIsDisplayed(String tarea) {

        Label resul = new Label(By.id("//android.widget.TextView[@text='" + tarea + "']"));
        return resul.isControlDisplayed();

    }

}
