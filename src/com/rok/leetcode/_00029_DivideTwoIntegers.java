package com.rok.leetcode;


/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00029_DivideTwoIntegers {


    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(-63, -9));
        System.out.println(divide(Integer.MAX_VALUE, 2));
        System.out.println(divide(Integer.MAX_VALUE, -2));
        System.out.println(divide(Integer.MIN_VALUE, -2));
        System.out.println(divide(Integer.MIN_VALUE, 2));
        System.out.println(divide(Integer.MIN_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(Integer.MAX_VALUE, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }
        long longDividend = dividend;
        long longDivisor = divisor;
        int quotinent = 0;
        boolean negative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);
        long remainder = Math.abs(longDividend);
        long positiveDivisor = Math.abs(longDivisor);
        while (remainder >= positiveDivisor ) {
            quotinent++;
            remainder -= positiveDivisor;
        }
        return negative ? -quotinent : quotinent;
    }


}
