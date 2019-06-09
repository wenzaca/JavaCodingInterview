package com.interview.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Write a function to calculate pow(x,y). i.e x^y.
 */
public class Exponential {

    // Time complexity is O(n)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer number = Integer.parseInt(sc.next());
        Integer exponentialNumber = Integer.parseInt(sc.next());
        Exponential exponential = new Exponential();
        System.out.println(exponential.solution(number, exponentialNumber));
    }

    public Integer solution(Integer number, Integer exponentialNumber) {
        if (number == null || exponentialNumber == null) return 0;
        if (exponentialNumber == 0 || number == 1) return 1;

        Integer result = number;
        if (number != 0 && exponentialNumber != 1) {
            for (int i = 1; i < exponentialNumber; i++) {
                result = result * number;
            }
        }
        return result;

    }

    @Test
    public void testSolution() {

        Assert.assertThat(solution(1, 1), is(1));
        Assert.assertThat(solution(1, 1000000), is(1));
        Assert.assertThat(solution(1, 0), is(1));
        Assert.assertThat(solution(0, 15), is(0));
        Assert.assertThat(solution(15, 0), is(1));
        Assert.assertThat(solution(2, 3), is(8));
        Assert.assertThat(solution(null, 3), is(0));
    }
}
