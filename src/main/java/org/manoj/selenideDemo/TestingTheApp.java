package org.manoj.selenideDemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class TestingTheApp {
    public void wait(AndroidDriver driver, Integer s){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
    }

    @Test
    public void Test1() throws MalformedURLException, InterruptedException {
        Configuration.browser = AndroidDriverProvider.class.getName();
        SelenideAppium.launchApp();

        //opening menu
        $(AppiumBy.accessibilityId( "open menu")).click();
        //clicking log in
        $(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")).shouldBe(visible).click();
        //entering log in details
        $(AppiumBy.accessibilityId("Username input field")).shouldBe(visible).sendKeys("bob@example.com");
        $(AppiumBy.accessibilityId("Password input field")).shouldBe(visible).sendKeys("10203040");
        $(AppiumBy.accessibilityId("Login button")).shouldBe(clickable).click();

        //checkout process
        $(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]")).shouldBe(visible).click();
        $(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).shouldBe(clickable).click();
        $(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).shouldBe(visible).click();
        $(By.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]")).shouldBe(clickable).click();

        //checkout Details
        $(AppiumBy.accessibilityId("Full Name* input field")).shouldBe(visible).sendKeys("Manoj");
        $(AppiumBy.accessibilityId("Address Line 1* input field")).shouldBe(visible).sendKeys("12/1, 7th Street");
        $(AppiumBy.accessibilityId("Address Line 2 input field")).shouldBe(visible).sendKeys("Perambur");
        $(AppiumBy.accessibilityId("City* input field")).shouldBe(visible).sendKeys("Chennai");
        $(AppiumBy.accessibilityId("State/Region input field")).shouldBe(visible).sendKeys("Tamil Nadu");
        $(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).shouldBe(visible).sendKeys("600011");
        $(AppiumBy.accessibilityId("Country* input field")).shouldBe(visible).sendKeys("India");
        $(By.xpath("//android.widget.TextView[@text=\"To Payment\"]")).shouldBe(clickable).click();

        //Payment method
        $(AppiumBy.accessibilityId("Full Name* input field")).shouldBe(visible).sendKeys("Manoj");
        $(AppiumBy.accessibilityId("Card Number* input field")).shouldBe(visible).sendKeys("123412341234");
        $(AppiumBy.accessibilityId("Expiration Date* input field")).shouldBe(visible).sendKeys("03/25");
        $(AppiumBy.accessibilityId("Security Code* input field")).shouldBe(visible).sendKeys("123");
        $(By.xpath("//android.widget.TextView[@text=\"Review Order\"]")).shouldBe(clickable).click();
        $(AppiumBy.accessibilityId("Place Order button")).shouldBe(clickable).click();

        //success message
        String text=$(By.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]")).shouldBe(visible).getText();
        System.out.println(text);
        Assert.assertEquals("Checkout Complete",text);

    }
}