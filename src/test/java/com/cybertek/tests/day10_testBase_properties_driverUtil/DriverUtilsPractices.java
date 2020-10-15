package com.cybertek.tests.day10_testBase_properties_driverUtil;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractices {


    @Test
    public void simple_google_search_test(){
 //Driver.getDriver()= driver.get(gaogle);
        
        //From now on we will call the driver Driver.getDriver
  Driver.getDriver().get("https://www.google.com/");


        WebElement searchBox=Driver.getDriver().findElement(By.name("q"));
String search= ConfigurationReader.getProperty("searchValue");

       //HardCoded Value=> manually added wooden spoon
  // searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

  searchBox.sendKeys(search+ Keys.ENTER);


   //expected title

        String expectedTitle= search; //"wooden spoon";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


}
