package com.cybertek.tests.day5_testNG_intro_dropdowns;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*
TC	#2:	SeleniumEasy	CheckboxVerification–Section
1
1.Open	Chrome	browser
2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
3.Verify
“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
5.Verify	“Success
–Check	box	is	checked”	message	isdisplayed.
 */
public class P05_SeleniumEasy_Task1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


       //locate checkbox
        WebElement successCheckBox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));


        //locate the success messaage

        WebElement successMessage=driver.findElement(By.xpath("//div[.='Success - Check box is checked']"));

        //3.Verify
        //“Success	–Check	box	is	checked”	message	is	NOTdisplayed.

if ( !successCheckBox.isSelected()&&!successMessage.isDisplayed()) {
    System.out.println("Success message not displayed. Verifictaion is PASSED!");

} else
{
    System.out.println("Success message is displayed. Verifictaion is FAILED!");
}

//        4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
successCheckBox.click();

//        5. Verify	“Success
//–Check	box	is	checked”	message	isdisplayed.
//
        if ( successMessage.isDisplayed()) {
            System.out.println("Success message   displayed. Verifictaion is PASSED!");

        } else
        {
            System.out.println("Success message is not displayed. Verifictaion is FAILED!");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
