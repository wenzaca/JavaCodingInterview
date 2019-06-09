package com.interview.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Given an array of integers representing heights of structures, calculate the amount of water that can be trapped in between them (algorithms)
 */
public class HeightOfBuildingWaterStored {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the array size: ");
        Integer number = Integer.parseInt(sc.next());
        Integer[] integers = new Integer[number];
        for (int i = 0; i < number; i++) {
            integers[i] = Integer.parseInt(sc.next());
        }
        System.out.println(findWater(integers));
    }

    public static int findWater(Integer array[])   {

        int size = array.length;
        // left[i] contains height of tallest bar to the
        // left of i'th bar including itself
        int[] left = new int[size];

        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int[] right = new int[size];

        int water = 0;

        left[0] = array[0];
        for (int i = 1; i < size; i++)
            left[i] = Math.max(left[i-1], array[i]);

        right[size-1] = array[size-1];
        for (int i = size-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], array[i]);

        for (int i = 0; i < size; i++)
            water += Math.min(left[i],right[i]) - array[i];

        return water;
    }

    @Test
    public void testSolution(){
        Assert.assertThat(findWater(new Integer[]{0,0,0,0,0,0,0,0,0,0}), is(0));
        Assert.assertThat(findWater(new Integer[]{1,2,3,1,2,3,1,2,3,1,2,3}), is(9));
        Assert.assertThat(findWater(new Integer[]{0,1,0,2,1,0,1,3,2,1,2,1}), is(6));
        Assert.assertThat(findWater(new Integer[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,2}), is(13));
    }
}
