package com.interview.crackinginterview.arraystrings;

import org.junit.Assert;
import org.junit.Test;

// URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
// space at the end to hold the additional characters, and that you are given the "true" length of the string.
// (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
public class Exercise1_3 {

    public String convertStringIntoUrl(String input){
        return input.trim().replaceAll(" ", "%20");
    }

    @Test
    public void validate(){
        String test1Input1 = "aabc de";
        String test2Input1 = "amazon go";
        String test3Input1 = "abdefza";
        String test4Input1 = "";
        String test5Input1 = "ab cd e f ";

        Assert.assertEquals(convertStringIntoUrl(test1Input1), "aabc%20de");
        Assert.assertEquals(convertStringIntoUrl(test2Input1), "amazon%20go");
        Assert.assertEquals(convertStringIntoUrl(test3Input1), "abdefza");
        Assert.assertEquals(convertStringIntoUrl(test4Input1), "");
        Assert.assertEquals(convertStringIntoUrl(test5Input1), "ab%20cd%20e%20f") ;
    }
}
