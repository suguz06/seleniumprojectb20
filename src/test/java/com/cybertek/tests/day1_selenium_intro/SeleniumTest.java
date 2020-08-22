package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        //1. set up webDriver

        WebDriverManager.chromedriver().setup();

        //2. create an instance of the Chorme Driver

        WebDriver driver=new ChromeDriver();

        //3. test if driver is working
        driver.get("https://www.google.com");


    }



}
