package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTASKS {


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }


    @Test
    public void task1(){
        //3.Click to “Click for JS Alert”button
driver.findElement(By.xpath("//*[.='Click for JS Alert']")).click();

        Alert alert=driver.switchTo().alert();

        // 4.Click to OK button from the alert
        alert.accept();
        // 5.Verify “You successfulyclicked an alert”text is displayed
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

    }

    @Test
    public void task2(){

//3 Click to “Click for JS Confirm” button
driver.findElement(By.xpath(" //button[2]")).click();

//4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
//5. Verify “You clicked: Ok” text is displayed
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

    }



    @Test
    public void task3(){

        //Click to “Click for JS Prompt” button
        driver.findElement(By.xpath(" //button[3]")).click();


        //4. Send “hello” text to alert

        Alert alert=driver.switchTo().alert();

        BrowserUtil.wait(2);

        alert.sendKeys("hello");

        BrowserUtil.wait(5);

        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.


        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());

        //Verify the result text contains input sendKeys =>"hello"

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("hello"));
    }





}
