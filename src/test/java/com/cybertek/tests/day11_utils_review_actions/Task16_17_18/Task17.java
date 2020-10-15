package com.cybertek.tests.day11_utils_review_actions.Task16_17_18;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task17 {

    //TC	#17:	Context	Click	–HOMEWORK
    // 1.Go	to	https://the-internet.herokuapp.com/context_menu
    // 2.Right	click	to	the	box.
    // 3.Alert	will	open.
    // 4.Accept	alertNo	assertion	needed	for	this	practice


    @Test
    public  void  task17(){
        WebDriver driver = Driver.getDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions=new Actions(driver);

        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        BrowserUtil.wait(2);
        Driver.closeDriver();


    }
}
