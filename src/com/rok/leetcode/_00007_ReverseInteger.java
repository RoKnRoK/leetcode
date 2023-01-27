package com.rok.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoK on 17.07.2016.
 * All rights reserved =)
 */
public class _00007_ReverseInteger {
    private static long[] tenDegrees = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    public static void main(String[] args) {
//        long timer = System.nanoTime(); System.out.println(reverse(-2147483648));
//        System.out.println(System.nanoTime() - timer);


        int result = 0;
        long timer = 0;
        long total = 0;
        int N = 1000000;
        for (int i = 0; i < N; i++){
            timer = System.nanoTime();
//            result = reverse2(-1452736301);
            result = reverse(-145273631);
//            result = reverse2(1232342359);
//        result = reverse2(-145273637);
//        result = reverse2(100);
//        result = reverse2(974);
            total += (System.nanoTime() - timer);
        }
        System.out.println(result);
        System.out.println("reverse2:" +total/N);

        total=0;
        for (int i = 0; i < N; i++){
            timer = System.nanoTime();
            result = reverse(-1452736301);
//            result = reverse(1232342359);
//        result = reverse(-145273637);
//        result = reverse(100);
//        result = reverse(974);
            total += (System.nanoTime() - timer);
        }
        System.out.println(result);
        System.out.println("reverse:" +total/N);
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        if (x == Integer.MIN_VALUE) {return 0;}

        int maxRank = (int) Math.log10(Math.abs(x));

        if (maxRank == 0) {return x;}

        int[] digits = new int[maxRank+1];

        for (int i = 0; i <= maxRank ; i ++){
            digits[i] = x / (int)tenDegrees[maxRank - i];
        }

        long result = 0;
        long mostLeftDigit, mostRightDigit;
        int middle = maxRank / 2;
        middle = (maxRank%2 == 0) ? middle - 1 : middle;

        for (int i = 0; i <= middle; i++) {
            mostLeftDigit = digits[maxRank - i];
            mostRightDigit = digits[i];
            result += mostRightDigit * tenDegrees[maxRank - i] + mostLeftDigit* tenDegrees[i];
        }
        if (maxRank%2 == 0) { result = result + x / tenDegrees[middle + 1] % 10 * tenDegrees[middle + 1];}
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (result);
    }

    public static int reverse2(int x) {
        if (x == 0) return 0;
        if (x == Integer.MIN_VALUE) {return 0;}

        int maxRank = (int) Math.log10(Math.abs(x));

        if (maxRank == 0) {return x;}

        long result = 0;
        long mostLeftDigit;
        int mostRightDigit;
        int middle = maxRank / 2;
        int temp;
        middle = (maxRank%2 == 0) ? middle - 1 : middle;

        for (int i = 0; i <= middle; i++) {
            mostRightDigit = x %10;
            temp = maxRank - (2 * i);
            mostLeftDigit = x / tenDegrees[temp];
            result += mostRightDigit * tenDegrees[maxRank - i] + mostLeftDigit* tenDegrees[i];
            x = (int) ((x - mostLeftDigit * tenDegrees[temp]) / 10);
        }
        if (maxRank%2 == 0) { result = result + x*tenDegrees[middle+1];}
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (result);
    }

}
