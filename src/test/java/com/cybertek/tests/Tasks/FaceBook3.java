package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook3 {
/*
TC #3: Facebook header verification1.Open Chrome browser
2.Go to https://www.facebook.com
3.Verify header text is as expected:
 Expected: “Connect with friends and the world around you on Facebook.”
 */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
       // driver.manage().window().maximize();

driver.get("https://www.facebook.com");

         String  actualHeader=driver.findElement(By.tagName("h2")).getText();
         String expectedHeader="Connect with friends and the world around you on Facebook.";

        System.out.println(actualHeader.equalsIgnoreCase(expectedHeader)? "PASSED": "FAILED");




    }
}
