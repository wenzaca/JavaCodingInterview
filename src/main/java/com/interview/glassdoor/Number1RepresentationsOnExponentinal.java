package com.interview.glassdoor;


import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;

/*
Given the a positive integer N count the number of 1 digits in the representation of 11^N.
 */
public class Number1RepresentationsOnExponentinal {

    // Time Complexity is O(n)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the exponential value: ");
        Integer number = Integer.parseInt(sc.next());
        Number1RepresentationsOnExponentinal number1RepresentationsOnExponentinal = new Number1RepresentationsOnExponentinal();
        System.out.println(number1RepresentationsOnExponentinal.solution(number));

    }

    public Integer solution(Integer number) {
        if (number == null) return 0;
        if (number == 0) return 1;
        Long resultOfPow = 1L;
        for (int i = 1; i <= number; i++) {
            resultOfPow = resultOfPow * 11L;
        }
        Integer result = 0;
        Pattern pat = Pattern.compile("1");
        Matcher mat = pat.matcher(resultOfPow.toString());
        while (mat.find()) {
            result++;
        }

        return result;
    }

    @Test
    public void testSolution() {

        Assert.assertThat(solution(2), is(2));
        Assert.assertThat(solution(20), is(3));
        Assert.assertThat(solution(1), is(2));
        Assert.assertThat(solution(null), is(0));
        Assert.assertThat(solution(0), is(1));
    }
}
