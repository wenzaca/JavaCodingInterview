package com.interview.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
Merge 2 sorted Arrays of the same size into 1 Sorted array
*/
public class MergeSortedArraysToSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the array size: ");
        Integer number = Integer.parseInt(sc.next());
        Integer[] integers = new Integer[2*number];
        int i;
        for (i = 0; i < number; i++) {
            integers[i] = Integer.parseInt(sc.next());
        }
        System.out.print("Type the values for second array: \n");
        for (i = number; i < 2 * number; i++) {
            integers[i] = Integer.parseInt(sc.next());
        }
        merge(integers, 0, integers.length/2, integers.length);
        for(Integer intValue : integers){
            System.out.println(intValue);
        }
    }

    // Same merge from Merge Sort.
    public static void merge(Integer[] array, int start, int mid, int end) {

        if(array[mid-1] <= array[mid]){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;
        Integer[] tempArray = new Integer[end-start];

        while (i< mid && j < end){
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start+tempIndex, mid - i);
        System.arraycopy(tempArray, 0, array, start, tempIndex); // if there is any leftovers on the left array, for example {32,36} and {33,34}
    }

    @Test
    public void testMerge(){
        Integer[] test1 = new Integer[]{1,2,4,5,8,3,6,8,9,10};
        Integer[] test2 = new Integer[]{1,2,4,5,8,9,10,11,12,13};
        Integer[] test3 = new Integer[]{3,6,8,9,10,11,1,4,5,8,10,12,18};
        Integer[] test4 = new Integer[]{9,10,11,12,13,14,1,2,4,5,8,8};

        merge(test1, 0, test1.length/2, test1.length);
        merge(test2, 0, test2.length/2, test2.length);
        merge(test3, 0, test3.length/2, test3.length);
        merge(test4, 0, test4.length/2, test4.length);


        Assert.assertThat(test1, is(new Integer[]{1,2,3,4,5,6,8,8,9,10}));
        Assert.assertThat(test2, is(new Integer[]{1,2,4,5,8,9,10,11,12,13}));
        Assert.assertThat(test3, is(new Integer[]{1,3,4,5,6,8,8,9,10,10,11,12,18}));
        Assert.assertThat(test4, is(new Integer[]{1,2,4,5,8,8,9,10,11,12,13,14}));
    }

}
