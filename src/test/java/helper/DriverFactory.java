package helper;

import helper.CommonFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Hoang on 5/9/17.
 */
public class DriverFactory {

    protected static AppiumDriver driver;
    public final static String IOS_RESET = "ios reset";
    public final static String IOS_NO_RESET = "ios no reset";
    private static final String BUILD_PATH = "src/test/resources/builds";
    private static final String APP_NAME = "FoodTracker.app";
    private static final String IOS_PLATFORM_VERSION = "10.1";
    private static final String IOS_SIMULATOR = "iPhone 7";
    private static final String URL_IOS_DRIVER = "http://0.0.0.0:4724/wd/hub";


    private void createDriverInstance(String typeReset) {

        File appDir = new File(BUILD_PATH);
        File app = new File(appDir, APP_NAME);

        if (typeReset.equals(IOS_RESET)) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, IOS_PLATFORM_VERSION);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, IOS_SIMULATOR);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

            try {
                driver = new IOSDriver(new URL(URL_IOS_DRIVER), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (typeReset.equals(IOS_NO_RESET)){

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, IOS_PLATFORM_VERSION);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, IOS_SIMULATOR);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

            try {
                driver = new IOSDriver(new URL(URL_IOS_DRIVER), desiredCapabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize(String typeReset) {
        if (driver == null) {
            createDriverInstance(typeReset);
        }
    }

    public DriverFactory(String typeReset) {
        initialize(typeReset);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public static void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
