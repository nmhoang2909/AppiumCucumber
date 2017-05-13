package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Created by Hoang on 4/24/17.
 */
public class CommonFunctions {

    public static AppiumDriver driver;


    public static void fillInNative(MobileElement element, String value) {
        element.clear();
        element.setValue(value);
    }

    public static void tapElement(AppiumDriver driver, MobileElement element) {
        findElement(driver, element);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(element).perform();
    }

    public static void fillInWebView(MobileElement element, String value) {
        if (element.getText().length() > 0) {
            element.clear();
            if (element.getText().length() > 0) {
                element.click();
                element.clear();
            }
        } else {
            element.setValue(value);
        }
    }

    public static String randomString(int length) {
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(rd.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    public static String randomEmail() {
         return randomString(8) + "@mailinator.com";
    }

    public static void waitElement(AppiumDriver driver, MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static MobileElement findElement(AppiumDriver driver, MobileElement element) {
        while (element.getSize().getHeight() == 0) {
            Dimension dimension = driver.manage().window().getSize();
            Double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimension.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();

//            driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
            new TouchAction(driver).press(0, scrollStart).waitAction(2000)
                    .moveTo(0, scrollEnd).release().perform();

            return element;
        }

        if (element.getSize().getHeight() != 0)
            return element;
        return element;
    }
}
