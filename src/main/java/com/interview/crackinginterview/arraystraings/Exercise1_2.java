package main.java.com.interview.crackinginterview.arraystraings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

// Check Permutation: Given two strings, write a method to decide if one is a permutation of the
//other.
public class Exercise1_2 {

    public Boolean checkPermutation(String input1, String input2){
        if(input1.length() != input2.length()){
            return Boolean.FALSE;
        }
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
        String test3Input2 = "zfzebda";

        String test4Input1 = "aaa";
        String test4Input2 = "a";

        String test5Input1 = "abdefza";
        String test5Input2 = "zafebda";

        Assert.assertTrue(!checkPermutation(test1Input1, test1Input2));
        Assert.assertTrue(!checkPermutation(test2Input1, test2Input2));
        Assert.assertTrue(!checkPermutation(test3Input1, test3Input2));
        Assert.assertTrue(!checkPermutation(test4Input1, test4Input2));
        Assert.assertTrue(checkPermutation(test5Input1, test5Input2));
    }
}
