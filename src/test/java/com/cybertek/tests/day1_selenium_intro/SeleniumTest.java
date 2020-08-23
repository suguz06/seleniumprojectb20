package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args)  throws InterruptedException{

        //1. set up webDriver

        WebDriverManager.chromedriver().setup();


        //another way use
        // System.setProperty("driver.type", "path to the driver");


        //2. create an instance of the Chrome Driver

        WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
       // driver.manage().window().fullscreen(); works in MAC
        //3. test if driver is working
        driver.get("https://www.google.com"); // wait all page load
        // driver.get("https://facebook.com");


        System.out.println("The title of webpage: " + driver.getTitle());
        //System.out.println(driver.getCurrentUrl());


        String actualTitle = driver.getTitle();// since return type is String

        System.out.println("Actual Title: " + actualTitle);

        String currentURL = driver.getCurrentUrl();

        System.out.println(currentURL);

//     Thread.sleep(3000);
//
//     driver.navigate().back();
//
//        Thread.sleep(3000);
//
//        driver.navigate().forward();
//
//        Thread.sleep(3000);
//
//        driver.navigate().refresh();
//
//        Thread.sleep(3000);


//        for (int i=0; i<=10; ++i){
//            driver.navigate().back();
//            Thread.sleep(3000);
//            driver.navigate().forward();
//        }


        //driver.navigate().to("https://yahoo.com"); // not wait to load all page
      // driver.close();


      //  String pageSource=driver.getPageSource();
      //  System.out.println("pageSource = " + pageSource);


       // driver.manage().window().maximize();

        driver.manage().window().maximize();

driver.close(); // just one page is close the last one
///driver.quit(); all browsres close
    }


}
