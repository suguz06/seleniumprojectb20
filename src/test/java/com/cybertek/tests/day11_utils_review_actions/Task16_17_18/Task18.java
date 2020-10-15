package com.cybertek.tests.day11_utils_review_actions.Task16_17_18;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task18 {

    /*
TC #18:   Hover  Test
1.Go   to https://demos.telerik.com/kendo-ui/dragdrop/index
2.Drag and    drop   the    small  circle to bigger circle.
3.Assert:  -Text  in big    circle changed to:    "You did   great"
 */


    @Test
    public void task18(){ // THIS TEST IS INTERESTING+>> IN  THE BIG SCREEN +>IT IS PASSED => SMALL SCREEN NOT!!!
//MOVE TO BIG SCREEN OR  CLICKHOLD+>MOVEELEMENT+> RELEASE METHODS YOU USE!!
        WebDriver driver = Driver.getDriver();


//        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
//        //driver.switchTo().frame(0);
//
//        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
//
//        WebElement droptarget = driver.findElement(By.xpath("//div[@id='droptarget']"));
//
//        Actions actions=new Actions(driver);
//
//        actions.dragAndDrop(draggable, droptarget).perform();
//
//        WebElement element = driver.findElement(By.xpath("//div[.='You did great!']"));
//
//        Assert.assertTrue(element.isDisplayed());


        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
       // WebElement iframe = Driver.getDriver().findElement(By.xpath("//div[@id='example']"));

        WebElement biggerCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallerCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        Actions action = new Actions(Driver.getDriver());
        BrowserUtil.wait(2);

       // driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        action.dragAndDrop(smallerCircle, biggerCircle).perform();

       WebElement youDidGrerat = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']"));

        String droptarget = driver.findElement(By.id("droptarget")).getText();
        System.out.println(droptarget);
       Assert.assertTrue(youDidGrerat.isDisplayed(), "You did great is not desplayed!!!");
        //Driver.closeDriver();


    }

}
