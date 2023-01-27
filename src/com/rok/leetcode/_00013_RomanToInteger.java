package com.rok.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings("unused")
public class _00013_RomanToInteger {

    private static Map<Character, Integer> romanToInt = new HashMap<>();

    static {
        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        char prev = '0';
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' : {
                    if (prev == 'V' || prev == 'X') {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                } break;
                case 'V' : {
                    result += 5;
                } break;
                case 'X' : {
                    if (prev == 'L' || prev == 'C') {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                } break;
                case 'L' : {
                    result += 50;
                } break;
                case 'C' : {
                    if (prev == 'D' || prev == 'M') {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                } break;
                case 'D' : {
                    result += 500;
                } break;
                case 'M' : {
                    result += 1000;
                } break;
            }
            prev = s.charAt(i);
        }
        return result;
    }

    private static int romanToIntWithMap(String s) {
        char prev = '0';
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            int koeff = (current == 'I' && (prev == 'V' || prev == 'X')) ||
                    (current == 'X' && (prev == 'L' || prev == 'C')) ||
                    (current == 'C' && (prev == 'D' || prev == 'M')) ? -1 : 1;
            result += koeff*romanToInt.get(current);
            prev = current;
        }
        return result;
    }
}
