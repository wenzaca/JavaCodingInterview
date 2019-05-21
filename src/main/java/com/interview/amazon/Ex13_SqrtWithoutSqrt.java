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
SQRT without using the math.sqrt
 */
public class Ex13_SqrtWithoutSqrt {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Integer number = Integer.parseInt(sc.next());
        Ex13_SqrtWithoutSqrt ex13_SqrtWithoutSqrt = new Ex13_SqrtWithoutSqrt();
        ex13_SqrtWithoutSqrt.solution(number);
    }

    public Double solution(int number){
        Double sqrt = 0d, divisor = 0d;

        sqrt = number/2d;

        do{
            divisor = sqrt;
            sqrt = (divisor + (number/divisor))/2;
        } while ((divisor - sqrt) != 0);
        System.out.println(sqrt);
        return sqrt;

    }

    @Test
    public void testSolution(){

        Assert.assertThat(solution(4), is(Math.sqrt(4)));
        Assert.assertThat(solution(5), is(Math.sqrt(5)));
        Assert.assertThat(solution(4000), is(Math.sqrt(4000)));
        Assert.assertThat(solution(1234), is(Math.sqrt(1234)));

    }
}