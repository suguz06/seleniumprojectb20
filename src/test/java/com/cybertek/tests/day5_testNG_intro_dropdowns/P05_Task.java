package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P05_Task {

    /*
    TC	#3:	SeleniumEasy	Checkbox	Verification	– Section	2
1. Open	Chrome	browser
2. Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify	“Check	All”	button	text	is	“Check	All”
4. Click	to	“Check	All”	button
5. Verify	all	check	boxes	are	checked
6. Verify	button	text	changed	to	“Uncheck	All”
     */


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod()
    {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @Test
    public void checkAll() {
        WebElement checkAllButton=driver.findElement(By.id("check1"));
        String checkAllButtonAttribute = checkAllButton.getAttribute("value");
        Assert.assertEquals(checkAllButtonAttribute, "Check All");

        //4. Click	to	“Check	All”	button
        //5. Verify	all	check	boxes	are	checked

        checkAllButton.click();

        WebElement option1=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input"));
        WebElement option2=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input"));
        WebElement option3=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input"));
        WebElement option4=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input"));

Assert.assertTrue(option1.isSelected()); Assert.assertTrue(option2.isSelected());
Assert.assertTrue(option3.isSelected());Assert.assertTrue(option4.isSelected());

        //6. Verify	button	text	changed	to	“Uncheck	All”
Assert.assertEquals(checkAllButton.getAttribute("value"),"Uncheck All");



    }


}
