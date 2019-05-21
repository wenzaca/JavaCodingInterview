package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/*
Quicksort algorithm is one of the most used sorting algorithm, especially to sort large list and
most of the programming languages, library have implemented it in one or another way. In Java,
Arrays.sort() method sorts primitive data types using double pivot Quicksort algorithm, authored
by Joshua Bloach and others. This implementation provides better performance for lot of data sets,
where traditional quicksort algorithm reduced into quadratic performance. This method also uses MergeSort,
another good sorting algorithm, to sort objects.

Read more: https://javarevisited.blogspot.com/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html#ixzz5oRMikpdq
 */

public class Ex31_InsertationSort {

    /**
     * Test class to sort array of integers using Quicksort algorithm in Java.
     *
     * @author Javin Paul
     */


    public static void main(String[] args) {

        // unsorted integer array
        Integer[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Unsorted array :" + Arrays.toString(unsorted));

        Ex31_InsertationSort ex31_insertationSort = new Ex31_InsertationSort();
        // sorting integer array using quicksort algorithm
        ex31_insertationSort.solution(unsorted);

        // printing sorted array
        System.out.println("Sorted array :" + Arrays.toString(unsorted));

    }

    private void solution(Integer[] numbers) {

        if (numbers == null || numbers.length == 0) return;

        int posInitial = 1;


        while (posInitial < numbers.length) {
            int counter = 0;
            for (int i = posInitial - 1; i >= 0; i--) {
                if (numbers[i] > numbers[posInitial - counter]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[posInitial - counter];
                    numbers[posInitial - counter] = temp;
                }
                counter++;
            }
            posInitial++;
        }

    }

    @Test
    public void testSolution() {

        Integer[] array1 = {2, 4, 3, 5, 1};
        Integer[] array2 = {5, 4, 3, 2, 1};
        Integer[] array3 = {3, 4, 6, 2, 5, 1};
        Integer[] array4 = {1, 2, 3, 4};
        Integer[] array5 = {};
        Integer[] array6 = null;

        solution(array1);
        solution(array2);
        solution(array3);
        solution(array4);
        solution(array5);
        solution(array6);


        Assert.assertArrayEquals(array1, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(array2, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(array3, new Integer[]{1, 2, 3, 4, 5, 6});
        Assert.assertArrayEquals(array4, new Integer[]{1, 2, 3, 4});
        Assert.assertArrayEquals(array5, new Integer[]{});
        Assert.assertArrayEquals(array6, null);

    }

}