package com.cybertek.tests.day4_findElements_chechBoxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/*
Practice:	Cybertek	Checkboxes
1.Go	to	http://practice.cybertekschool.com/checkboxes
2.Confirm	checkbox	#1	is	NOT	selected	by	default
3.Confirm	checkbox	#2	is	SELECTED	by	default.
4.Click	checkbox	#1	to	select	it.
5.Click	checkbox	#2	to	deselect	it.
6.Confirm	checkbox	#1	is	SELECTED.
7.Confirm	checkbox	#2	is	NOT
 */
public class P3_CheckedBox_Practice {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");


        WebElement checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        //2.Confirm	checkbox	#1	is	NOT	selected	by	default
        if (!checkBox1.isSelected()) {
            System.out.println("Checkbox is not selected. Verification is PASSED!");
        } else {
            System.out.println("Checkbox is   selected. Verification is FAILED!!!");
        }

//3.Confirm	checkbox	#2	is	SELECTED	by	default.
        if (checkBox2.isSelected()) {
            System.out.println("Checkbox is   selected. Verification is PASSED!");
        } else {
            System.out.println("Checkbox is  not selected. Verification is FAILED!!!");
        }


//4.Click	checkbox	#1	to	select	it.
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        checkBox1.click();


//5.Click	checkbox	#2	to	deselect	it.
        Thread.sleep(1000);
        checkBox2.click();


//6.Confirm	checkbox	#1	is	SELECTED.
        if (checkBox1.isSelected()) {
            System.out.println("Checkbox is   selected. Verification is PASSED!");
        } else {
            System.out.println("Checkbox is  not selected. Verification is FAILED!!!");
        }


//7.Confirm	checkbox	#2	is	NOT

        if (!checkBox2.isSelected()) {
            System.out.println("Checkbox is  not selected. Verification is PASSED!");
        } else {
            System.out.println("Checkbox is    selected. Verification is FAILED!!!");
        }


        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));

        homeLink.click();

        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

// after navigations ==> loose connection between driver ==> then refresh the locators
 checkBox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        checkBox1.click();


    }
}
