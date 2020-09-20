package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartBearUtilities {


    public static void loginToSmartBear(WebDriver driver){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        //4. Enter password: “test”
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.className("button")).click();

    }
}
