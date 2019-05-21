package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
This is generally asked as follow-up or alternative of the previous program.
This time you need to check if given Integer is palindrome or not.
An integer is called palindrome if its equal to its reverse e.g. 1001 is a palindrome but 1234
is not because the reverse of 1234 is 4321 which is not equal to 1234. You can use divide by 10 to reduce
the number and modulus 10 to get the last digit. This trick is used to solve this problem.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDMNiTvU
 */
public class Ex4_IntegerPalindrome {
    public boolean solution(int number){
        int i = 10;
        int res = 0;
        int newNum = number;
        int rest = 0;
        while(i<number){
            rest = newNum%10;
            res = res*10 + rest;
            newNum=number/i;
            i=i*10;
        }
        res = res*10 +newNum;
        return res==number;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(solution(1221), is(true));
        Assert.assertThat(solution(1001), is(true));
        Assert.assertThat(solution(0), is(true));
        Assert.assertThat(solution(101), is(true));
        Assert.assertThat(solution(1234), is(false));
        Assert.assertThat(solution(1234321), is(true));

    }
}