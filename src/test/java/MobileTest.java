import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;

public class MobileTest {
    public void wait(AndroidDriver driver,Integer s){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }

    @Test
    public void androidLaunchTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Pixal");
        options.setApp(System.getProperty("user.dir")+"/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"))
                .click();
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
        wait(driver,10);
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")).click();
        wait(driver,10);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
        wait(driver,10);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
        wait(driver,10);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]")).click();
        wait(driver,10);
        //android.widget.TextView[@text="Proceed To Checkout"]
        driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Manoj");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Address Line 1* input field")).sendKeys("12/1, 7th Street");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Address Line 2 input field")).sendKeys("Perambur");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("City* input field")).sendKeys("Chennai");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("State/Region input field")).sendKeys("Tamil Nadu");
        wait(driver,10);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys("600011");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Country* input field")).sendKeys("India");
        wait(driver,10);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]")).click();
        wait(driver,10);
        //Payment method
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("Full Name* input field")).sendKeys("Manoj");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Card Number* input field")).sendKeys("123412341234");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Expiration Date* input field")).sendKeys("03/25");
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Security Code* input field")).sendKeys("123");
        wait(driver,10);
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Review Order\"]")).click();
        wait(driver,10);
        driver.findElement(AppiumBy.accessibilityId("Place Order button")).click();
        wait(driver,10);
        String text=driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]")).getText();
        System.out.println(text);
    }

}
