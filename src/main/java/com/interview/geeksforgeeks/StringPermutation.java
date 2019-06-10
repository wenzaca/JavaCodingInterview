package com.interview.geeksforgeeks;

import java.util.Scanner;

public class StringPermutation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Type your string: ");
        solution(scan.next());
    }

    public static void solution(String word){

        permutation(word, "");
    }

    private static void permutation(String word, String s) {

        if(word.isEmpty()){
            System.out.println(s);
            return;
        }
        for(int i = 0; i<word.length();i++){
            permutation(word.substring(0,i) + word.substring(1+i), s+word.charAt(i));
        }
    }
}
