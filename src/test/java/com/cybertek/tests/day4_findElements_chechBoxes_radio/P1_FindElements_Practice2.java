package com.cybertek.tests.day4_findElements_chechBoxes_radio;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P1_FindElements_Practice2 {
/*
TC #0: FINDELEMENTS1.Open Chrome browser
2.Go to https://www.merriam-webster.com/
3.Print out the texts of all links
4.Print out how many link is missing text
5.Print out how many link has text
6.Print out how many total link
 */
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
   //driver.manage().window().maximize();

        driver.get("https://www.merriam-webster.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3.Print out the texts of all links

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

for (WebElement eachLink: listOfLinks)   {
    System.out.println(eachLink.getText());
}


//       int c=0;
//        for (WebElement eachLink: listOfLinks)   {
//             if(!eachLink.isDisplayed()) c++;
//        }
//        System.out.println("c = " + c);


        //4.Print out how many link is missing text

               int c=0;
        for (WebElement eachLink: listOfLinks)   {
             if(eachLink.getText().equals("")) c++;
        }
        System.out.println("c = " + c);

        //OR

        int linksWithoutText=0;
        int linksWithText=0;

        for (WebElement eachLink: listOfLinks) {
            String textOfEachLink=eachLink.getText();
            System.out.println(textOfEachLink);

            if(textOfEachLink.isEmpty()) {
                linksWithoutText++;
            } else {
                linksWithText++;
            }

        }

        System.out.println("linksWithoutText = " + linksWithoutText);
        System.out.println("linksWithText = " + linksWithText);

        System.out.println("listOfLinks.size() = " + listOfLinks.size());

    }
}
