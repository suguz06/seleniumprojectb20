package com.cybertek.tests.JiraAutomation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Vytrack_Assignment4 {


    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user167");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);


    }





//
//    @Test
//    public void vyTrackVehPageAccess() throws InterruptedException {
//        Thread.sleep(2000);
//        Actions actions = new Actions(driver);
//        WebElement target = driver.findElement(By.xpath("//span[.='\n" + "    Fleet']"));
//        actions.moveToElement(target).perform();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//span[.='Vehicles']")).click();
//        Thread.sleep(1000);
//        String expectedTitle = "Car - Entities - System - Car - Entities - System";
//        String actualTitle = driver.getTitle();
//        String expectedHeader = "Cars";
//        String actualHeader = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
//        Assert.assertEquals(expectedTitle,actualTitle,"Expected title does not equal to actual title");
//        Assert.assertEquals(expectedHeader,actualHeader,"Expected header does not equal to actual header");}


@Test
    public void VyTrackAutomation() throws InterruptedException {
    Thread.sleep(2000);
    Actions actions = new Actions(driver);
    WebElement target = driver.findElement(By.xpath("//span[.='\n" + "    Fleet']"));
    actions.moveToElement(target).perform();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//span[.='Vehicle Odometer']")).click();
    Thread.sleep(1000);

    //driver.findElement(By.xpath("//*[.='Anastasiia']")).click();

//td[.='driver123']
    driver.findElement(By.xpath("//td[.='driver123']")).click();

    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div[1]/div[3]/a")).click();
    Thread.sleep(1000);
//    driver.findElement(By.xpath("//*[@id=\"oro_attachment_file_file-uid-5f62d0df0673d\"]")).click();
//    Thread.sleep(1000);

    driver.findElement(By.name("oro_attachment[comment]")).sendKeys("Test"+Keys.ENTER);
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    Thread.sleep(1000);


    String text = driver.findElement(By.xpath("//*[.='This value should not be blank.']/span/span")).getText();
    Thread.sleep(1000);

    Assert.assertEquals(text, "This value should not be blank.");

}




    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
       driver.close();
    }
}
