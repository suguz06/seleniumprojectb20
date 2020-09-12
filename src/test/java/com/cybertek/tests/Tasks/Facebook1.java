package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook1 {
/*
TC #1: Facebook title verification1.Open Chrome browser
2.Go to https://www.facebook.com
3.Verify title: Expected: “Facebook -Log In or Sign Up”
 */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
      //  driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String expectedTitle="Facebook - Log In or Sign Up";
        String actualTitle=driver.getTitle();

        System.out.println(expectedTitle.equalsIgnoreCase(actualTitle)? "PASSED": "FAILED");

    }
}
