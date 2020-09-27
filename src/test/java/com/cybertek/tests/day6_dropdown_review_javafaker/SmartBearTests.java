package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void loginToSmartBear1() {

//        //3. Enter username: “Tester”
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//
//        //4. Enter password: “test”
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//        //5. Click to Login button
//        driver.findElement(By.className("button")).click();

        //6. Print out count of all the links on landing page
        List<WebElement> webElementList = driver.findElements(By.xpath("//body//a"));
        System.out.println("webElementList.size() = " + webElementList.size());


        //7. Print out each link text on this page
        for (WebElement each : webElementList) {
            System.out.println("each.getText() = " + each.getText());
        }

    }


    @Test
    public void orderPlacing() {

//TC#2: Smartbear software order placing
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click on Login button
//        //3. Enter username: “Tester”
//        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//
//        //4. Enter password: “test”
//        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//        //5. Click to Login button
//        driver.findElement(By.className("button")).click();


//6. Click on Order
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
//7. Select familyAlbum from product,
// set quantity to 2

        Select select = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByVisibleText("FamilyAlbum");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
//8. Click to “Calculate” button

        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
//9. Fill address Info with JavaFaker




//• Generate: name, street, city, state, zip code

        Faker faker=new Faker();
        String name = faker.name().fullName();

        String streetAddress = faker.address().streetAddress();

        String city = faker.address().city();
        String state = faker.address().state();

        String zipCode = faker.address().zipCode().replace("-", "");
driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(streetAddress);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys( state);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);

//10.Click on “visa” radio button

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

//11.Generate card number using JavaFaker
        String creditCard = faker.finance().creditCard().replaceAll("-", ""); // for dash=> replace or substring method
        System.out.println(creditCard);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(creditCard);

        //also enter expiredyate 12/20

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/20");

//12.Click on “Process”
        driver.findElement(By.className("btn_light")).click();


//13.Verify success message “New order has been successfully added.”

String message="New order has been successfully added.";


        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText(), message);
    }


    @Test
    public void test() throws InterruptedException {

        Thread.sleep(2000);

        SmartBearUtilities.verifyOrder(driver, "Paul Brow");


    }

//    @AfterMethod
//    public void teardownMethod() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.close();
//    }


}
