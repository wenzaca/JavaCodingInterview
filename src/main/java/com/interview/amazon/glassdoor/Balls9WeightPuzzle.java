package com.interview.amazon.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
9 balls weight puzzle
 */
public class Balls9WeightPuzzle {

    enum Scale {
        LEFT, RIGHT, MIDDLE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the heavier ball position (0-8): ");
        Integer position = sc.nextInt();

        Balls9WeightPuzzle balls9WeightPuzzle = new Balls9WeightPuzzle();
        System.out.println(balls9WeightPuzzle.solution(position));
    }

    public Integer solution(Integer position) {
        if (position == null) return 0;
        Map<Integer, Integer> balls = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            balls.compute(i, (key, value) -> {
                if (key == position) return 2;
                return 1;
            });
        }
        Integer balls1 = 0, balls2 = 0;
        for (Map.Entry<Integer, Integer> entry : balls.entrySet()) {
            if (entry.getKey() < 3)
                balls1 += entry.getValue();
            else if (entry.getKey() < 6)
                balls2 += entry.getValue();
            else
                break;
        }

        switch (scale(balls1, balls2)) {
            case LEFT:
                return calculateHeavyBallFromTheGroup(balls.get(0), balls.get(1));
            case RIGHT:
                return calculateHeavyBallFromTheGroup(balls.get(3), balls.get(4)) + 3;
            default:
                return calculateHeavyBallFromTheGroup(balls.get(6), balls.get(7)) + 6;
        }

    }

    private Integer calculateHeavyBallFromTheGroup(Integer ball1, Integer ball2) {

        switch (scale(ball1, ball2)) {
            case LEFT:
                return 0;
            case RIGHT:
                return 1;
            default:
                return 2;
        }
    }

    private Scale scale(Integer left, Integer right) {
        if (left > right) return Scale.LEFT;
        else if (left < right) return Scale.RIGHT;
        else return Scale.MIDDLE;
    }

    @Test
    public void testSolution() {

        Assert.assertThat(solution(3), is(3));
        Assert.assertThat(solution(4), is(4));
        Assert.assertThat(solution(null), is(0));
    }
}
