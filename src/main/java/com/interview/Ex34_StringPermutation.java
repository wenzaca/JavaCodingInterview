package com.interview;

import org.junit.Assert;
import org.junit.Test;

/*
Quicksort algorithm is one of the most used sorting algorithm, especially to sort large list and
most of the programming languages, library have implemented it in one or another way. In Java,
Arrays.sort() method sorts primitive data types using double pivot Quicksort algorithm, authored
by Joshua Bloach and others. This implementation provides better performance for lot of data sets,
where traditional quicksort algorithm reduced into quadratic performance. This method also uses MergeSort,
another good sorting algorithm, to sort objects.

Read more: https://javarevisited.blogspot.com/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html#ixzz5oRMikpdq
 */

public class Ex34_StringPermutation {

    /**
     * Test class to sort array of integers using Quicksort algorithm in Java.
     *
     * @author Javin Paul
     */
    String[] res;

    public static void main(String[] args) {

        solution("abcd");


    }

    public static void solution(String word) {
        permutation(word, "");


    }


    private static void permutation(String perm, String word) {
        if (perm.isEmpty()) {
            System.out.println(word);
            return;
        }
        for (int i = 0; i < perm.length(); i++) {
            permutation(perm.substring(0, i) + perm.substring(i + 1), word + perm.charAt(i));

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

        solution("abc");
//        solution(array2);
//        solution(array3);
//        solution(array4);
//        solution(array5);
//        solution(array6);


        Assert.assertArrayEquals(array1, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(array2, new Integer[]{1, 2, 3, 4, 5});
        Assert.assertArrayEquals(array3, new Integer[]{1, 2, 3, 4, 5, 6});
        Assert.assertArrayEquals(array4, new Integer[]{1, 2, 3, 4});
        Assert.assertArrayEquals(array5, new Integer[]{});
        Assert.assertArrayEquals(array6, null);

    }

}