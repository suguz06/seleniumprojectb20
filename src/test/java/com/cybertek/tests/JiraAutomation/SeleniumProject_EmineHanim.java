package com.cybertek.tests.JiraAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumProject_EmineHanim {

    //1. Launch browser of your choice say., firefox, chrome etc.
    //2. Open this URL -  https://www.techlistic.com/
    //3. Maximize or set size of browser window.
    //4. Click on ‘Java Tutorial’ link and validate page title.
    //5. Navigate back to Home Page.
    //6. Click on ‘Selenium Tutorial’ link and validate page title.
    //7. Navigate back to Home Page.
    //8. Click on ‘Selenium Blogs’ link and validate page title.
    //9. Navigate back to Home Page.
    //10. Click on ‘TestNG Blogs’ link and validate page title.
    //11. Close the browser.


    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("https://www.techlistic.com/");
        driver.findElement(By.linkText("Java")).click();
        Assert.assertEquals(driver.getTitle(), "Java Tutorial For Beginners - Techlistic");



        driver.navigate().back();


    }


}
