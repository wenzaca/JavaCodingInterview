package com.interview.amazon.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

public class LongestNonRepetitiveSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the word: ");
        String word = sc.next();
        LongestNonRepetitiveSubString longestNonRepetitiveSubString = new LongestNonRepetitiveSubString();
        System.out.println(longestNonRepetitiveSubString.solution(word));

    }

    public String solution(String word) {
        if (word == null || word.length() == 0) return "";
        String result = "";
        String newResult = "";

        char[] chars = word.toCharArray();

        for (Character charac : chars) {
            if (result.indexOf(charac) >= 0) {
                result = "";
            } else {
                result += charac.toString();
            }
            if (newResult.length() < result.length())
                newResult = result;
        }

        return newResult;
    }

    @Test
    public void testSolution() {

        Assert.assertThat(solution("abcdeabcdfghij"), is("bcdfghij"));
        Assert.assertThat(solution("abcdefgfhij"), is("abcdefg"));
        Assert.assertThat(solution(""), is(""));
        Assert.assertThat(solution(null), is(""));
    }
}
