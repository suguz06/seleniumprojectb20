package com.cybertek.tests.day4_findElements_chechBoxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements
3. Click to “Add Element” button 50 times
4. Verify 50 “Delete” button is displayed after clicking.
5. Click to ALL “Delete” buttons to delete them.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Hint: Need to use findElements method.
 */
public class Task2_Delete_Add_Remove {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button 50 times
        for (int i = 0; i <50 ; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        }

        Thread.sleep(5000);
        //4. Verify 50 “Delete” button is displayed after clicking.
        for (int i = 1; i <= 50; i++) {

             //driver.findElement(By.xpath(" //*[@id='elements']/button[i]"));

            System.out.println( driver.findElement(By.xpath(" //*[@id='elements']/button["+i+"]")).isDisplayed()? "Delete button "+ i+ " is displayed: " : "FAILED");
            //Thread.sleep(1000);
        }



        //5. Click to ALL “Delete” buttons to delete them.

        List<WebElement> webElements = driver.findElements(By.xpath("//body//button[@class]"));

        for (WebElement element: webElements) {
            element.click();
        }


        Thread.sleep(5000);


//or


//        for (int i = 50; i >=1; i--) {
//
//            driver.findElement(By.xpath(" //*[@id='elements']/button["+i+"]")).click();
//
//        }

        //6. Verify “Delete” button is NOT displayed after clicking.


        String text = driver.findElement(By.xpath("//body//button")).getText();

        System.out.println(text);

        System.out.println(text.contains("Delete")? "Delete button is displayed": "Delete button is not displayed" );



    }
}
