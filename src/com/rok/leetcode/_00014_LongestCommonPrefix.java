package com.rok.leetcode;


/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00014_LongestCommonPrefix {


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"abbd", "abbddbdjs", "abb"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "b"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "a", "b"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "a", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String firstWord = strs[0];
        StringBuilder longestPrefix = new StringBuilder();
        for (int i = 0; i < firstWord.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if ((str.length() < i + 1) || (firstWord.charAt(i) != str.charAt(i))) {
                    return longestPrefix.toString();
                }
            }
            longestPrefix.append(firstWord.charAt(i));
        }
        return longestPrefix.toString();
    }
}
