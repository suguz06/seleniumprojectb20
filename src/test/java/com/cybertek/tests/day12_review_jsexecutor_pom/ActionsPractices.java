package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.BrowserUtil;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsPractices {

       /*
    TC	#16:	Double	ClickTest
    1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    2.Switch	to	iframe.
    3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
    4.Assert:	Text’s	“style”	attribute	value	contains "red"
     */

    @Test
    public void p2_double_click() {

        WebDriver driver = Driver.getDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");


        //2.Switch	to	iframe.

        driver.switchTo().frame("iframeResult");

        WebElement textDoubleClick = driver.findElement(By.id("demo"));

        Actions actions = new Actions(driver);

        actions.doubleClick(textDoubleClick).perform();

        String expected = "red";
        String actual = textDoubleClick.getAttribute("style"); //color: red

        Assert.assertTrue(actual.contains(expected));

    }


    /*
TC #18:   Hover  Test
1.Go   to https://demos.telerik.com/kendo-ui/dragdrop/index
2.Drag and    drop   the    small  circle to bigger circle.
3.Assert:  -Text  in big    circle changed to:    "You did   great"
*/
    @Test
    public void p3_drag_drop() {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");


        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        BrowserUtil.wait(3);

        // WebElement biggerCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement biggerCircle = driver.findElement(By.id("droptarget"));

        // WebElement smallerCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement smallerCircle = driver.findElement(By.id("draggable"));


        BrowserUtil.wait(3);
        Actions actions = new Actions(Driver.getDriver());


        //actions.dragAndDrop(smallerCircle, biggerCircle);

//      actions.clickAndHold(smallerCircle).perform();
//        BrowserUtil.wait(3);
//        actions.moveToElement(biggerCircle).perform();
//        BrowserUtil.wait(3);
//        actions.release().perform();
//

        actions.clickAndHold(smallerCircle).moveToElement(biggerCircle).release().perform();

//       WebElement youDidGrerat = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']"));
//
//        String droptarget = driver.findElement(By.id("droptarget")).getText();
//        System.out.println(droptarget);
//         Assert.assertTrue(youDidGrerat.isDisplayed(), "You did great is not desplayed!!!");


        String expected = "You did great!";
        String actual = biggerCircle.getText();
        Assert.assertTrue(actual.equals(expected));


        BrowserUtil.wait(3);
        Driver.closeDriver();


    }


    @Test
    public void p4_context_click() {
//TC #17: Context Click – HOMEWORK
//1. Go to https://the-internet.herokuapp.com/context_menu

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
// 2. Right click to the box. => contextClick()

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        Actions actions=new Actions(Driver.getDriver());

        actions.contextClick(box).perform();

        //3. Alert will open.
//4. Accept alert

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();



//No assertion needed for this practice.


        //this 2 => open the link
       // actions.moveToElement(Driver.getDriver().findElement(By.linkText("Elemental Selenium"))).click().perform();

       // Driver.getDriver().findElement(By.partialLinkText("Elemental Selenium")).click();

    }


}
