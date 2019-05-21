package com.interview.amazon.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;

public class ArraySumEquals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the array size: ");
        Integer number = Integer.parseInt(sc.next());
        Integer[] integers = new Integer[number];
        for (int i = 0; i < number; i++) {
            integers[i] = Integer.parseInt(sc.next());
        }
        System.out.print("Type the sum number: ");
        Integer exponentialNumber = Integer.parseInt(sc.next());
        ArraySumEquals exponential = new ArraySumEquals();
        List<Integer[]> solution = exponential.solution(integers, exponentialNumber);
        solution.forEach(x -> {
            System.out.println(Arrays.asList(x).toString());
        });
    }

    public List<Integer[]> solution(Integer[] numbers, Integer sum) {
        if (numbers.length == 0 || sum == null) return Collections.EMPTY_LIST;
        List<Integer[]> result = new ArrayList<>(numbers.length);
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] + numbers[i] == sum) {
                    result.add(new Integer[]{numbers[i], numbers[j]});
                }
            }
        }

        return result;
    }

    @Test
    public void testSolution() {

        List<Integer[]> integers1 = Arrays.asList(new Integer[]{1, 4}, new Integer[]{2, 3});
        List<Integer[]> solution1 = solution(new Integer[]{1, 2, 3, 4, 5}, 5);

        List<Integer[]> integers2 = Arrays.asList(new Integer[]{0, 1}, new Integer[]{-3, 4});
        List<Integer[]> solution2 = solution(new Integer[]{0, 1, -1, -2, -3, 4, 5}, 1);

        Assert.assertThat(solution1.get(0), is(integers1.get(0)));
        Assert.assertThat(solution1.get(1), is(integers1.get(1)));
        Assert.assertThat(solution2.get(0), is(integers2.get(0)));
        Assert.assertThat(solution2.get(1), is(integers2.get(1)));
        Assert.assertThat(solution(new Integer[]{}, 5), is(Collections.EMPTY_LIST));
        Assert.assertThat(solution(new Integer[]{1, 2, 3, 4, 5}, 0), is(Collections.EMPTY_LIST));
        Assert.assertThat(solution(new Integer[]{1, 2, 3, 4, 5}, 15), is(Collections.EMPTY_LIST));
        Assert.assertThat(solution(new Integer[]{1, 2, 3, 4, 5}, 3).get(0), is(new Integer[]{1, 2}));
    }
}
