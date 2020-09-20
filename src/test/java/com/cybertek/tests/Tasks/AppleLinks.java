package com.cybertek.tests.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppleLinks {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com/");
    }


    @Test
    public void testApple() throws InterruptedException {

        //TC #02: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        //2. Go to https://www.apple.com
        //3. Click to iPhone


        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[4]/a")).click();
        //  driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']")).click();

        //4. Print out the texts of all links
        List<WebElement> linksList = driver.findElements(By.xpath("//body//a"));

        for (WebElement each : linksList) {
            System.out.println(each.getText());
        }

        //5. Print out how many link is missing text
        int linkEmptyText = 0;
        int linkText = 0;

        for (WebElement each : linksList) {
            if (each.getText().isEmpty()) {
                linkEmptyText++;
            } else {
                linkText++;
            }
        }
        System.out.println("Number of Missing text links: "+ linkEmptyText);


        //6. Print out how many link has text
        System.out.println("Number of text links: "+ linkText);

        //7. Print out how many total link
        System.out.println("Total links: "+ linksList.size());

    }


}
