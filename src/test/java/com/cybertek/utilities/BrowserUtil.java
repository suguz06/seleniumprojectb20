package com.cybertek.utilities;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/*
in this class we will store utility methods that can be
applied to any browser content.

Any time you feel like you have a good logic thar you can use in the future
create a method of it and store it in the class

Then call it future

 */
public class BrowserUtil {

    /**
    Accepts a list of WebElement
    @param list
    @return List<String>
    Method should be returning a list of Strings
     */

    public static List<String> getElementsText(List<WebElement > list){

        List<String> webElementAsText=  new ArrayList<>();

        for (WebElement each : list) {
            webElementAsText.add(each.getText());

        }
        return webElementAsText;
    }

   /*
   create a utility method named: wait
   static method
   @param sec
   @return void
   the integer number that I pass as parameter should be accepted as SECONDS
   Handle checked exception with try/catch

    */

    public static void wait(int sec){

        try {// handled permanently
            Thread.sleep(sec*1000);
        } catch (InterruptedException e){
            e.getMessage();
           // e.printStackTrace(); => print out
        }
    }



}
