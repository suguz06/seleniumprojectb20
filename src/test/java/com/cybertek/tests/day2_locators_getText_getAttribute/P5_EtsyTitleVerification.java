package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsyTitleVerification {

    public static void main(String[] args) {
 //TC #5: EtsyTitle Verification
        // 1.Open Chrome browser
        // 2.Go to https://www.etsy.com
        // 3.Search for “wooden spoon”
        // 4.Verify title:
        //
        // Expected: “Wooden spoon | Etsy”

        WebDriverManager.chromedriver().setup();
// 1.Open Chrome browser
        WebDriver driver=new ChromeDriver();
        // 2.Go to https://www.etsy.com
        driver.get("https://etsy.com");

        // 3.Search for “wooden spoon”

        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon"+ Keys.ENTER);

        // 4.Verify title:
        //
        // Expected: “Wooden spoon | Etsy”
   String actualTitle=driver.getTitle();
   String expectedTitle="Wooden spoon | Etsy";

   if(actualTitle.equals(expectedTitle)) {
       System.out.println("ETSY title verification PASSED");
   } else {
       System.out.println("FAILDED");
   }

    }
}
