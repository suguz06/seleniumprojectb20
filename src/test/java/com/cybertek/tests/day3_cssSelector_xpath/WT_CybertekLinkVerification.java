package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: PracticeCybertek/ForgotPassword URL verification
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/forgot_password
3.Enter any email into input box
4.Click on Retrieve password
5.Verify URL contains: Expected: “email_sent”
6.Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”
Hint: You need to use getText method for this practice
 */
public class WT_CybertekLinkVerification {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3.Enter any email into input box
        WebElement email = driver.findElement(By.name("email"));

        email.sendKeys("sss@sss.com");

        //4.Click on Retrieve password

       // driver.findElement(By.id("form_submit")).click(); OR using WebElement class name
        WebElement form_submit = driver.findElement(By.id("form_submit"));
        form_submit.click();

        // 5 Verify URL contains: Expected: “email_sent”


        System.out.println(driver.getCurrentUrl().contains("email_sent")? "PASSED" : "FALSE"  );

    //verify textbox displayed the content as expected.
        //Expected: “Your e-mail’s been sent!”

String expected="Your e-mail's been sent!";
        String confirmation_message = driver.findElement(By.name("confirmation_message")).getText();

        WebElement confirmation_message1 = driver.findElement(By.name("confirmation_message"));
      // ctrl+D => to copy several times
        //  WebElement confirmation_message1 = driver.findElement(By.name("confirmation_message"));
       // WebElement confirmation_message1 = driver.findElement(By.name("confirmation_message"));
       // WebElement confirmation_message1 = driver.findElement(By.name("confirmation_message"));

        System.out.println(expected.equals(confirmation_message)? "PASSED message": "FAILED message");

  //verify if the web element
        System.out.println(driver.findElement(By.name("confirmation_message")).isDisplayed());

// OR

        if (confirmation_message1.isDisplayed()){
            System.out.println("PASSED confirmation message");
        } else {
            System.out.println("FAILED confirmation message");
        }

    }
}
