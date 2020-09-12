package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6_ZeroBankHeader {

    public static void main(String[] args) {

        /*
        TC #6: Zero Bankheader verification
        1.Open Chrome browser
        2.Go to http://zero.webappsecurity.com/login.html
        3.Verify header
         textExpected: “Log in to ZeroBank”
         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();


//2.Go to http://zero.webappsecurity.com/login.html

        driver.get("http://zero.webappsecurity.com/login.html");
//3.Verify header
//         textExpected: “Log in to ZeroBank”

        String expectedHeader="Log in to ZeroBank";
        String actualHeader=driver.findElement(By.tagName("h3")).getText();
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println("actualHeader = " + actualHeader);

        if(actualHeader.equals(expectedHeader)) {
            System.out.println("Verification of Header PASSED");
        }else {
            System.out.println("FAILED");
        }
    }
}
