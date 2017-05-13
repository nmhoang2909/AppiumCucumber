package objects;

import bases.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;

import java.util.List;

/**
 * Created by Hoang on 5/13/17.
 */
public class SecondPage extends BasePage {

    public SecondPage(AppiumDriver driver) {
        super(driver);
    }

    @iOSFindBy(className = "XCUIElementTypeTextField")
    protected MobileElement txtFirstItem;

    @iOSFindBy(className = "XCUIElementTypeButton")
    List<MobileElement> firstStarts;
    protected MobileElement firstStart = firstStarts.get(3);
    protected MobileElement btnSave = firstStarts.get(1);
}
