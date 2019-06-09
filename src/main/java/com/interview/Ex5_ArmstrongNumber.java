package com.interview;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
A number is called an Armstrong number if it is equal to the cube of its each digit.
For example, 153 is an Armstrong number because 153= 1+ 125+27 which is equal to 1^3+5^3+3^3.
You need to write a program to check if given number is Armstrong number or not.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDMUhryz
 */
public class Ex5_ArmstrongNumber {
    public boolean solution(int number) {
        int i = 10;
        int res = 0;
        int newNum = number;
        int rest = 0;
        while (newNum > 0) {
            res += Math.pow(newNum % 10, 3);
            newNum = number / i;
            i = i * 10;
        }
        return res == number;
    }

    @Test
    public void testSolution() {
        Assert.assertThat(solution(153), is(true));
        Assert.assertThat(solution(0), is(true));
        Assert.assertThat(solution(1), is(true));
        Assert.assertThat(solution(101), is(false));
        Assert.assertThat(solution(1234), is(false));

    }
}