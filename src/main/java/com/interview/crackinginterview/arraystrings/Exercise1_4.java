package com.interview.crackinginterview.arraystrings;

import org.junit.Assert;
import org.junit.Test;

// Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin- drome.
// A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement
// of letters. The palindrome does not need to be limited to just dictionary words.
public class Exercise1_4 {

    public Boolean checkPalindromeAndPermutation(String input1, String input2){
        if(input1.length() != input2.length()){
            return Boolean.FALSE;
        }
        return checkPermutation(input1, input2) && checkPalindrome(input1, input2);
    }

    private Boolean checkPalindrome(String input1, String input2){
        return new StringBuilder(input1).reverse().toString().equals(input2);
    }

    private Boolean checkPermutation(String input1, String input2){
        char[] charsFromInput1 = input1.toCharArray();
        for(Character charFromInput1 : charsFromInput1){
            if(input2.indexOf(charFromInput1)>=0){
                input2 = input2.replaceFirst(String.valueOf(charFromInput1), "");
            }
        }
        return input2.length() == 0;
    }

    @Test
    public void validate(){
        String test1Input1 = "aabcde";
        String test1Input2 = "abcde";

        String test2Input1 = "qwertyuiopasdfghjklzxvbnm,.';";
        String test2Input2 = "abcdeeee";

        String test3Input1 = "abdefza";
        String test3Input2 = "zfaebda";

        String test4Input1 = "aaa";
        String test4Input2 = "a";

        String test5Input1 = "abdefza";
        String test5Input2 = "azfedba";

        Assert.assertTrue(!checkPalindromeAndPermutation(test1Input1, test1Input2));
        Assert.assertTrue(!checkPalindromeAndPermutation(test2Input1, test2Input2));
        Assert.assertTrue(!checkPalindromeAndPermutation(test3Input1, test3Input2));
        Assert.assertTrue(!checkPalindromeAndPermutation(test4Input1, test4Input2));
        Assert.assertTrue(checkPalindromeAndPermutation(test5Input1, test5Input2));
    }
}
