package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDrFactory1 {


    /*
    Method name: getDriver
    Static method
    Acceptd string argument : browserType-->will determine what browser opens
    return type  : Webdriver
     */
    public  static WebDriver getDriver(String browserName){

        switch (browserName){
            case "Opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "Edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            default:
                System.out.println("Invalid Browser");
                return null;
        }
    }

}
