package helper;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * Created by Hoang on 4/24/17.
 */
public class Service {

    public static AppiumDriverLocalService service;

    public static void startService() {

        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4724));
        System.out.print("\n _____ Starting Appium Server _____ \n ");
        service.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stopService() {
        System.out.print("\n ______ Stopping Appium Server _____ \n ");
        service.stop();
    }
}
