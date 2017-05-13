package objects;

import bases.BasePage;
import helper.CommonFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;


/**
 * Created by Hoang on 4/25/17.
 */
public class SimplePage extends BasePage {

    public SimplePage(AppiumDriver driver) {
        super(driver);
    }

    @iOSFindBy(className = "XCUIElementTypeStaticText")
    List<MobileElement> items;
    protected MobileElement lblsecondItem = items.get(2);

    @iOSFindBy(className = "XCUIElementTypeButton")
    List<MobileElement> secondStarts;
    protected MobileElement secondStart = secondStarts.get(9);


    @iOSFindBy(className = "XCUIElementTypeStaticText")
    protected MobileElement lblfirstItem = items.get(1);


    @iOSFindBy(className = "XCUIElementTypeButton")
    List<MobileElement> getFirstStartsUpdated;
    protected MobileElement firstStartUpdated = getFirstStartsUpdated.get(3);


}
