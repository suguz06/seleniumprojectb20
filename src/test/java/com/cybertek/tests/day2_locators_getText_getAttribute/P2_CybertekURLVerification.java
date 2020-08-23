package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURLVerification {

    public static void main(String[] args) {



        /*

           	#2:	Cybertek	verifications
           	1.Open	Chrome	browser
           	2.Go	to	https://practice.cybertekschool.com
           	3.Verify	URL	containsExpected:	cybertekschool
           	4.Verify	title:
           	Expected:	Practice
         */


        WebDriverManager.chromedriver().setup();

       // 1.Open	Chrome	browser
        WebDriver driver=new ChromeDriver();
        //maximize page
        driver.manage().window().maximize();

   String url="http://practice.cybertekschool.com";

//	2.Go	to	https://practice.cybertekschool.com
   driver.get(url);



String expectedUrl="cybertekschool";
String actualUrl=driver.getCurrentUrl();

        System.out.println("actualUrl = " + actualUrl);


        //	3.Verify	URL	containsExpected:	cybertekschool
        if(actualUrl.contains(expectedUrl)) {
            System.out.println("URL Verification Passed");
        } else {
            System.out.println("URLVerification FAILED");
        }

//	4.Verify	title:
//           	Expected:	Practice

        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification: PASSED");
        }else {
            System.out.println("Title verification: FAILED");
        }
        System.out.println(actualTitle.equals("Practice")? "title verification passed" : "Title verification failed");

    }}
