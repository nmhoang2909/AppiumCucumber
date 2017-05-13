package modules;

import helper.CommonFunctions;
import io.appium.java_client.AppiumDriver;
import objects.SimplePage;
import org.junit.Assert;

/**
 * Created by Hoang on 5/9/17.
 */
public class SimpleModule extends SimplePage {

    public SimpleModule(AppiumDriver driver) {
        super(driver);
    }

    public void validateSecondItem(String value) {
        Assert.assertEquals(lblsecondItem.getText(), value);
    }

    public void validateSecondStart() {
        org.testng.Assert.assertEquals(secondStart.getAttribute("value"), "5 stars set.");
    }

    public void tapOnFirstItem() {
        lblfirstItem.click();
    }

    public void validateFirstStart() {
        org.testng.Assert.assertEquals(firstStartUpdated.getAttribute("value"), "2 stars set.");
    }
}
