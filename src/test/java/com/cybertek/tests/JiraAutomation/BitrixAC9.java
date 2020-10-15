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

public class BitrixAC9 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);



    }

    @Test // USER: hr7@cybertekschool.com
    public void task1(){
        driver.get("https://login2.nextbasecrm.com/");
//        //user name hr7@cybertekschool.com
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr7@cybertekschool.com");
        // password UserUser
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        BrowserUtil.wait(2);

        driver.findElement( By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();

        BrowserUtil.wait(2);

        driver.findElement(By.xpath("//*[.='Time planning']")).click();
        BrowserUtil.wait(2);
        driver.findElement(By.className("task-options-inp")).click();


        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//span[.='Select']")).click();

        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/span/input[1]")).click();

        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//span[.='Select']")).click();

        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[3]/span[1]/input")).sendKeys("3");

        BrowserUtil.wait(1);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[4]/span/input[1]")).isDisplayed());

//        Actions actions = new Actions(driver);
//
//        WebElement target=driver.findElement(By.xpath("//*[@id=\"popup-window-content-calendar_popup_0.35632342826313823\"]/div/div[3]/div/div[3]/a[4]"));
////
////        WebElement target = driver.findElement(By.xpath("//span[.='\n" + "    Fleet']"));
//     actions.moveToElement(target).doubleClick(target);


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

        driver.findElement(By.xpath("//*[.='Time planning']")).click();
        BrowserUtil.wait(2);
        driver.findElement(By.className("task-options-inp")).click();


        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//span[.='Select']")).click();

        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/span/input[1]")).click();

        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//span[.='Select']")).click();
        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[3]/span[1]/input")).sendKeys("3");

        BrowserUtil.wait(1);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[4]/span/input[1]")).isDisplayed());



    }

    @Test // USER: marketing7@cybertekschool.com
    public void task3(){
        driver.get("https://login2.nextbasecrm.com/");
//        //user name hr7@cybertekschool.com
        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing7@cybertekschool.com");
        // password UserUser
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);

        BrowserUtil.wait(2);

        driver.findElement( By.xpath("//*[@id=\"feed-add-post-form-tab-tasks\"]/span")).click();

        BrowserUtil.wait(2);

        driver.findElement(By.xpath("//*[.='Time planning']")).click();
        BrowserUtil.wait(2);
        driver.findElement(By.className("task-options-inp")).click();

        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//span[.='Select']")).click();

        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/span/input[1]")).click();

        BrowserUtil.wait(1);
        driver.findElement(By.xpath("//span[.='Select']")).click();
        BrowserUtil.wait(1);

        driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[3]/span[1]/input")).sendKeys("3");
        BrowserUtil.wait(1);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"bx-component-scope-lifefeed_task_form\"]/div/div[3]/div[2]/div/div[2]/div[1]/div/div[4]/span/input[1]")).isDisplayed());



    }

    @AfterMethod
    public void tearsDown(){
        driver.close();
        BrowserUtil.wait(2);
    }

}
