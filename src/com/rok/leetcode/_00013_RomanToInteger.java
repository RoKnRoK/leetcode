package com.rok.leetcode;


/**
 * Created by RoK.
 * All rights reserved =)
 */
public class _00013_RomanToInteger {


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
}
