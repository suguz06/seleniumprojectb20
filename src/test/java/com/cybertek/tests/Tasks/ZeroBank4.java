package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank4 {
/*

C #4: Zero Bank login title verification1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Enter username: username
4.Enter password: password
5.Click to “Account Activity” link
6.Verify title changed to:Expected: “Zero –Account Activity”
7.Click to “Transfer Funds” link
8.Verify title changed to:Expected: “Zero –Transfer Funds”
9.Click to “Pay Bills” link
10.Verify title changed to:Expected: “Zero -Pay Bills”
11.Click to “My Money Map” link
12.Verify title changed to:Expected: “Zero –My Money Map”
13.Click to “Online Statements” link
14.Verify title changed to:Expected: “Zero –Online Statements”
 */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password"+ Keys.ENTER);

        Thread.sleep(3000);
       //1
        driver.findElement(By.linkText("Account Activity")).click();

        String actualTitle=driver.getTitle();
        String expectedTitle="Zero - Account Activity";

        System.out.println(actualTitle.equalsIgnoreCase(expectedTitle)?"PASSED":"FAILED");

        Thread.sleep(3000);
      //2
        driver.findElement(By.linkText("Transfer Funds")).click();

        String actualTitle1=driver.getTitle();
        String expectedTitle1="Zero - Transfer Funds";

        System.out.println(actualTitle1.equalsIgnoreCase(expectedTitle1)?"PASSED":"FAILED");
        Thread.sleep(3000);
//3

        driver.findElement(By.linkText("Pay Bills")).click();

        String actualTitle2=driver.getTitle();
        String expectedTitle2="Zero - Pay Bills";

        System.out.println(actualTitle2.equalsIgnoreCase(expectedTitle2)?"PASSED":"FAILED");
        Thread.sleep(3000);
//4
        driver.findElement(By.linkText("My Money Map")).click();

        String actualTitle3=driver.getTitle();
        String expectedTitle3="Zero - My Money Map";

        System.out.println(actualTitle3.equalsIgnoreCase(expectedTitle3)?"PASSED":"FAILED");

Thread.sleep(3000);
        //5
        driver.findElement(By.linkText("Online Statements")).click();

        String actualTitle4=driver.getTitle();
        String expectedTitle4="Zero - Online Statements";

        System.out.println(actualTitle4.equalsIgnoreCase(expectedTitle4)?"PASSED":"FAILED");

    }
}
