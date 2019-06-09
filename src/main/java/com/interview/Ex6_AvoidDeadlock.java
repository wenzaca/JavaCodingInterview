package com.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
A number is called an Armstrong number if it is equal to the cube of its each digit.
For example, 153 is an Armstrong number because 153= 1+ 125+27 which is equal to 1^3+5^3+3^3.
You need to write a program to check if given number is Armstrong number or not.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDMUhryz
 */
public class Ex6_AvoidDeadlock {

    Boolean isAvailable = true;
    List<Integer> resource = new ArrayList<>(1001);

    public static void main(String[] args) {
        Ex6_AvoidDeadlock ex6_avoidDeadlock = new Ex6_AvoidDeadlock();
        ex6_avoidDeadlock.solution();
    }


    public void solution() {
        for (int i = 0; i < 1000; i++) {
            resource.add(i * 100);
        }
        Thread thread = new Thread(() -> {
            //while(!isAvailable);
            isAvailable = false;
            for (int i = 0; i < 100; i++) {
                resource.remove(i);
                resource.add(i * 1);
            }
            System.out.println(resource);
            isAvailable = true;
        });
        Thread thread2 = new Thread(() -> {
            //while(!isAvailable);
            isAvailable = false;
            for (int i = 0; i < 100; i++) {
                resource.remove(i);
                resource.add(i * 2);
            }
            System.out.println(resource);
            isAvailable = true;
        });
        Thread thread3 = new Thread(() -> {
            //while(!isAvailable);
            isAvailable = false;
            for (int i = 0; i < 100; i++) {
                resource.remove(i);
                resource.add(i * 3);
            }
            System.out.println(resource);
            isAvailable = true;
        });

        thread.start();
        thread2.start();
        thread3.start();
    }

    @Test
    public void testSolution() {
//        Assert.assertThat(solution(), is(true));
//        Assert.assertThat(solution(0), is(true));
//        Assert.assertThat(solution(1), is(true));
//        Assert.assertThat(solution(101), is(false));
//        Assert.assertThat(solution(1234), is(false));

    }
}
