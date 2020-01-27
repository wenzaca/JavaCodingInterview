package main.java.com.interview.crackinginterview.arraystraings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

// Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?
public class Exercise1_1 {

    public Boolean checkUniqueCharacterOnStringsAdditionalDataStructure(String input){
        char[] chars = input.toCharArray();
        Map<Character, Boolean> result = new HashMap<>(chars.length);
        for(Character characterFromString : chars){
            result.computeIfAbsent(characterFromString, character ->  result.put(character, Boolean.TRUE));
        }

        return result.size() == chars.length;
    }

    public Boolean checkUniqueCharacterOnStringsSingleDataStructure(String input){
        for(int i=0;i<input.length();i++) {
            if (input.indexOf(input.charAt(i))!=input.lastIndexOf(input.charAt(i))) return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Test
    public void validate() {
        String test1 = "aabcde";
        String test2 = "abcde";
        String test3 = "qwertyuiopasdfghjklzxvbnm,.';";
        String test4 = "abcdeeee";
        String test5 = "abdefza";

        Assert.assertTrue(!checkUniqueCharacterOnStringsAdditionalDataStructure(test1));
        Assert.assertTrue(checkUniqueCharacterOnStringsAdditionalDataStructure(test2));
        Assert.assertTrue(checkUniqueCharacterOnStringsAdditionalDataStructure(test3));
        Assert.assertTrue(!checkUniqueCharacterOnStringsAdditionalDataStructure(test4));
        Assert.assertTrue(!checkUniqueCharacterOnStringsAdditionalDataStructure(test5));
    }

    @Test
    public void validate2(){
        String test1 = "aabcde";
        String test2 = "abcde";
        String test3 = "qwertyuiopasdfghjklzxvbnm,.';";
        String test4 = "abcdeeee";
        String test5 = "abdefza";

        Assert.assertTrue(!checkUniqueCharacterOnStringsSingleDataStructure(test1));
        Assert.assertTrue(checkUniqueCharacterOnStringsSingleDataStructure(test2));
        Assert.assertTrue(checkUniqueCharacterOnStringsSingleDataStructure(test3));
        Assert.assertTrue(!checkUniqueCharacterOnStringsSingleDataStructure(test4));
        Assert.assertTrue(!checkUniqueCharacterOnStringsSingleDataStructure(test5));

    }
}
