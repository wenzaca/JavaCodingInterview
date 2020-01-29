package com.interview.crackinginterview.arraystrings;

import org.junit.Assert;
import org.junit.Test;

// String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the
// string aabcccccaaa would become a2b1c5a3, If the "compressed" string would not become smaller than the original string, your method
// should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
public class Exercise1_6 {

    public String stringRepetitiveCount(String input){

        if(input.isEmpty()) return "";
        char[] charsFromInput = input.toCharArray();
        Character previous = charsFromInput[0];
        Integer counterRepetitiveChar = 1;
        String response = "";
        for(int i = 1; i < input.length(); i++){
            if(charsFromInput[i] == previous){
                counterRepetitiveChar++;
            } else {
                response = response + previous + counterRepetitiveChar;
                counterRepetitiveChar = 1;
                previous = charsFromInput[i];
            }
            if (i==input.length()-1) response = response + previous + counterRepetitiveChar;
         }



        return response;
    }

    @Test
    public void validate(){
        String test1Input1 = "aabbbbceec";
        String test2Input1 = "abcde";
        String test3Input1 = "aaaaa";
        String test4Input1 = "";
        String test5Input1 = "ab  cdeff";

        Assert.assertEquals(stringRepetitiveCount(test1Input1), "a2b4c1e2c1");
        Assert.assertEquals(stringRepetitiveCount(test2Input1), "a1b1c1d1e1");
        Assert.assertEquals(stringRepetitiveCount(test3Input1), "a5");
        Assert.assertEquals(stringRepetitiveCount(test4Input1), "");
        Assert.assertEquals(stringRepetitiveCount(test5Input1), "a1b1 2c1d1e1f2") ;
    }
}
