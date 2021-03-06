package com.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
Check if the year is Leap or not. Being a Leap year means that it has 366 days.
 */
public class Ex17_BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer year = Integer.parseInt(sc.next());
        Ex17_BinarySearch ex17_BinarySearch = new Ex17_BinarySearch();
        System.out.println(ex17_BinarySearch.solution(year));
    }

    public Boolean solution(int year) {
        if (year % 2 == 1) return false;
        return year % 400 == 0 || (year % 4 == 0 & year % 100 != 0);
    }

    @Test
    public void testSolution() {

        GregorianCalendar gc = new GregorianCalendar();

        Assert.assertThat(solution(2012), is(gc.isLeapYear(2012)));
        Assert.assertThat(solution(0), is(gc.isLeapYear(0)));
        Assert.assertThat(solution(2013), is(gc.isLeapYear(2013)));
        Assert.assertThat(solution(2014), is(gc.isLeapYear(2014)));
        Assert.assertThat(solution(2016), is(gc.isLeapYear(2016)));

    }

}