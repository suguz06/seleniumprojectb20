package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationAndTitleVerification {

    public static void main(String[] args) {
        /*
        TC #3: Back and forth navigation
        1-Open a chrome browser
        2-Go to: https://google.com
        3-Click to Gmail from top right.
        4-Verify title contains:Expected: Gmail
        5-Go back
        to Google by using the .back();
        6-Verify title equals:
        Expected: Google
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        // 3-Click to Gmail from top right.

        driver.findElement(By.partialLinkText("mail")).click(); //partial web element check
       // driver.findElement(By.linkText("Gmail")).click(); exact check

//4-Verify title contains:Expected: Gmail
        String expectedTitle="Gmail";
        if(driver.getTitle().contains(expectedTitle)) {
            System.out.println("Verfication is passed");
        } else {
            System.out.println("Verfication is Failed");
        }


//5-Go back
//        to Google by using the .back();

        driver.navigate().back();

//6-Verify title equals:
//        Expected: Google

        if(driver.getTitle().equals("Google")){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

    }
}
