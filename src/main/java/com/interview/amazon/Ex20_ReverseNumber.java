package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
How to reverse a number in Java without using any API or write a simple Java program to reverse a number is
common programming questions asked on fresher level software engineer interviews. Reversing a number is also
popular homework questions on many Java programming courses in school, colleges and training institutes. I
personally feel java program to reverse number is good programming exercise for someone who is just started
learning to program in Java or any other programming language because of its simplicity and a little bit of
trickiness which shows how to use operators for programming purposes rather than arithmetic purpose. In last
couple of Java programming tutorial we have seen some basic programming exercises like how to reverse string
in Java using recursion and how to check if a number is prime or not, while in this Java tutorial we will see
a simple example of Java program to reverse number by just using basic Java operators like division operator(/)
and remainder operator(%). division operator returns quotient while modules or remainder operator % returns
the remainder.

Read more: https://javarevisited.blogspot.com/2012/04/java-program-to-reverse-number-example.html#ixzz5nsFtiDe1
 */
public class Ex20_ReverseNumber {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Integer number = Integer.parseInt(sc.next());
        Ex20_ReverseNumber ex20 = new Ex20_ReverseNumber();
        System.out.println(ex20.solution(number));
    }

    public int solution(int number){
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
        return res;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(solution(1221), is(1221));
        Assert.assertThat(solution(1001), is(1001));
        Assert.assertThat(solution(0), is(0));
        Assert.assertThat(solution(101), is(101));
        Assert.assertThat(solution(1234), is(4321));
        Assert.assertThat(solution(1234321), is(1234321));

    }
}