package com.cybertek.tests.day9_windows_tabs;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void task1_windowHandle() {

        driver.get("http://practice.cybertekschool.com/windows");

        //4.Assert:	Title	is	“Practice”
        Assert.assertEquals(driver.getTitle(), "Practice");

        BrowserUtil.wait(2);

        // 5.Click	to:	“Click	Here”text
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        // 6.Switch	to	new	Window.
        String mainHandle = driver.getWindowHandle();
        System.out.println(mainHandle);


//set allows you only uniques
        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            System.out.println("current Handle windoew " + driver.getWindowHandle());

        }


        // driver.switchTo().window();
        //7.Assert:	Title	is	“New	Window”

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);
        Assert.assertEquals(titleAfterClick, "New Window");

        BrowserUtil.wait(2);
        //driver.close(); //driver close

        //if I want to switch back to
        driver.switchTo().window(mainHandle);
        //Assert.assertEquals(driver.getTitle(), "Practice");

        driver.quit(); //close all tabs opened
    }

    @Test
    public void p6_moreThanTwoWindows() {

//1.Create new test and make set ups
// 2.Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");


// 3.Copy paste the lines from below into your class
//downCasting our driver type to JavaScriptExecuter
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

//These lines will simple open new tabs using something called JavaScriptExecut and get those pages.
// We will learn JavaScriptExecutor later as well.


// 4.Create a logic to switch to the tab where Etsy.com is open

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            BrowserUtil.wait(2);
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() each title = " + driver.getTitle());
            System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

            if (driver.getCurrentUrl().contains("etsy")) {
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break; // exit the loop => no go the google and after etsy => it will quit
            }

        }

// 5.Assert: Title contains “Etsy”


    }

}
