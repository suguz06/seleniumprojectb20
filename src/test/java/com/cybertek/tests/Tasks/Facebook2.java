package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook2 {

    public static void main(String[] args) throws InterruptedException {

/*
TC #2: Facebook incorrect login title verification
1.Open Chrome browser
2.Go to https://www.facebook.com
3.Enter incorrect username
4.Enter incorrect password
5.Verify title changed to: Expected: “Log into Facebook | Faceboook"
 */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        String url = "https://www.facebook.com";
        driver.get(url);

       driver.findElement(By.name("email")).sendKeys("123455");
       driver.findElement(By.name("pass")).sendKeys("sdsdsd"+ Keys.ENTER);

       Thread.sleep(5000);

       String actualTitle= driver.getTitle();

        System.out.println(actualTitle);

       String expectedTitle="Log into Facebook | Facebook";
        System.out.println(actualTitle.equalsIgnoreCase(expectedTitle)? "PASSED": "FAILED");

    }
}
