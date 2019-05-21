package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
This problem is similar to the String Palindrome problem we have discussed above.
If you can solve that problem you can solve this as well. You can use indexOf() or
substring() to reverse a String or alternatively, convert the problem to reverse an
array by operating on character array instead of String.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDR01ZXB
 */
public class Ex8_ReverseString {
    public String solution(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < string.length() / 2; i++) {
            char begin = chars[i];
            char end = chars[string.length() - i - 1];
            chars[i] = end;
            chars[string.length() - i - 1] = begin;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(chars);
        return sb.toString();
    }

    @Test
    public void testSolution() {
        Assert.assertThat(solution("hey there"), is("ereht yeh"));
        Assert.assertThat(solution("hola"), is("aloh"));
        Assert.assertThat(solution("story"), is("yrots"));
        Assert.assertThat(solution("t"), is("t"));
    }
}