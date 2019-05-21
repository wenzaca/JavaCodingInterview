package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
Reverse one array without using another array
 */
public class Ex15_ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        Ex15_ReverseString ex15_ReverseString = new Ex15_ReverseString();
        ex15_ReverseString.solution(string);
    }

    public String solution(String word) {
        if (word == null || word.length() == 1) return word;
        char firstValue;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < (charArray.length / 2); i++) {
            firstValue = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = firstValue;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charArray);
        System.out.println("Reverse: " + sb.toString());
        return sb.toString();
    }

    @Test
    public void testSolution() {

        Assert.assertThat(solution("Hey"), is("yeH"));
        Assert.assertThat(solution("Hey there bro"), is("orb ereht yeH"));
        Assert.assertNull(solution(null));
        Assert.assertThat(solution("D"), is("D"));

    }
}