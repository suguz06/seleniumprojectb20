package com.cybertek.tests.day7_WebTables;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTables {

/*
TC#3: Smartbear software order verification
1.Open browser and login to Smartbear software
2.Click on View all orders
3.Verify
 Susan McLaren has order on date “01/05/2010”
 */

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);

    }

    @Test
    public void orderVerification() {


//2.Click on View all orders
        driver.findElement(By.xpath("//a[.='View all orders']")).click();


//3.Verify
// Susan McLaren has order on date “01/05/2010”

//for date xpath===>>> //td[.='Susan McLaren']/following-sibling::td[3]
        String date = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[6]/td[5]")).getText();

        Assert.assertEquals(date, "01/05/2010", "Actual date does not macth the expected date");

        //Assert.fail("This is a fail message whatver you say");

//TODO: FIX THE LOCATOR ASAP
    }


    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
