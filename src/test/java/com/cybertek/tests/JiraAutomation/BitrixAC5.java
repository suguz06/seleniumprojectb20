package com.cybertek.tests.JiraAutomation;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixAC5 {


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



    }

    @Test //  USER: hr7@cybertekschool.com
    public void task1(){
        driver.get("https://login2.nextbasecrm.com/");
//        //user name hr7@cybertekschool.com
    driver.findElement(By.name("USER_LOGIN")).sendKeys("hr7@cybertekschool.com");
 // password UserUser
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        BrowserUtil.wait(2);

        driver.findElement( By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();

        BrowserUtil.wait(2);

        driver.findElement( By.id("bx-b-mention-task-form-lifefeed_task_form")).click();

        BrowserUtil.wait(2);

        //driver.findElement( By.xpath(" //*[@id=\"mention99903970_last_U497\"]/div[1]")).click();

        driver.findElement( By.className("bx-finder-box-item-t7-name")).click();
        BrowserUtil.wait(2);

        driver.switchTo().frame(1);


        Assert.assertTrue(driver.findElement(By.className("bxhtmled-metion")).isDisplayed());




    }

    @Test // USER: helpdesk7@cybertekschool.com
    public void task2(){
        driver.get("https://login2.nextbasecrm.com/");
//        //user name hr7@cybertekschool.com
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk7@cybertekschool.com");
        // password UserUser
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        BrowserUtil.wait(2);

        driver.findElement( By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();

        BrowserUtil.wait(2);

        driver.findElement( By.id("bx-b-mention-task-form-lifefeed_task_form")).click();

        BrowserUtil.wait(2);

        //driver.findElement( By.xpath(" //*[@id=\"mention99903970_last_U497\"]/div[1]")).click();

        driver.findElement( By.className("bx-finder-box-item-t7-name")).click();
        BrowserUtil.wait(2);

        driver.switchTo().frame(1);


        Assert.assertTrue(driver.findElement(By.className("bxhtmled-metion")).isDisplayed());




    }



    @Test //USER: marketing7@cybertekschool.com
    public void task3(){
        driver.get("https://login2.nextbasecrm.com/");
//        //user name hr7@cybertekschool.com
        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing7@cybertekschool.com");
        // password UserUser
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        BrowserUtil.wait(2);

        driver.findElement( By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();

        BrowserUtil.wait(2);

        driver.findElement( By.id("bx-b-mention-task-form-lifefeed_task_form")).click();

        BrowserUtil.wait(2);

        //driver.findElement( By.xpath(" //*[@id=\"mention99903970_last_U497\"]/div[1]")).click();

        driver.findElement( By.className("bx-finder-box-item-t7-name")).click();
        BrowserUtil.wait(2);

        driver.switchTo().frame(1);


        Assert.assertTrue(driver.findElement(By.className("bxhtmled-metion")).isDisplayed());




    }

    @AfterMethod
    public void tearsDown(){
        driver.close();
        BrowserUtil.wait(2);
    }


}
