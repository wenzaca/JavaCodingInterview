package com.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
Write a Java program to check if two String are anagram of each other, is another good coding question
asked at fresher level Java Interviews. This question is on similar level of finding middle element of
LinkedList in one pass and swapping two numbers without using temp variable. By the way two String are
called anagram, if they contains same characters but on different order e.g. army and mary, stop and pots etc.
Anagrams are actually mix-up of characters in String. If you are familiar with String API, i.e. java.lang.String
than you can easily solve this problem. In order to check if  Strings are anagram, you need to get there
character array and see if they are equal or not. Though you can also use indexOf(), substring() and StringBuffer
or StringBuilder  class to solve this question. In this Java program, we will see 3 ways to solve this interview
questions, and check if two String are anagram or not. By the way, if you are preparing for Java interview, it's
good to prepare some data structures and algorithms questions as well. More often, there is one or more questions
from programming, coding and logic in these interviews.
 */
public class Ex18_StringAnagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First word: ");
        String word1 = sc.next();
        System.out.print("Second word: ");
        String word2 = sc.next();
        Ex18_StringAnagram ex18_StringAnagram = new Ex18_StringAnagram();
        System.out.println(ex18_StringAnagram.solution(word1, word2));
    }

    public Boolean solution(String word1, String word2) {
        if ((word1 == null || word2 == null) || word1.length() != word2.length()) return false;
        char[] chars1 = word1.toLowerCase().toCharArray();
        char[] chars2 = word2.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            if (map.containsKey(chars2[i])) {
                if (map.get(chars2[i]) == 1) map.remove(chars2[i]);
            } else {
                map.put(chars2[i], 2);
            }
            if (map.containsKey(chars1[i])) {
                if (map.get(chars1[i]) == 2) map.remove(chars1[i]);
            } else {
                map.put(chars1[i], 1);
            }
        }
        return map.isEmpty();
    }

    @Test
    public void testSolution() {

        GregorianCalendar gc = new GregorianCalendar();

        Assert.assertThat(solution("abcd", "dcab"), is(true));
        Assert.assertThat(solution("aabcd", "dcbac"), is(false));
        Assert.assertThat(solution("abcdefgh", "fgabhcde"), is(true));
        Assert.assertThat(solution(null, "asd"), is(false));
        Assert.assertThat(solution("abcde", "aabbcde"), is(false));

    }

}