package com.interview;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;


/*
You need to write a Java program to print above pyramid pattern. How many levels the pyramid
triangle would have will be decided by the user input. You can print this kind of pattern by
using print() and println() method from System.out object. System.out.print() just prints the
String or character you passed to it, without adding a new line, useful to print stars in the same line.
While, System.out.println() print characters followed by a newline character, which is useful to move to next line.
You can also use Scanner class to get input from the user and draw pyramid up to that level only.
For example in above diagram, the pyramid has 5 levels.

Read more: http://www.java67.com/2015/10/how-to-print-pyramid-pattern-in-java-example.html#ixzz5nJLMknu9
 */
public class Ex10_PrintingPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.next());
        Ex10_PrintingPattern ex10_printingPattern = new Ex10_PrintingPattern();
        ex10_printingPattern.solution(number);
    }

    public void solution(int number) {

        String star = "* ";


        for (int i = 0; i < number; i++) {
            for (int j = 0; j < (number - i); j++) {
                System.out.print(" ");
            }
            System.out.print(star);
            star += "* ";
            System.out.println();
        }

    }

    @Test
    public void testSolution() {

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        solution(3);
        Assert.assertThat("* \n* * \n* * * \n", is(outContent.toString()));
    }
}