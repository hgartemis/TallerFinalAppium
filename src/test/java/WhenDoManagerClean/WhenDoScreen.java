package WhenDoManagerClean;

import controlAppium.Button;
import controlAppium.TextBox;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class WhenDoScreen {

    public Map<String, TextBox> textboxMap= new HashMap<>();
    public Map<String, Button> buttonMap= new HashMap<>();

    public WhenDoScreen() {

        textboxMap.put("tarea",new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")));
        textboxMap.put("notas",new TextBox(By.xpath("//android.widget.EditText[@text='Notes']")));
        buttonMap.put("Guardar",new Button(By.id("com.vrproductiveapps.whendo:id/saveItem")));

    }

}
