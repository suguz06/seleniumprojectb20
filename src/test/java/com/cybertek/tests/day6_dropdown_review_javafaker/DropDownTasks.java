package com.cybertek.tests.day6_dropdown_review_javafaker;

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

public class DropDownTasks {

    WebDriver driver;


//    @BeforeClass // for one page test=> open one times
//    public void setupClass(){
//        driver = WebDriverFactory.getDriver("chrome");
//
//    }

    @BeforeMethod
    public void setupMethod() {
        //open new browser
         driver = WebDriverFactory.getDriver("chrome");
        //maximaze page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
// get the page

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    /*
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Select Illinois
    4. Select Virginia
    5. Select California
    6. Verify final selected option is California.
    Use all Select options. (visible text, value, index)
     */
    @Test
    public void selectStates() throws InterruptedException  {


        //locate select object <select tag pace first=> then create to handle

        //NOTE ==>> Select object comes SELENIUM => NOT APACHE
        Select select = new Select(driver.findElement(By.id("state")));
        //or xpath=> //select[@id='state']
        select.selectByVisibleText("Illinois");
        //stateSelection.selectByValue("IL");
        //stateSelection.selectByIndex(14);

        Thread.sleep(2000);
        select.selectByVisibleText("Virginia");
        //select.selectByValue("VI")

        Thread.sleep(2000);
        select.selectByVisibleText("California");
        //select.selectByIndex(5);

        Thread.sleep(2000);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "California", "Actual vs expected result is not equal!");

    }


    @Test
    public void test3() throws InterruptedException {

//3. Select “December 1st, 1921” and verify it is selected.
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        //Select year using : visible text
//Select month using : value attribute
//Select day using : index number

        selectYear.selectByVisibleText("1921");
        Thread.sleep(2000);
        Assert.assertEquals(selectYear.getFirstSelectedOption().getText(), "1921");

        selectMonth.selectByValue("11");
        Thread.sleep(2000);
        Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), "December");

        selectDay.selectByIndex(0);
        Thread.sleep(2000);
        Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), "1");



    }


    @Test
    public void method4_allOptionsPrint(){

Select simpleDropdown=new Select(driver.findElement(By.id("dropdown")));

        List<WebElement> simpleDropdownOptions = simpleDropdown.getOptions();
        for (WebElement each: simpleDropdownOptions) {
            System.out.println(each.getText());
        }

        Select selectYear = new Select(driver.findElement(By.id("year")));

        List<WebElement> selectYearOptions = selectYear.getOptions();
        for (WebElement each: selectYearOptions) {
            System.out.println(each.getText());
        }
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        List<WebElement> selectMonthOptions = selectMonth.getOptions();
        for (WebElement each: selectMonthOptions) {
            System.out.println(each.getText());
        }

        Select selectDay = new Select(driver.findElement(By.id("day")));
        List<WebElement> selectDayOptions = selectDay.getOptions();
        for (WebElement each: selectDayOptions) {
            System.out.println(each.getText());
        }

        Select selectStates = new Select(driver.findElement(By.id("state")));
        List<WebElement> selectStatesOptions = selectStates.getOptions();
        for (WebElement each: selectStatesOptions) {
            System.out.println(each.getText());
        }

Select selectLanguages=new Select( driver.findElement(By.name("Languages")));
        List<WebElement> selectLanguagesOptions = selectLanguages.getOptions();
        for (WebElement each: selectLanguagesOptions) {
            System.out.println(each.getText());
        }


    }


    @Test
    public void multipleOptions(){
        //check Languages multiple options to click by one -one=: this is the way select all way

        Select multipleSelectDropdown=new Select(driver.findElement(By.name("Languages")));

        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

   for (WebElement each: allOptions) {
       each.click(); //this will click each options with every iteration


       //print selected all options
       System.out.println("Selected: "+ each.getText());

       //Assert option is actually selected or not]
       Assert.assertTrue(each.isSelected(), "not selected option");


   }
// getAllSelOption==> just refer to selected multiple option places
        List<WebElement> allSelectedOptions = multipleSelectDropdown.getAllSelectedOptions();
for (WebElement each: allSelectedOptions){
    System.out.println(each.getText());
}



//DESELECT ALL

        multipleSelectDropdown.deselectAll();

for (WebElement each: allOptions) {
    Assert.assertTrue(!each.isSelected()); // return true assertion =>if it is passed testt
    Assert.assertFalse(each.isSelected());//return false is passed testt
}


    }



    @Test
    public void test5() throws InterruptedException {
//TC #5: Selecting value from non-select dropdown

//3. Click to non-select dropdown
WebElement dropdownLink=driver.findElement(By.id("dropdownMenuLink"));
dropdownLink.click();
Thread.sleep(2000);

WebElement facebookLink=driver.findElement(By.xpath("//a[.='Facebook']"));

facebookLink.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up", "Verify title is not same");


//4. Select Facebook from dropdown
//5. Verify title is “Facebook - Log In or Sign Up”

    }



    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
