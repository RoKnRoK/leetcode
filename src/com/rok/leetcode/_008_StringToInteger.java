package com.rok.leetcode;

import java.util.Arrays;
import java.util.Objects;

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
        result = myAtoi("  445f456475b3456");
        result = myAtoi("fj&*56");
        result = myAtoi("-0");
        result = myAtoi("-0001");
        result = myAtoi("-0010");
        result = myAtoi("00108");
        result = myAtoi("2536558709455607867");
        result = myAtoi("2536558709455607867g25365587094556078678");
        result = myAtoi("+00108");
        result = myAtoi("+1");
        result = myAtoi("+17sdfs+6");
        result = myAtoi("-2147483647");

        System.out.println(result);
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
//            System.out.println(0);
            return  0;
        }

        if (Objects.equals(str, Integer.toString(-Integer.MAX_VALUE))) {return -Integer.MAX_VALUE;}


        char[] asChar = str.toCharArray();
        int shift = (asChar[0] ==  '-' ? 1 : (asChar[0] ==  '+' ? 1 : 0));
        boolean negative = asChar[0] ==  '-';
        char leftChar, rightChar;
        int leftRank, rightRank= 0;
        long leftResult = 0, rightResult = 0, finalResult = 0;

        for (int fromLeftToRight=shift, fromRightToLeft= asChar.length-1;
             fromLeftToRight<asChar.length || fromRightToLeft>shift;
             fromLeftToRight++, fromRightToLeft--){
            leftChar = asChar[fromLeftToRight];
            rightChar = asChar[fromRightToLeft];

            if (leftChar < 48 || leftChar > 57) {
                if (fromLeftToRight == shift) {
                    return 0;
                }
                leftRank = fromLeftToRight;
                if (leftRank-1 > 10) {
                    finalResult = Integer.MAX_VALUE;
                    break;
                }
                for (int back = leftRank - 1; back >= shift; back--){
                    leftResult += (asChar[back] - 48) * tenDegrees[leftRank-1 - back];
                }
                finalResult = leftResult;
                break;
            }
            if (rightChar < 48 || rightChar > 57) {
                rightResult = 0;
                rightRank = 0;
            }

            if (rightRank > 10) {
                rightResult = Integer.MAX_VALUE;
            }
            else {
                rightResult += (rightChar - 48) * tenDegrees[rightRank];
            }
            rightRank ++;
            finalResult = rightResult;
//            System.out.println(leftResult+", " + rightResult);
        }
        if (finalResult == Integer.MAX_VALUE && negative) {
            return Integer.MIN_VALUE;
        }

        finalResult = (negative ? -finalResult : finalResult);
        if (finalResult > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (finalResult < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
//        System.out.println(finalResult);
        return (int) finalResult;
    }
}
