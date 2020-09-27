package com.cybertek.tests.Tasks;

import java.text.DateFormatSymbols;
import java.util.Arrays;

public class Months { //how to get all names of months

    public static void main(String[] args) {

        DateFormatSymbols dfs = new DateFormatSymbols();

        String[] months = dfs.getMonths();
        System.out.printf("List of months: ");
        System.out.println(Arrays.toString(months));
    }
}
