package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    /*
    TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfuly clicked an alert” text is displayed.
     */

    @Test
    public void p1_information_alert_pratice(){

//3. Click to “Click for JS Alert” button
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));


//4. Click to OK button from the alert
        warningAlertButton.click();
//5. Verify “You successfuly clicked an alert” text is displayed.
        Alert alert=driver.switchTo().alert();

        BrowserUtil.wait(2);

        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));

        String actualResult = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actualResult, "You successfuly clicked an alert" );

        Assert.assertTrue(resultText.isDisplayed(), "not displayed result text, verification is FAILDE!!");

    }


    @Test
    public void p2_confirmation_alert(){


//3. Click to “Click for JS Alert Confirm” button
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));


//4. Click to OK button from the alert
        warningAlertButton.click();

        Alert alert=driver.switchTo().alert();

        BrowserUtil.wait(2);

        alert.accept();

        Assert.assertTrue(driver.findElement(By.xpath("//p[.='You clicked: Ok']")).isDisplayed());




    }


    @Test
    public void p3_confirmation_alert(){


        //3. Click to “Click for JS Alert” button
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));


//4. Click to OK button from the alert
        warningAlertButton.click();
//5. Verify “You successfuly clicked an alert” text is displayed.
        Alert alert=driver.switchTo().alert();

        BrowserUtil.wait(2);


//4. Send “hello” text to alert

        alert.sendKeys("hello");

//5. Click to OK button from the alert

alert.accept();

//6. Verify “You entered: hello” text is displayed.
Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());

        System.out.println("driver.findElement(By.xpath(\"//p[@id='result']\")) = " + driver.findElement(By.xpath("//p[@id='result']")).getText());
    }



}
