package com.cybertek.tests.day4_findElements_chechBoxes_radio;
/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH and/or CSS Selector LOCATOR FOR ALL WEBELEMENT LOCATORS
Better if you do with both for practice purposes.
 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P2_Cybertek_add_remove_elements {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/add_remove_elements/");


//3. Click to “Add Element” button

        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        addElementButton.click();
      //  4. Verify “Delete” button is displayed after clicking.

        WebElement deleteButton=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButton.isDisplayed()) {
            System.out.println(deleteButton.getText()+ " button is displayed");
        } else {
            System.out.println(deleteButton.getText()+ " is not displayed");
        }

        //5. Click to “Delete” button.
        deleteButton.click();

       // 6. Verify “Delete” button is NOT displayed after clicking.

      System.out.println(deleteButton.isDisplayed()? "Displayed delete button": "Not Displayed delete  button ");



    }
}
