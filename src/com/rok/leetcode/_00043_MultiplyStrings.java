package com.rok.leetcode;

import java.util.Arrays;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00043_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
        System.out.println(multiply("5", "6"));
        System.out.println(multiply("54", "6"));
        System.out.println(multiply("5", "64"));
        System.out.println(multiply("99", "99"));
        System.out.println(multiply("999", "999"));
        System.out.println(multiply("2885", "1"));
        System.out.println(multiply("2", "11111"));
    }

    public static String multiply(String num1, String num2) {
        int num1Length = num1.length();
        int num2Length = num2.length();
        char[] result = new char[num1Length*num2Length + 1];
        Arrays.fill(result, '0');
        int shift = 0;
        int mult, rem;
        for (int i = num1Length - 1; i >= 0; i--) {
            rem = 0;
            for (int j = num2Length - 1; j >= 0; j--) {
                mult = toInt(num1.charAt(i)) * toInt(num2.charAt(j));
                int resI = num2Length - j - 1 + shift;
                int tmp = toInt(result[resI]) + mult % 10 + rem;
                result[resI] = (char)(tmp%10 + 48);
                rem = mult / 10 + tmp/10;
            }
            result[num2Length + shift] = (char)(toInt(result[num2Length + shift]) + rem + 48);
            shift++;
        }
        var builder = new StringBuilder();
        boolean leadingZero = true;
        for (int i = result.length - 1; i >= 0; i--) {
            char c = result[i];
            if (c != '0' || !leadingZero) {
                builder.append(c);
                leadingZero = false;
            }
        }
        String answer = builder.toString();
        return answer.isEmpty() ? "0" : answer;
    }

    private static int toInt(char ch) {
        return ch - 48;
    }
}
