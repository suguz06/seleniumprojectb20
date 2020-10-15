package com.cybertek.tests.day10_testBase_properties_driverUtil;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test //logic comes from Java
    public void reading_from_properties_file() throws IOException {

        // Properties: use Properties class  object
        Properties properties=new Properties(); // object to be able to read configuration.properties file
        //import from java.util

        // FileInputStream: open the file
        String path="configuration.properties"; //copy from content root

        //we need to pass the path of the file we want to open it
        FileInputStream file =new FileInputStream(path); //gives checked execption throws keyword in method signature

        //We will load the file
        properties.load(file);

        // We read from the file

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        System.out.println("properties = " + properties);


        //Close the file

    }


    @Test
    public void using_properties_utility_method(){
// this will read the given keys value and return it as a String

        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"smartbearUrl\") = " + ConfigurationReader.getProperty("smartbearUrl"));
    }
}
