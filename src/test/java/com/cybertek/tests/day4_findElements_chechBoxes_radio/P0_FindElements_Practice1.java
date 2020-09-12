package com.cybertek.tests.day4_findElements_chechBoxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/*
TC #0: FINDELEMENTS1.Open Chrome browser
2.Go tohttp://practice.cybertekschool.com/forgot_password
3.
Print out the texts of all links
4.Print out how many total link
 */
public class P0_FindElements_Practice1 {


    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");


        List<WebElement> webElements = driver.findElements(By.xpath("//body//a"));


      //looping through for the list of webElements
        for (WebElement eachLink: webElements) {
            System.out.println( eachLink.getText()); //eachLink reah yhe link=> we write by using get tex method
        }



        System.out.println("webElements.size() = " + webElements.size());

driver.close();

    }
}
