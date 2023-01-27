package com.rok.leetcode;

import java.util.Arrays;

/**
 * Created by rkulikov on 19.07.16.
 * All rights reserved (c) =)
 */
public class _00006_ZigzagConversion {
    public static void main(String[] args) {
        convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 5);
//        convert("ABCD", 3);
    }

    public static String convert(String s, int N) {
        if (s.isEmpty() || N == 1) {return s;}
        int len = s.length();
        char[] word = s.toCharArray();
        int M = len / (N - 1) + 2;
        char[][] result = new char[N][M];
        int j = 0, i = 0;
        int inc = 1;
        for (int c = 0; c < len; c++) {
            result[i][j] = word[c];
            i += inc;
            if (i == 0 || i == N - 1) {j++;}
            inc = -j % 2 * 2 + 1;
        }
        int c = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (result[n][m] != 0) {
                    word[c] = result[n][m];
                    System.out.print(word[c]+" = " + c+",   ");
                    c++;
                }
            }
        }
        System.out.println(new String(word));
        return new String(word);
    }
}
