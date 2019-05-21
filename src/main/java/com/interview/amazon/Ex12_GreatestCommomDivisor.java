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
Simple Java program to find GCD (Greatest common Divisor) or GCF  (Greatest Common Factor) or
HCF (Highest common factor). The GCD of two numbers is the largest positive integer that divides
both the numbers fully i.e. without any remainder. There are multiple methods to find GCD , GDF or
HCF of two numbers but  Euclid's algorithm is very popular and easy to understand, of course, only
if you understand how recursion works. Euclid's algorithm is an efficient way to find GCD of two numbers
and it's pretty easy to implement using recursion in Java program. According to Euclid's method GCD of two
numbers a, b is equal to GCD(b, a mod b) and GCD(a, 0) = a. The later case is the base case of our Java
program to find GCD of two numbers using recursion. You can also calculate greatest common divisor in
Java without using recursion but that would not be as easy as the recursive version, but still a good
exercise from coding interviews point of view.

Read more: http://www.java67.com/2012/08/java-program-to-find-gcd-of-two-numbers.html#ixzz5nUyFVj31
 */
public class Ex12_GreatestCommomDivisor {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("First number: ");
        Integer number1 = Integer.parseInt(sc.next());
        System.out.print("Second number: ");
        Integer number2 = Integer.parseInt(sc.next());
        Ex12_GreatestCommomDivisor ex12_GreatestCommomDivisor = new Ex12_GreatestCommomDivisor();
        System.out.println(ex12_GreatestCommomDivisor.solution(number1,number2));
    }

    public int solution(int number1, int number2){
        int divisor;
        if(number1 == 0 || number2==0) return 0;
        if(number1==1 || number2==1) return 1;
        if(number1==number2) return number1;
        while (number1 != number2) {
            if(number1 > number2)
                number1 = number1 - number2;
            else
                number2 = number2 - number1;
        }
        return number2;

    }

    @Test
    public void testSolution(){

        Assert.assertThat(solution(4,8), is(4));
        Assert.assertThat(solution(1,0), is(0));
        Assert.assertThat(solution(500,500), is(500));
        Assert.assertThat(solution(256,8), is(8));
        Assert.assertThat(solution(1,8), is(1));
        Assert.assertThat(solution(15,60), is(15));


    }
}