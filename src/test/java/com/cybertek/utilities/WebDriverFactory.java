package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {


    /*
    Task: NEW METHOD CREATION
    Method name: getDriver
    Static method
    Accepts string argument browserType--> will determine browser opens
    return type: WebDriver
     */

    public static WebDriver getDriver(String browserType) {


       if(browserType.equalsIgnoreCase("chrome")) {
          //System.setProperty("webdriver.chrome.driver", "path");
           WebDriverManager.chromedriver().setup();
          return new ChromeDriver();
       }

        else if(browserType.equalsIgnoreCase("opera")) {

            WebDriverManager.operadriver().setup();
            return new OperaDriver();
        }

       else if(browserType.equalsIgnoreCase("edge")) {
           WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
       }
       else if(browserType.equalsIgnoreCase("firefox")) {
           WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
       }
       else {
           System.out.println("Given browser does not exit. Driver=null!!");
           return null;
       }


    } }


