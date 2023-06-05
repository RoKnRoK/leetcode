package com.rok.leetcode;


import java.util.Arrays;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00028_FindTheIndexOfTheFirstOccurrenceInAString {


    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("sabutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("leetcode", ""));
        System.out.println(strStr("", "abc"));
        System.out.println(strStr("leetcode", "e"));
        System.out.println(strStr("a", "abc"));
        System.out.println(strStr("lappcode", "e"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.isEmpty()) return -1;
        if (needle.isEmpty()) return 0;
        int answer = -1;
        char n1 = needle.charAt(0);
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            char h = haystack.charAt(i);
            if (h == n1) {
                answer = i;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        answer = -1;
                        break;
                    }
                }
                if (answer != -1) return answer;
            }
        }
        return answer;
    }


}
