package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #4 : Iframe practice
        //1. Create a new class called: IframePractice
        //2. Create new test and make set ups

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");

    }

@Test
    public void p1_iframe(){

//iframe (many inside iframe of html) => 3 ways of location

    //1- by index =>starts from zero to integer
   // driver.switchTo().frame(0);


    //2- by id or name => by usung id atrribute value
    //driver.switchTo().frame("mce_0_ifr");


    //3- locate as a web element, then switch to it

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

    driver.switchTo().frame(iframe);
//


    //4. Assert: “Your content goes here.” Text is displayed.

    WebElement p = driver.findElement(By.tagName("p"));
    String actualText = p.getText();

    Assert.assertTrue(p.isDisplayed());




    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor

// back to parent HTML
    driver.switchTo().parentFrame();

    String headerText = driver.findElement(By.xpath("//h3")).getText();


    Assert.assertEquals(headerText, "An iFrame containing the TinyMCE WYSIWYG Editor");

}

}
