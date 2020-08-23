package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerificaton {

    public static void main(String[] args) {
/*
TC	#1:	Google	Title	Verification
1.Open	Chrome	browser
2.Go	to
https://www.google.com
3.Verify	title:	Expected:	Goo
 */

        //System.setProperty("")
        WebDriverManager.chromedriver().setup();

        //1.Open	Chrome	browser
        WebDriver driver = new ChromeDriver();

        // 2.Go	to https://www.google.com

        driver.get("https://www.google.com");

        //3.Verify	title:	Expected:	Goo

        System.out.println(driver.getTitle());

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is PASSED!");
        }
       else{
        System.out.println("Title verification is FAILED!"); }

}
}
