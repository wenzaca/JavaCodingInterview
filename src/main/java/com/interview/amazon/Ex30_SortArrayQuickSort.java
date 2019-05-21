package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

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

public class Ex30_SortArrayQuickSort {

    /**
     * Test class to sort array of integers using Quicksort algorithm in Java.
     *
     * @author Javin Paul
     */


    public static void main(String args[]) {

        // unsorted integer array
        Integer[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Unsorted array :" + Arrays.toString(unsorted));

        QuickSort algorithm = new QuickSort();

        // sorting integer array using quicksort algorithm
        algorithm.sort(unsorted);

        // printing sorted array
        System.out.println("Sorted array :" + Arrays.toString(unsorted));

    }

    @Test
    public void testSolution() {

        QuickSort algorithm = new QuickSort();

        Integer[] array1 = {2, 4, 3, 5, 1};
        Integer[] array2 = {5, 4, 3, 2, 1};
        Integer[] array3 = {3, 4, 6, 2, 5, 1};
        Integer[] array4 = {1, 2, 3, 4};
        Integer[] array5 = {};
        Integer[] array6 = null;

        algorithm.sort(array1);
        algorithm.sort(array2);
        algorithm.sort(array3);
        algorithm.sort(array4);
        algorithm.sort(array5);
        algorithm.sort(array6);


        Assert.assertArrayEquals(array1, new Integer[]{1,2,3,4,5});
        Assert.assertArrayEquals(array2, new Integer[]{1,2,3,4,5});
        Assert.assertArrayEquals(array3, new Integer[]{1,2,3,4,5,6});
        Assert.assertArrayEquals(array4, new Integer[]{1,2,3,4});
        Assert.assertArrayEquals(array5, new Integer[]{});
        Assert.assertArrayEquals(array6, null);

    }

}

class QuickSort {

    private Integer input[];
    private int length;

    public void sort(Integer[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        length = numbers.length;
        quickSort(0, length - 1);
    }

    /*
     * This method implements in-place quicksort algorithm recursively.
     */
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
        int pivot = input[low + (high - low) / 2];

        // Divide into two arrays
        while (i <= j) {
            /**
             * As shown in above image, In each iteration, we will identify a
             * number from left side which is greater then the pivot value, and
             * a number from right side which is less then the pivot value. Once
             * search is complete, we can swap both numbers.
             */
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }

        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}