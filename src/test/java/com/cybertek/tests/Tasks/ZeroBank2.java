package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank2 {
/*
TC #2: Zero Bank link text verification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Verify link text from top left:Expected: “Zero Bank”
4.Verify link hrefattribute value contains:Expected: “index.html”
 */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        String actualLinkText=driver.findElement(By.linkText("Zero Bank")).getText();

        String ecpectedLinkText="Zero Bank";

        System.out.println(actualLinkText.equalsIgnoreCase(ecpectedLinkText)? "PASSED": "FAILED");

        String actualHrefAttribute= driver.findElement(By.linkText("Zero Bank")).getAttribute("href");

        String expectedHrefAttribute="index.html";

        System.out.println(actualHrefAttribute.contains(expectedHrefAttribute)? "PASSED": "FAILED");
    }
}
