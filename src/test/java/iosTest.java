import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class iosTest {

    @Test
    public void iosLaunchTest() throws MalformedURLException, InterruptedException {
        XCUITestOptions options=new XCUITestOptions();
        //options.setPlatformName("iPhone 15");
        options.setDeviceName("iPhone 15");
        options.setApp(System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
        IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723"),options);
        Thread.sleep(5000);
        driver.quit();


    }
}
