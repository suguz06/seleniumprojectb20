package com.cybertek.tests.day10_testBase_properties_driverUtil;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.SmartBearUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices_9_10_11 extends TestBase { // by inheritance, we all my setup extended by TestBase class


//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUpMethod(){
//        driver= WebDriverFactory.getDriver("chrome");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }

    @Test
    public void p9_delete_order() throws IOException {

        //creating Properties object to be able to read properties file
        Properties properties = new Properties();

       //opening the file in JVM memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");// put the path in the constructor=>
        // copy from file => path from content root

        //loading the file into properties object
        properties.load(file);

        //URL from CONFIGURATION PROPERTIES
        String url = properties.getProperty("smartbearUrl"); // key format to get VALUE of URL

        driver.get(url);

        BrowserUtil.wait(1);

        SmartBearUtilities.loginToSmartBear(driver);

        //locate checkbox for Mark Smith
        // or xpath=>  //td[.='Mark Smith']/../td[1]
        WebElement MarkSmithCheckBox = driver.findElement(By.xpath("//td[.='Mark Smith']/preceding-sibling::td[1]"));
        MarkSmithCheckBox.click();
        //locate Delete selected
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();


        BrowserUtil.wait(2);
        //Assert Mark Smith is not there

        List<WebElement> nameList = driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td[2]"));

        for (WebElement each : nameList) {
            if (!each.getText().contains("Mark Smith")) {
                Assert.assertTrue(true);
            }
        }

////Assert.assertTrue(!each.equals("Mark Smith"));
//
//        //Assert.assertNotEquals(eachName, "Mark Smith");
//
//        for (WebElement element : nameList) {
//            Assert.assertFalse(element.getText().equals("Mark Smith"));
//        }
//
//        for (WebElement name : nameList) {
//            Assert.assertNotEquals(name.getText(), "Mark Smith");
//        }

//        for (WebElement each : webElements) {
//             Assert.assertEquals(each.getText(), "Mark Smith");
//        }
//
        //SmartBearUtilities.verifyOrder(driver, "Mark Smith");

        // 2.Delete “Mark Smith” from the list
        // 3.Assert it is deleted from the list
    }


}
