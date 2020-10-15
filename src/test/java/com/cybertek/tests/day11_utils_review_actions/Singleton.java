package com.cybertek.tests.day11_utils_review_actions;

public class Singleton {

    //making contructor private so we limit creating objects from class
    private Singleton() { // singleton => private constructor => just one object from the class

    }

    //making the String private so that we can only reach this using getter method
    private static String word;


    //creating a getter method to allow users to reach private string above
    public static String getWord() {
        if (word == null) {
            System.out.println("First time call. Word object is null. " +
                    "Assignig value to it now");
            word = "something";
        } else {
            System.out.println("Word already has value");
        }

        return word;

    }
}