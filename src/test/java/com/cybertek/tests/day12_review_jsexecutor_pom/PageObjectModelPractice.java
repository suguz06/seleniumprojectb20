package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractice {

    LoginPage loginPage;

    @Test
    public void login_to_smartbear() {

        LoginPage loginPage = new LoginPage();
        //get url => smartbear
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");


        loginPage.userNameInput.sendKeys("Tester");
        loginPage.passwordInput.sendKeys("test");
        loginPage.loginButton.click();
        Driver.getDriver().navigate().back();
    }
}
