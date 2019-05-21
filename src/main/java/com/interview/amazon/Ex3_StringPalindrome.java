package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
You need to write a simple Java program to check if a given String is palindrome or not.
A Palindrome is a String which is equal to the reverse of itself e.g. "Bob" is a palindrome
because of the reverse of "Bob" is also "Bob".  Though be prepared with both recursive and
iterative solution of this problem. The interviewer may ask you to solve without using any
library method e.g. indexOf() or subString() so be prepared for that.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDOBEHcF
 */
public class Ex3_StringPalindrome {
    public boolean solution(String word){
        char[] chars = word.toLowerCase().trim().toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char first = chars[i];
            char last = chars[chars.length - i - 1];
            chars[i] = last;
            chars[chars.length - i - 1] = first;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(chars);
        return stringBuffer.toString().equals(word.toLowerCase().trim());
    }

    @Test
    public void testSolution(){
        Assert.assertThat(solution("bob"), is(true));
        Assert.assertThat(solution("arara"), is(true));
        Assert.assertThat(solution("heyah"), is(false));
        Assert.assertThat(solution("heyahayeh"), is(true));
        Assert.assertThat(solution("kingking"), is(false));
        Assert.assertThat(solution("Bookoob"), is(true));

    }
}