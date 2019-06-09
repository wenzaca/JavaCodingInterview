package com.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Write a Java program to find the first non-repeated character in a String is a common question
on coding tests. Since String is a popular topic in various programming interviews, It's better
to prepare well with some well-known questions like reversing String using recursion, or checking
if a String is a palindrome or not. This question is also in the same league. Before jumping into
solution, let's first understand this question. You need to write a function, which will accept a
String and return first non-repeated character, for example in the world "hello", except 'l' all
are non-repeated, but 'h' is the first non-repeated character. Similarly, in word "swiss" 'w' is
the first non-repeated character. One way to solve this problem is creating a table to store count
of each character, and then picking the first entry which is not repeated. The key thing to remember
is order, your code must return first non-repeated letter.


Read more: https://javarevisited.blogspot.com/2014/03/3-ways-to-find-first-non-repeated-character-String-programming-problem.html#ixzz5nsL8PDNe
 */
public class Ex21_NonRepeatableChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        Ex21_NonRepeatableChar ex21 = new Ex21_NonRepeatableChar();
        System.out.println(ex21.solution(word));
    }

    public String solution(String word) {
        Map<Character, Integer> map = new LinkedHashMap<>(word.length());
        LinkedList<Character> characters = new LinkedList<>();

        char[] chars = word.toCharArray();
        for (Character c : chars) {

            map.computeIfPresent(c, (key, value) -> {
                characters.removeFirstOccurrence(key);
                return value + 1;
            });
            map.computeIfAbsent(c, key -> {
                characters.add(key);
                return 1;
            });
        }
        if (characters.isEmpty()) return "";
        return characters.getFirst().toString();

    }

    public String solution2(String word) {
        Map<Character, Integer> map = new LinkedHashMap<>(word.length());

        char[] chars = word.toCharArray();
        for (Character c : chars) {

            map.computeIfPresent(c, (key, value) -> {
                return value + 1;
            });
            map.computeIfAbsent(c, key -> {
                return 1;
            });
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey().toString();
            }
        }
        return "";

    }


    @Test
    public void testSolution() {
        Assert.assertThat(solution("abcdefghijklmnopqrstuvxa123456789"), is("b"));
        Assert.assertThat(solution("aabbccded"), is("e"));
        Assert.assertThat(solution("abcdeeabc"), is("d"));
        Assert.assertThat(solution("abcdeabcde"), is(""));
    }

    @Test
    public void testSolution2() {
        Assert.assertThat(solution2("abcdefghijklmnopqrstuvxa123456789"), is("b"));
        Assert.assertThat(solution2("aabbccded"), is("e"));
        Assert.assertThat(solution2("abcdeeabc"), is("d"));
        Assert.assertThat(solution2("abcdeabcde"), is(""));
    }
}