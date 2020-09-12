package com.cybertek.tests.day3_cssSelector_xpath;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
CSSPracticeDO NOT USE ANY DEVELOPER TOOLS TO GET
ANY LOCATORS.TC #3: Amazon link number verification
1. Open Chrome browser
2. Go to https://www.amazon.com
3.
Enter search term (use cssSelectorto locate search box)
4. Verify title contains search term
 */
public class P3_Amazon_cssSelector {


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

driver.get("https://www.amazon.com");

// first syntax=> css====>>   tagName[attribute='attributevalue']
      //  WebElement searchElement = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
       //searchElement.sendKeys("wood"+ Keys.ENTER);


// 2nd syntax==>>   input.nav-input or  input#twotabsearchtextbox
        WebElement searchElement1 = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        searchElement1.sendKeys("wooden spoon"+ Keys.ENTER);

//2nd Syntax for cssSelector==>>>>  a- tagName#idValue
//                                 b- tagName.classValue



      //  4. Verify title contains search term

        String searchTerm="wooden spoon";
        String actual=driver.getTitle();
        System.out.println(actual);
        System.out.println(actual.contains(searchTerm)? "Passed": "FAILED");
    }
}
