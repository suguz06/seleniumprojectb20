package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {


    public static void loginToSmartBear(WebDriver driver){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        //4. Enter password: “test”
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        //5. Click to Login button
        driver.findElement(By.className("button")).click();

    }



    //PRACTICE #4: Method: verifyOrder•
    // Create a method named verifyOrderin SmartBearUtils class.
    // •Methodtakes WebDriver object and String(name).
    // •Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String),
    // and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working
    // as expected
public static void verifyOrder(WebDriver driver, String name){

//create locator returns of all names

    List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

    //if there is one table => use //tr/td[2]
    // ==>>   List<WebElement> nameList = driver.findElements(By.xpath("//tr/td[2]"));

    //to create=> use iter+Enter or TAB
    for (WebElement each : nameList) {
        if(each.getText().equals(name)){ // each is a webElement=> each.getText() is a String
            Assert.assertTrue(true);
            return;// break=> exit the block => return=> exit the method
        }
    }
    //Assert fail method will fail the test when it is called, no matter what
    Assert.fail("Name "+ name +" does not exist in the list! Verification is FAILED!!!");
  //  Assert.assertFalse(false);


}

//table[@id='ctl00_MainContent_orderGrid']//tr/td[7] => cities

    //table[@id='ctl00_MainContent_orderGrid']//tr/td[2] => names

/*
Practice #5: Method: printNamesAndCities
•Create a method named printNamesAndCitiesin SmartBearUtils class.
•Method takes WebDriver object.
•This method should simply print all the names in the List of All Orders.
•Create a new TestNG test to test if the method is working as expected.
•Output should be like:•Name1: name , City1: city•Name2: name , City2: city
 */

public static void printNamesAndCities(WebDriver driver){

    List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));
    List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));


    for (int i = 0; i <namesList.size() ; i++) {
        System.out.println("Name"+(i+1)+": " +namesList.get(i).getText() +" City" +(i+1)+": "+citiesList.get(i).getText() );

    }




}



}


