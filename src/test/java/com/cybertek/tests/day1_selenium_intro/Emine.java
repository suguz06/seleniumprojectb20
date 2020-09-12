package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Emine {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        String expectedInTitle="Zero - Log in";
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedInTitle)){
            System.out.println("PASSED!!");
        }else{
            System.out.println("FAILED!!!");
        }
    }
}
