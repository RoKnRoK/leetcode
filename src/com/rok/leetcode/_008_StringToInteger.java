package com.rok.leetcode;

import java.util.Arrays;

/**
 * Created by rkulikov on 19.07.16.
 * All rights reserved (c) =)
 */
public class _008_StringToInteger {
    private static long[] tenDegrees = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
    public static void main(String[] args) {

        int result = myAtoi("-145273631");
        result = myAtoi("-9999999999");
        result = myAtoi("9999999999");
        result = myAtoi(Integer.toString(Integer.MAX_VALUE));
        result = myAtoi(Integer.toString(Integer.MIN_VALUE));
        result = myAtoi("0");
        result = myAtoi("9");
        result = myAtoi("");
        result = myAtoi("      ");
        result = myAtoi("  45 67    ");
        result = myAtoi("  45fj&*56");
        result = myAtoi("-0");
        result = myAtoi("-0001");
        result = myAtoi("-0010");
        result = myAtoi("00108");
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {return  0;}

        char[] asChar = str.toCharArray();
        int maxRank = (asChar[0] == '-' ? str.length() - 1 : str.length()) - 1;

        int start = asChar[0] == '-' ? 1 : 0;
        long result = 0;
        int shiftedMaxRank = maxRank + start;
        int digit;
        for (int i=start;i<= shiftedMaxRank;i++){
            digit = asChar[i] - 48;
            if (digit > 9 || digit < 0) {break; }
            result += digit * tenDegrees[shiftedMaxRank - i];
        }
        if (start == 1) {result = -result;}
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            System.out.println(0);
            return 0;
        }
        System.out.println(result);
        return (int) result;
    }

    public static int myAtoi2(String str) {
        char[] asChar = str.toCharArray();
        boolean negative = asChar[0] == '-';
        if (negative) { asChar = Arrays.copyOfRange(asChar, 1, str.length()); }
        int maxRank = asChar.length -1 ;

        long result = 0;
        for (int i= 0;i<= maxRank;i++){
            result += (asChar[i]-48) * tenDegrees[maxRank - i];
        }
        if (negative) {result = -result;}
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            System.out.println(result);
            return 0;
        }
        System.out.println(result);
        return (int) result;
    }
}
