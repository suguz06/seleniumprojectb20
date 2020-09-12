package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
  TC #2: Zero Bank link text verification1.Open Chrome browser
  2.Go to http://zero.webappsecurity.com/login.html
  3.Verify link text from top left:Expected: “Zero Bank”
  4.
Verify link hrefattribute value contains:Expected: “index.html”
 */
public class P2_ZeroBankVerification {

    public static void main(String[] args) {

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver=new ChromeDriver(); //OR by using utilities class

        WebDriver driver = WebDriverFactory.getDriver("chrome");


        driver.get("http://zero.webappsecurity.com/login.html");
   //Verify link text from top left:Expected: “Zero Bank”

        WebElement zero_bank = driver.findElement(By.linkText("Zero Bank"));
        String zero_bankText = zero_bank.getText();

        System.out.println(zero_bankText.equals("Zero Bank")? "PASSED" :" FAILED");
        System.out.println(driver.findElement(By.linkText("Zero Bank")).getAttribute("href"));



//        4.
//        Verify link hrefattribute value contains:Expected: “index.html”
//
//
        String expected="index.html";
        String zero_bankAttribute = zero_bank.getAttribute("href");

        System.out.println(zero_bankAttribute.contains(expected)? "PASSED": "FAILED");


    }
}
