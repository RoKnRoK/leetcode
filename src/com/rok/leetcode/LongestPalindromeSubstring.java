package com.rok.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RoK on 15.07.2016.
 * All rights reserved =)
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ajdkasjdakkadjsaskdks"));
        System.out.println(longestPalindrome("aj"));
        System.out.println(longestPalindrome("aja"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("abbakoalala"));
        System.out.println(longestPalindrome("alalabbakabbalala"));
        System.out.println(longestPalindrome("aaaa"));

        long start = System.nanoTime();
        System.out.println(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(System.nanoTime() - start);
    }


    public static String longestPalindrome(String s){
        char[] strAsChars = addBoundaries(s.toCharArray());
        int length = strAsChars.length;
        int longestA = 0, longestB = 0;
        int left, right;
        for (int i = 1; i < length-1; i++){
            left = i - 1;  right = i + 1;
            char leftChar = strAsChars[left];
            char rightChar = strAsChars[right];
            if (leftChar == rightChar) {
                int a = left - 1;
                int b = right + 1;
                while (a > -1 && b < length && (strAsChars[a] == strAsChars[b])){
                    a--;
                    b++;
                }
                a++; b--;
                if (b - a > longestB - longestA){
                    longestA = a; longestB = b;
                }
            }
        }
        return String.valueOf(removeBoundaries(Arrays.copyOfRange(strAsChars, longestA, longestB+1)));
    }

    private static char[] addBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

    private static char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }
}
