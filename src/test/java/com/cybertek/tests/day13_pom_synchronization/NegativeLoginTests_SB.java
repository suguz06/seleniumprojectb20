package com.cybertek.tests.day13_pom_synchronization;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests_SB {

LoginPage loginPage;

    @Test (description = "entering incorrect username")
    public void negative_login_test1() {

       // Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//        String smartbearUrl = ConfigurationReader.getProperty("smartbearUrl");
//        Driver.getDriver().get(smartbearUrl);
        //OR

        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearUrl"));

//Lets start using PageObjectModel

        //#1 We need to  create the object of class we want to use
     //instantiate here
      loginPage = new LoginPage();

//#2 call the object  to use the web elements
       //entering incorrect username
        loginPage.userNameInput.sendKeys("aaa");

        //enter correct password
        String smartbear_password = ConfigurationReader.getProperty("smartbear_password");
        loginPage.passwordInput.sendKeys(smartbear_password);

        loginPage.loginButton.click();
        loginPage.errorMessage.isDisplayed();

        //assert true that error message is displayed on the page
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed, Verification is FAILED!!!");
        BrowserUtil.wait(3);

    }



    @Test (description = "entering incorrect password")
    public void negative_login_test2() {

     loginPage = new LoginPage();
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

//correct user name
        String smartbear_username = ConfigurationReader.getProperty("smartbear_username");
        loginPage.userNameInput.sendKeys(smartbear_username);
        loginPage.passwordInput.sendKeys("aa");

        loginPage.loginButton.click();
        loginPage.errorMessage.isDisplayed();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        BrowserUtil.wait(3);


    }

    @Test (description = "using login method for  test")
    public void negative_login_test3() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

         loginPage = new LoginPage();

        String smartbear_username = ConfigurationReader.getProperty("smartbear_username");

        String smartbear_password = ConfigurationReader.getProperty("smartbear_password");

        //call the method by using the object
        loginPage.login(smartbear_username,smartbear_password);
       // Assert.assertTrue(!loginPage.errorMessage.isDisplayed());

    }


    @Test (description = "using login method for negative test: wrong user name")
    public void negative_login_test4() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        loginPage = new LoginPage();

        String  username = "wrong user name";

        String smartbear_password = ConfigurationReader.getProperty("smartbear_password");

        //call the method by using the object
        loginPage.login(username,smartbear_password);

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }

}
