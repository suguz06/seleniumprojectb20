package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {// methods compile with alpabetic order // one fails=> no more compiler
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){ // all setup here // create instance drive to use any method
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://google.com");
    }



    @Test
    public void googleTitleVerification(){
        System.out.println("google  title verification test is running");
        //1-Go to google
        //2-Verfiy title is google

     //driver.get("https://google.com");

       // System.out.println(driver.getTitle().equals("Google")? "passed": "failed");

//OR AsserteEquals()
      String expectedTitle="Google";
      String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle, "Titles are not matching");

        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
    }

   @Test
    public void googleSearchTitleVerification(){
       System.out.println("google  search title verification test is running");

       //go to google==> inside the beforeMethod
       //search apple
       WebElement searchBox = driver.findElement(By.name("q"));
       searchBox.sendKeys("apple"+ Keys.ENTER);

       // make sure title contains apple

       String expectedTitle="apple";
       String actualTitle=driver.getTitle();
       Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not contain search value");
Assert.assertTrue(driver.getTitle().contains("apple"));


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }



}
