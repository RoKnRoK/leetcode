package com.rok.leetcode;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class _009_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1567));
        System.out.println(isPalindrome(-19));
        System.out.println(isPalindrome(1551));
    }

    public static boolean isPalindrome(int original) {
        if (original < 0) return false;
        int copy = original;
        long reversed = 0;
        while (original > 0) {
            reversed = (reversed << 3) + (reversed << 1) + original % 10;
            original = original / 10;
        }
        return (copy == reversed);
    }
}
