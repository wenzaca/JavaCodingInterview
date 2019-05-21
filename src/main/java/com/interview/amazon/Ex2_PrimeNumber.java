package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
Write a Java program to check if a given number is prime or not.
Remember, a prime number is a number which is not divisible by any
other number e.g. 3, 5, 7, 11, 13, 17 etc. Be prepared for cross e.g.
checking till the square root of a number etc.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDOHcdgj
 */
public class Ex2_PrimeNumber {
    public boolean solution(int number){
        for (int i = number-1; i > 1; i--){
            if(number%i==0)
                return false;
        }
        return true;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(solution(12), is(false));
        Assert.assertThat(solution(11), is(true));
        Assert.assertThat(solution(15), is(false));
    }
}
