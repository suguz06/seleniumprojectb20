package com.cybertek.tests.day11_utils_review_actions;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionPractices {

//TC    #15:   Hover  Test
//1. Go    to http://practice.cybertekschool.com/hovers
//2. Hover over   to first  image
//3. Assert:
//a. "name:    user1" is displayed
//4. Hover over   to second image
//5. Assert:
//a. "name:    user2" is displayed
//6. Hover over   to third  image
//7. Confirm:
//a. "name:    user3" is displayed

    @Test
    public void hover_over_test() {

        WebDriver driver = Driver.getDriver();

        driver.get("http://practice.cybertekschool.com/hovers");


        WebElement img1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));


        WebElement user1 = Driver.getDriver().findElement(By.xpath("//*[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//*[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//*[.='name: user3']"));


//
//        actions.moveToElement(img1).perform();
//
//        WebElement user1 = Driver.getDriver().findElement(By.xpath("//*[.='name: user1']"));
//
//        Assert.assertTrue(user1.isDisplayed());
//
//        actions.moveToElement(img2).perform();
//
//        WebElement user2 = Driver.getDriver().findElement(By.xpath("//*[.='name: user2']"));
//        Assert.assertTrue(user2.isDisplayed());
//
//        actions.moveToElement(img3).perform();
//
//        WebElement user3 = Driver.getDriver().findElement(By.xpath("//*[.='name: user3']"));
//
//        Assert.assertTrue(user3.isDisplayed());

        //1. we create the instance of the class, AND pass the driver instance into the constructor

        Actions actions = new Actions(driver); // be careful to ACTIONS !!! class

        // 2. use  the actions object and call necessary method
        BrowserUtil.wait(2);
        actions.moveToElement(img1).perform();

        //3. Do assertions
        Assert.assertTrue(user1.isDisplayed(), "Image 1 is NOT displayed");

        //moving to img2
        BrowserUtil.wait(2);
        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed(), "Image 2 is NOT displayed");

       //moving to img3
        BrowserUtil.wait(2);
        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed(), "Image 3 is NOT displayed");

    }
}
