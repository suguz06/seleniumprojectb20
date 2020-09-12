package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank3 {

    /*
    C #3: Zero Bank login title verification
    1.Open Chrome browser
    2.Go to http://zero.webappsecurity.com/login.html
    3.Enter username: username
    4.Enter password: password
    5.Verify title changed to:Expected: “Zero –Account Summary
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password" + Keys.ENTER);

        // OR
        // driver.findElement(By.name("submit") ).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Zero - Account Summary";

        System.out.println(actualTitle.equalsIgnoreCase(expectedTitle) ? "PASSED" : "FAILED");

    }
}
