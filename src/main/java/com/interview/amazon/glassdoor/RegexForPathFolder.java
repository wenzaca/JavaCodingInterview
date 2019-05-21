package com.interview.amazon.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Given input string which represents path (foo/bar/$id), how would you write a function which returns $id?
 */
public class RegexForPathFolder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the array size: ");
        String word = sc.next();
        RegexForPathFolder longestNonRepetitiveSubString = new RegexForPathFolder();
        System.out.println(longestNonRepetitiveSubString.solution(word));

    }

    public String solution(String word) {
        if (word == null || word.length() == 0) return new String();
        String result = "";
        String newResult = "";

        char[] chars = word.toCharArray();

        for(Character charac : chars){
            if(result.indexOf(charac) >= 0){
                result = "";
            } else {
                result += charac.toString();
            }
            if(newResult.length() < result.length())
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
