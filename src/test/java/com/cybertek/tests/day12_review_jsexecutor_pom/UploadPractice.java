package com.cybertek.tests.day12_review_jsexecutor_pom;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void upload_test() {
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

//copy => shift+right click=> gives a copy path

        String path = "C:\\Users\\selman\\OneDrive\\Desktop\\1.jpg.png";

        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        uploadInput.sendKeys(path);


        //locate upload
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));


        uploadButton.click();
    }

}
