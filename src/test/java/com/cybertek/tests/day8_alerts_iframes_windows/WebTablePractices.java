package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);
    }

    //using verify order method  in SmartBearUtilities class
  @Test
  public void task4_verify_order(){

        String name="Mark Smith";


        SmartBearUtilities.verifyOrder(driver,name );

        SmartBearUtilities.printNamesAndCities(driver);



  }

    //using printNamesAndCities method  in SmartBearUtilities class
    @Test
    public void tas5_printAllNames_Cities(){



        SmartBearUtilities.printNamesAndCities(driver);



    }



}
