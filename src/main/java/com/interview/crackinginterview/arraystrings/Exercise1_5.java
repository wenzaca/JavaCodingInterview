package com.interview.crackinginterview.arraystrings;

import org.junit.Assert;
import org.junit.Test;

// One Away: There are three types of edits that can be performed on strings: insert a character, remove a character,
// or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
public class Exercise1_5 {

    public Boolean checkSingleReplacement(String input1, String input2){
        if(Math.abs(input1.length()-input2.length())>1){
            return Boolean.FALSE;
        }
        char[] charsFromInput1 = input1.toCharArray();
        char[] charsFromInput2 = input1.toCharArray();

        for(int i=0;i<charsFromInput1.length;i++){
            if(charsFromInput1[i] == charsFromInput2[i]) {
                input2 = input2.replaceFirst(String.valueOf(charsFromInput1[i]), "");
                input1 = input1.replaceFirst(String.valueOf(charsFromInput1[i]), "");
            }
         }

        return input2.length()<2 &&  input1.length()<2;
    }

    @Test
    public void validate(){
        String test1Input1 = "pale";
        String test1Input2 = "ale";

        String test2Input1 = "pale";
        String test2Input2 = "bale";

        String test3Input1 = "pale";
        String test3Input2 = "pale";

        String test4Input1 = "pales";
        String test4Input2 = "pale";

        String test5Input1 = "pale";
        String test5Input2 = "pallet";

        String test6Input1 = "pale";
        String test6Input2 = "bala";

        Assert.assertTrue(checkSingleReplacement(test1Input1, test1Input2));
        Assert.assertTrue(checkSingleReplacement(test2Input1, test2Input2));
        Assert.assertTrue(checkSingleReplacement(test3Input1, test3Input2));
        Assert.assertTrue(checkSingleReplacement(test4Input1, test4Input2));
        Assert.assertTrue(!checkSingleReplacement(test5Input1, test5Input2));
        Assert.assertTrue(!checkSingleReplacement(test6Input1, test6Input2));
    }
}
