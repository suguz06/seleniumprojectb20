package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractices {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    /*
    1. Open browser
    2. Go to website: http://practice.cybertekschool.com/dropdowns
    3. Verify default value is always showing the current month
    o Expected: If currently in June, should show June selected.

     */
    @Test
    public void p7_month_dropdown_default_value_test() {

        Select month = new Select(driver.findElement(By.id("month")));

        String expected = "September"; // it will change=> static value=> next month it gives error
        String monthName = LocalDateTime.now().getMonth().name(); // we need to dynamic value to work every time
        System.out.println(monthName); //SEPTEMBER

        String actualMonth = month.getFirstSelectedOption().getText();


        //assert toLowerCase
        Assert.assertEquals(actualMonth.toLowerCase(), monthName.toLowerCase());

        //OR equalIgnoreCase
        Assert.assertTrue(actualMonth.equalsIgnoreCase(monthName));



   //TASK 8
//this line gets all of the options from Selct dropdown and store in a list
        List<WebElement> actualMonthList = month.getOptions();


//        //create a new  list string of months => store of all text of months
//
//        List<String> actualMonthsText=new ArrayList<>();
//
//        for (WebElement element : actualMonthList) {
//            actualMonthsText.add(element.getText());
//
//        }

        List<String> actualMonthsText = BrowserUtil.getElementsText(actualMonthList);


        // list of expected

        List<String> expectedMonthList= Arrays.asList("January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December");

//passing List of assertions
        //First it will check size=> second check values


         Assert.assertEquals(actualMonthsText, expectedMonthList);
//note=> both should be strings=> one is webElement the other String give an error

// OR

        Assert.assertEquals(BrowserUtil.getElementsText(actualMonthList), expectedMonthList);

BrowserUtil.wait(2);




//        for (WebElement element : actualMonthList) {
//            System.out.println("element.getText() = " + element.getText());
//        }
//
//        Assert.assertTrue(actualMonthList.size()==12);



    }

}
