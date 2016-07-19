package com.rok.leetcode;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _003_LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int strLength = s.length();
        String saved = "";
        String current = "";
        for (int i = 0; i < strLength; i++) {
            char character = s.charAt(i);
            int firstIndex = current.indexOf(character);
            if (firstIndex != -1) {
                if (saved.length() < current.length()) {
                    saved = current;
                }
                current = current.substring(firstIndex + 1);
            }
            current += character;
        }
        if (saved.length() < current.length()) {
            saved = current;
        }
        return saved.length();
    }
}
