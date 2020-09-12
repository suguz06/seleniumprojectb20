package com.cybertek.tests.day4_findElements_chechBoxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed.
Better if you do with both XPATH and CSS selector for practice purposes
 */
public class P1_CybeertekForgotPassword {

    public static void main(String[] args) {

        WebDriver driver=WebDriverFactory.getDriver("chrome");

   driver.get("http://practice.cybertekschool.com/forgot_password");

/*
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
 */
   // home=> Xpath=> //a[@class='nav-link'] or  //a[.='Home']
        // or //a[contains(@class,'nav')] or //a[@href='/']

        WebElement homeLink=driver.findElement(By.xpath("//a[@class='nav-link']"));
       // System.out.println(homeLink.isDisplayed());


        ////h2[.='Forgot Password']  or //h2[contains(text(),'Forgot Password')]
        WebElement header= driver.findElement(By.xpath("//h2[.='Forgot Password']"));

   WebElement email=driver.findElement(By.xpath("//label[@for='email']"));


   // //div[@class='large-6 small-12 columns']/input
   WebElement emailInput=driver.findElement(By.xpath("//input[@name='email']"));


      //  e. “Retrieve password” button
// => cssSelcetor=> button#form_submit  or button.radius  or button[id='form_submit'] or button[class='radius']

WebElement retrievePassword=driver.findElement(By.cssSelector("button#form_submit"));



// f. “Powered by Cybertek School” text


        // //a[.='Cybertek School']

        WebElement linkText=driver.findElement(By.xpath("//a[.='Cybertek School']"));

        WebElement poweredText=driver.findElement(By.xpath("//div[@style='text-align: center;']"));



        System.out.println("linkText = " + linkText.getText());
        System.out.println("poweredText = " + poweredText.getText());


   //4. Verify all WebElements are displayed.

   if (homeLink.isDisplayed()) {
       System.out.println(homeLink.getText() + " is displayed");
   } else System.out.println(homeLink.getText()+ " is not displayed");

   //OR write all in one if condition

        if(homeLink.isDisplayed() && emailInput.isDisplayed()
                && header.isDisplayed()&& email.isDisplayed()&&linkText.isDisplayed()
        &&poweredText.isDisplayed()&&retrievePassword.isDisplayed()) {
            System.out.println("All is displayed");
        }

    }
}
