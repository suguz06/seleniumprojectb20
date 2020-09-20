package com.cybertek.tests.day5_testNG_intro_dropdowns.DropDownTask;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
TC #2: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */
public class Task1 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");


    }

    @Test
    public void selectOptions() throws InterruptedException {
//        3. Select Illinois
//        4. Select Virginia
//        5. Select California
//        6. Verify final selected option is California.

        Select select = new Select(driver.findElement(By.id("state")));

        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("TX");
        Thread.sleep(3000);
        select.selectByVisibleText("Illinois");
        Thread.sleep(3000);
        select.selectByVisibleText("Virginia");
        Thread.sleep(3000);
        select.selectByVisibleText("California");

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "California");


    }

    @Test
    public void selectDate() {

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1921");
        selectMonth.selectByValue("11");
        selectDay.selectByIndex(0);
//
//            3. Select “December 1st, 1921” and verify it is selected.
//    Select year using : visible text
//    Select month using : value attribute
//    Select day using : index number
        String day = selectDay.getFirstSelectedOption().getText();
        String month = selectMonth.getFirstSelectedOption().getText();
        String year = selectYear.getFirstSelectedOption().getText();
        Assert.assertEquals(day, "1");
        Assert.assertEquals(month, "December");
        Assert.assertEquals(year, "1921");


    }



    @Test
    public void allOptions() throws InterruptedException {
//        3. Select all the options from multiple select dropdown.
//        4. Print out all selected values.
//        5. Deselect all values.
Thread.sleep(5000);
        Select selectSimple=new Select(driver.findElement(By.id("dropdown")));

        System.out.println(selectSimple.getFirstSelectedOption().getText());

         Select selectYear=new Select(driver.findElement(By.id("year")));
//        Select selectMonth = new Select(driver.findElement(By.id("month")));
//        Select selectDay = new Select(driver.findElement(By.id("day")));
//        Select selectState = new Select(driver.findElement(By.id("state")));
//        Select selectLanguages = new Select(driver.findElement(By.id("Languages")));

        List<WebElement> selectSimpleOptions = selectSimple.getOptions();
        for (WebElement e: selectSimpleOptions) {
            System.out.println("e.getText() = " + e.getText());
        }
        Thread.sleep(5000);
        List<WebElement> selectYearOptions = selectYear.getOptions();

        for (WebElement e: selectYearOptions) {
            System.out.println(e.getText());
        }

        System.out.println(selectSimple.getFirstSelectedOption().getText());

    }

    @Test

    public void nonSelect() throws InterruptedException {



        //3. Click to non-select dropdown

        Thread.sleep(3000);
        driver.findElement( By.id("dropdownMenuLink")).click();
        //4. Select Facebook from dropdown
        driver.findElement(By.partialLinkText("Facebook")).click();
        //5. Verify title is “Facebook - Log In or Sign Up”

        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");


    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
