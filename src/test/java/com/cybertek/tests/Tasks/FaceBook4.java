package com.cybertek.tests.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBook4 {
    public static void main(String[] args) {

//TC #4: Facebook header verification1.Open Chrome browser
// 2.Go to https://www.facebook.com
// 3.Verify “Create a page” link href value contains text:
// Expected: “registration_form”
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com");

        String actualText=driver.findElement(By.linkText("Create a Page")).getAttribute("href");
        String expectedText="registration_form";

        System.out.println(actualText.contains(expectedText)? "PASSED": "FAILED");

    }
}


