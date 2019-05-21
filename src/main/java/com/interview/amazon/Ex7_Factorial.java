package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/*
This is one of the simplest programs you can expect on interviews.
It is generally asked to see if you can code or not. Sometimes interviewer
may also ask about changing a recursive solution to iterative one or vice-versa.
 */
public class Ex7_Factorial {
    public int solution(int number){
        int res = 1;
        int newNum = number;
        for(int i=1;i<=number;i++){
            res = res * i;
        }
        return res;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(solution(3), is(3*2*1));
        Assert.assertThat(solution(0), is(1));
        Assert.assertThat(solution(5), is(5*4*3*2*1));
        Assert.assertThat(solution(1), is(1));
    }
}