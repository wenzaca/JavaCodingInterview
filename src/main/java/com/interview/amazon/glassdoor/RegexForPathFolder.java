package com.interview.amazon.glassdoor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;

/*
Given input string which represents path (foo/bar/$id), how would you write a function which returns $id?
 */
public class RegexForPathFolder {

    final String regex = "\\/?\\w+\\/\\w+\\/(.*)";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the path following the pattern foo/bar/DESIRED: ");
        String word = sc.next();
        RegexForPathFolder longestNonRepetitiveSubString = new RegexForPathFolder();
        System.out.println(longestNonRepetitiveSubString.solution(word));

    }

    public String solution(String word) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(word);
        String result = "";
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                result = matcher.group(i);
            }
        }
        return result;
    }

    @Test
    public void testSolution() {

        Assert.assertThat(solution("test/works/maybe"), is("maybe"));
        Assert.assertThat(solution("/test/slash/begin"), is("begin"));
        Assert.assertThat(solution("test/123"), is(""));
        Assert.assertThat(solution("///test"), is(""));
    }
}
