package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test2 {

    public static void main(String[] args)throws InterruptedException  {
        WebDriverManager.chromedriver().setup();
        WebDriver driverChrome= new ChromeDriver();
        driverChrome.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
       /* String teamLeadLogin= "jalabaster7f@drupal.org";
        String TLpassword="terimapam";

        */
        String studentLogin = "sdarben7g@alibaba.com";
        String studentPassword= "angiecoatham";
/*
        String teacherLogin = "teachervasctoforstall@gmail.com";
        String teacherPassword = "scottforstall";

 */
        driverChrome.findElement(By.className("input ng-pristine ng-invalid ng-touched") ).sendKeys(studentLogin);
        driverChrome.findElement(By.name("password")).sendKeys(studentPassword + Keys.ENTER);
     /*   driverChrome.navigate().back();
        driverChrome.findElement(By.name("email") ).sendKeys(teacherLogin);
        driverChrome.findElement(By.name("password")).sendKeys(teacherPassword + Keys.ENTER);
      */
        String expectedTitle = "bookit";
        String actualTitle = driverChrome.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Student Login: PASSED");
        }else{
            System.out.println("Student Login: Failed");
        }

    } }
