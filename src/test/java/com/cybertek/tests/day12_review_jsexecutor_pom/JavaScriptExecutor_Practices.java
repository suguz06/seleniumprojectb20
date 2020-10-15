package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practices {


    @Test
    public void  scroll_using_jsexecutor1(){
//get the page scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //create an instance of JSExecutor and (down) cast our driver to it
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        //now we use 2 methods

        //scroll by 1000


        for (int i = 0; i < 10; i++) {
            BrowserUtil.wait(2);
            js.executeScript("window.scrollBy(0,10000)" );

            BrowserUtil.wait(2);

            js.executeScript("window.scrollBy(0,-10000)" );

        }



    }


    @Test
    public void  scroll_using_jsexecutor2(){

        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //create an instance of JSExecutor and cast our driver to it
      //down casting to reach methods in jsExecutor
       // JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();


        //locate where to go link
        WebElement cybertek = Driver.getDriver().findElement(By.partialLinkText("Cybertek"));

        WebElement homeLink = Driver.getDriver().findElement(By.partialLinkText("Home"));


//use js executor to scroll 'Cybertek School' link intoView

        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

//use scrollIntoView function from JS to scroll to a specific web element


        BrowserUtil.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true);", cybertek);


        BrowserUtil.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true);", homeLink);

        BrowserUtil.wait(2);
        js.executeScript("window.scrollBy(500,0)" );


        BrowserUtil.wait(2);
        js.executeScript("window.scrollBy(500,500)" );


    }

    @Test
    public void fill_form_using_javascript(){

        Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");

        WebElement usernameInput = Driver.getDriver().findElement(By.name("full_name"));
        WebElement  emailInput = Driver.getDriver().findElement(By.name("email"));
        WebElement  signUpButton = Driver.getDriver().findElement(By.name("wooden_spoon"));

        BrowserUtil.wait(2);


        //alternative way to SENDKEYS => using JS EXECUTOR
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].setAttribute('value', 'Jane Doe')"    , usernameInput);

        BrowserUtil.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'JaneDoe@com.com')"    , emailInput);


        // click by using JavaScript function
        js.executeScript("arguments[0].click()"    , signUpButton);



    }





}
