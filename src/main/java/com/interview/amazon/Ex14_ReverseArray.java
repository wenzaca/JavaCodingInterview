package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
Reverse one array without using another array
 */
public class Ex14_ReverseArray {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Integer number = Integer.parseInt(sc.next());
        Ex14_ReverseArray ex14_ReverseArray = new Ex14_ReverseArray();
        ex14_ReverseArray.solution(new String[]{});
    }

    public Object[] solution(Object[] array){
        if (array ==null || array.length<2) return array;
        Object firstValue;
        for(int i=0;i<(array.length/2);i++){
            firstValue = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = firstValue;
        }
        return array;
    }

    @Test
    public void testSolution(){
        Object[] solution1 = solution(new String[]{"Hi", "there", "how", "are", "you"});
        Object[] solution2 = solution(new Integer[]{1, 2, 3, 4});
        Object[] solution3 = solution(new Character[]{'a', 'b', 'c', 'd', 'e', 'f'});
        Object[] solution4 = solution(new String[]{});
        Object[] solution5 = solution(new Integer[]{1});


        Assert.assertArrayEquals(solution1, new String[]{"you", "are", "how", "there", "Hi"});
        Assert.assertArrayEquals(solution2, new Integer[]{4, 3, 2, 1});
        Assert.assertArrayEquals(solution3, new Character[]{'f', 'e', 'd', 'c', 'b', 'a'});
        Assert.assertArrayEquals(solution4, new String[]{});
        Assert.assertArrayEquals(solution5, new Integer[]{1});

    }
}