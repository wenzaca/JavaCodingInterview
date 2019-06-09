package com.interview.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;

/*
Check if parenthesis and brackets are balanced in a string
 */
public class CheckIfParenthesisAndBracketsAreBalanced {

        // Time Complexity is O(1)?

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Type the string: ");
            String word = sc.next();
            CheckIfParenthesisAndBracketsAreBalanced checkIfParenthesisAndBracketsAreBalanced = new CheckIfParenthesisAndBracketsAreBalanced();
            System.out.println(checkIfParenthesisAndBracketsAreBalanced.solution(word));

        }

        public Boolean solution(String word) {
            if (word == null || word.isEmpty()) return true;
            Pattern patBracketOpen = Pattern.compile("\\[");
            Pattern patBracketClose = Pattern.compile("\\]");
            Pattern patParenthesisOpen = Pattern.compile("\\(");
            Pattern patParenthesisClose = Pattern.compile("\\)");

            Integer parenthesisCount = 0;
            Matcher matOpen = patParenthesisOpen.matcher(word);
            Matcher matClose = patParenthesisClose.matcher(word);
            while (matOpen.find()){
                parenthesisCount++;
            }
            while (matClose.find()){
                parenthesisCount--;
            }

            Integer bracketCount = 0;
            matOpen = patBracketOpen.matcher(word);
            matClose = patBracketClose.matcher(word);
            while (matOpen.find()){
                bracketCount++;
            }
            while (matClose.find()){
                bracketCount--;
            }

            if(parenthesisCount != 0 || bracketCount != 0) return false;
            return true;
        }

        @Test
        public void testSolution() {

            Assert.assertThat(solution("hey [ this is a test] right? (maybe)"), is(true));
            Assert.assertThat(solution("hey [ this is a test] right? (maybe), I am not sure about this ["), is(false));
            Assert.assertThat(solution("[[[[[[[))))]]]]]][[[[[[[)))))))))(()()()))((]]][]["), is(false));
            Assert.assertThat(solution("[)]([]"), is(true));
            Assert.assertThat(solution(null), is(true));
            Assert.assertThat(solution(""), is(true));
        }
    }

