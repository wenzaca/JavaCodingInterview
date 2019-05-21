package com.interview.amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;


/*
Write a program to remove duplicates from an array in Java without using the
Java Collection API. The array can be an array of String, Integer or Character,
your solution should be independent of the type of array. If you want to
practice more array based questions then see this list of top 30 array interview
questions from Java interviews.

Read more: https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html#ixzz5nDTSFbko
 */
public class Ex9_RemoveDuplicate {
    public Object[] solution(Object[] array) {
        Map<Object, String> map = new HashMap<>();
        Object[] res = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            map.computeIfAbsent(array[i], key -> {
                map.put(key, "");
                res[map.size() / 2] = key;
                return "";
            });
        }

        return res;
    }

    @Test
    public void testSolution() {
        Assert.assertThat(solution(new Integer[]{1, 2, 2, 3, 4, 5, 2, 6})[2].toString(), is(String.valueOf(3)));
        Assert.assertThat(solution(new String[]{"hi", "hello", "hi", "hole", "hey", "hey"})[2].toString(), is("hole"));
        Assert.assertThat(solution(new Character[]{'h', 'o', 'i', 'h', 'y', 'y'})[3].toString(), is("y"));
    }
}