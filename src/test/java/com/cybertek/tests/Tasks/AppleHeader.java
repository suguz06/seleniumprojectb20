package com.cybertek.tests.Tasks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppleHeader {
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

        //Creating counters: emptyLinks, and links with text
        int emptyLinkCounter = 0;
        int linksWithText = 0;
        Thread.sleep(5000);
        //3. Click to all of the headers one by one
        // a. Mac, iPad, iPhone, Watch, TV, Music, Support

        //Creating List of WebElements to store all the links in the header list.

        // driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));

        List<WebElement> headersLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        //The loop where we specify where to start from and where to end in appleHeader List.

        for (int i = 1; i < 8; i++) {
            headersLinks.get(i).click();


            Thread.sleep(1000);


            List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

            System.out.println("Number of links on page: " + driver.getTitle() + " " + listOfLinks.size());

            for (WebElement link : listOfLinks) {
                String textOfLink = link.getText();
                if (!textOfLink.isEmpty()) {
                    linksWithText++;
                } else {
                    emptyLinkCounter++;
                }
            }
            driver.navigate().back();

            headersLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']/li/a"));
        }
        System.out.println("Number of EmptyLinks: \t" + emptyLinkCounter);
        System.out.println("Number of Links with text: \t" + linksWithText);

    }
}





