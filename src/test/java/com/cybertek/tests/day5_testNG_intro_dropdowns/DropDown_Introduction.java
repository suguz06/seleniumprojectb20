package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown_Introduction {

WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");

    }


    @Test
    public void dropDownTest1() throws InterruptedException {
//TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
//1. Open Chrome browser
//2. Go to http://practice.cybertekschool.com/dropdown

//3. Verify “Simple dropdown” default selected value is correct


       Select simpleDropDown=new Select(driver.findElement(By.id("dropdown")));



        String actualSelectedOption = simpleDropDown.getFirstSelectedOption().getText();


        String expectedOption="Please select an option";
//Expected: “Please select an option”
        Assert.assertEquals(actualSelectedOption,expectedOption, "default values different");

        Thread.sleep(3000);

        simpleDropDown.selectByVisibleText("Option 2");
        System.out.println(simpleDropDown.getFirstSelectedOption().getText());




//4. Verify “State selection” default selected value is correct
//Expected: “Select a State”

        Select stateDropDown=new Select(driver.findElement(By.id("state")));


       String actualStateOption = stateDropDown.getFirstSelectedOption().getText();

String expected="Select a State";
        Assert.assertEquals(actualStateOption,expected, "default values different");

        Thread.sleep(3000);


        stateDropDown.selectByVisibleText("Texas");
        stateDropDown.selectByVisibleText("Florida");
        List<WebElement> options = stateDropDown.getAllSelectedOptions();

        for(WebElement a: options) {
            System.out.println(a.getText());
        }


        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Etsy")).click();



    }

}
