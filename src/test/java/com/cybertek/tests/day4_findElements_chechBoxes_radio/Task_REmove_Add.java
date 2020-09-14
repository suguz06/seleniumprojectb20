package com.cybertek.tests.day4_findElements_chechBoxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_REmove_Add {

    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        WebElement clickAddElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        Thread.sleep(2000);
        clickAddElementButton.click();


        WebElement deleteButtonTest = driver.findElement(By.cssSelector("button.added-manually"));
        String actualDeleteButtonTest = deleteButtonTest.getText();
        if(deleteButtonTest.isDisplayed()){
            System.out.println("Delete button verification PASSED");
        }else {
            System.out.println("Delete button verification FAILED");
        }
        System.out.println("================================");
        Thread.sleep(2000);

        WebElement clickDeleteButton = driver.findElement(By.cssSelector("button.added-manually"));
        clickDeleteButton.click();
        //WebElement deleteButtonTest2 = driver.findElement(By.cssSelector("button.added-manually"));
        //String actualDeleteButtonTest2 = deleteButtonTest2.getText();\
        try{
            if(!deleteButtonTest.isDisplayed()){
                System.out.println("Delete button verification PASSED");
            }else {
                System.out.println("Delete button verification FAILED");
            }
        }catch (StaleElementReferenceException error){
            actualDeleteButtonTest = error.getMessage();
            System.out.println("Negative Delete button verification PASSED");
        }
} }
