package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
Write a simple Java program which will print Fibonacci series
e.g. 1 1 2 3 5 8 13 ... . up to a given number. Be prepare for
cross questions like using iteration over recursion and how to
optimize the solution using caching and memoization.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDOT4iYV
 */
public class Ex1_Fibonacci {
    public int solution(int limit){
        int old_value = 1;
        int new_value = 1;
        int result = 0;

        for (int i =0; i<limit; i++){
            result = old_value + new_value;
            System.out.println(old_value);
            old_value = new_value;
            new_value = result;
        }
        return result-old_value;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(solution(10), is(55));
    }
}
