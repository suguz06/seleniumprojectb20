package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearch {

    public static void main(String[] args) {

/*
TC#4:	Google	search
1-Open	a	chrome	browser
2-Go	to:	https://google.com
3-Write	“apple”	in	search	box
4-Click	google	search	button
5-Verify	title:
Expected:	Title	should	start	with 	“apple”“ word
 */


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

//2 Go	to:	https://google.com

        driver.get("https://google.com");

       // 3-Write	“apple”	in	search	box
        driver.findElement(By.name("q")).sendKeys("Apple" + Keys.ENTER);

      //4-Click	google	search	button


        String expectedTitle="Apple - Google Search";
        String actualTitle=driver.getTitle();
        //5-Verify	title:
        //Expected:	Title	should	start	with 	“apple”“ word
        if(actualTitle.startsWith("Apple")) {
            System.out.println("Search Title verification PASSED");
        }else{
            System.out.println("Search Title verification FAILED!");
        }
    }
}
