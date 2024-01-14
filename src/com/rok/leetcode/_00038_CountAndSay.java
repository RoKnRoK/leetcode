package com.rok.leetcode;

import java.util.Arrays;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00038_CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String previous = countAndSay(n-1);
        char[] previousChars = previous.toCharArray();
        char current = previousChars[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < previousChars.length; i++) {
            if (previousChars[i] == current) {
                count++;
            } else {
                result.append(count).append(current);
                current = previousChars[i];
                count=1;
            }
        }
        result.append(count).append(current);
        return result.toString();
    }

}
