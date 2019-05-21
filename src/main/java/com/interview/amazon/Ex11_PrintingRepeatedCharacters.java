package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
You need to write a program to calculate the square root of a number without using the Math.sqrt() function of JDK.
You need to write your logic and method to calculate the square root.
You can though use popular algorithm e.g. Newton's method.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nJcdkDGk
 */
public class Ex11_PrintingRepeatedCharacters {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String word = sc.next();
        Ex11_PrintingRepeatedCharacters ex11_PrintingRepeatedCharacters = new Ex11_PrintingRepeatedCharacters();
        ex11_PrintingRepeatedCharacters.solution(word);
    }

    public void solution(String word){

        char[] chars = word.trim().toCharArray();
        Map<Character, Integer> hashMap = new HashMap<>();

        for(int i=0;i<chars.length;i++){
            hashMap.computeIfPresent(chars[i], (key, value) -> {
                System.out.println(key);
                value += 1;
                return value;
            });
            hashMap.computeIfAbsent(chars[i], key -> 1);

        }



    }

    @Test
    public void testSolution(){

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solution("abcdeefgga");
        Assert.assertThat("e\ng\na\n", is(outContent.toString()));
    }
}