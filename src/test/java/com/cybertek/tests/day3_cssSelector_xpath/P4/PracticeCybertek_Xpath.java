package com.cybertek.tests.day3_cssSelector_xpath.P4;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeCybertek_Xpath {


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
driver.get("http://practice.cybertekschool.com/multiple_buttons");

    // button 2 click

        WebElement button2= driver.findElement(By.xpath("//button[name='button2'] "));
button2.click();

    }
}
