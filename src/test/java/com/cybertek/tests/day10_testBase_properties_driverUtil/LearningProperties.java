package com.cybertek.tests.day10_testBase_properties_driverUtil;

import org.testng.annotations.Test;

public class LearningProperties {



    @Test
    public  void java_properties_test(){

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"os.version\") = " + System.getProperty("os.version"));

        // key    =   value (probably it is linked MAP)
        // os.name = Windows 10
        // user.name = selman

        //keys has to be exactly the same value when you pass it
       //othewise it will not work so if you are getting'null' make sure your key is correct

    }
}
