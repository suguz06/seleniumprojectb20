package com.cybertek.tests.JiraAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Vytrack {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();


        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user167");
        driver.findElement(By.id("prependedInput2")).sendKeys("wrongpassword");
        driver.findElement(By.className("custom-checkbox__text")).click();
        driver.findElement(By.id("_submit")).click();
    }
}
