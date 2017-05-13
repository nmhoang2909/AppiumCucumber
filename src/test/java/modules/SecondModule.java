package modules;

import io.appium.java_client.AppiumDriver;
import objects.SecondPage;

/**
 * Created by Hoang on 5/13/17.
 */
public class SecondModule extends SecondPage {

    public SecondModule(AppiumDriver driver) {
        super(driver);
    }

    public void updateNameItem(String value) {
        txtFirstItem.clear();
        txtFirstItem.setValue(value);
    }

    public void changeFirstStart() {
        firstStart.click();
    }

    public void save() {
        btnSave.click();
    }
}
