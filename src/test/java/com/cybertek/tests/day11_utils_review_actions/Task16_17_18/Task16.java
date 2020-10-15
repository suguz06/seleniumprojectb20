package com.cybertek.tests.day11_utils_review_actions.Task16_17_18;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task16 {

    /*
    TC	#16:	Double	ClickTest
    1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”	attribute	value	contains "red"
     */


    @Test
    public void task16() {


        WebDriver driver = Driver.getDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

       // driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
//OR name value-->>
        driver.switchTo().frame("iframeResult");

        BrowserUtil.wait(2);

        WebElement doubleClick = driver.findElement(By.id("demo"));

        BrowserUtil.wait(2);
        Actions actions=new Actions(driver);

        actions.doubleClick(doubleClick).perform();

        String attribute = driver.findElement(By.id("demo")).getAttribute("style");

        System.out.println(attribute);
         Assert.assertTrue(driver.findElement(By.id("demo")).getAttribute("style").contains("red"));




    }
}
