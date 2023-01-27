package com.rok.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class _00012_IntegerToRoman {

    private static Map<Integer, String> intToRoman = new HashMap<>();

    static {
        intToRoman.put(0, "");
        intToRoman.put(1, "I");
        intToRoman.put(2, "II");
        intToRoman.put(3, "III");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(6, "VI");
        intToRoman.put(7, "VII");
        intToRoman.put(8, "VIII");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(20, "XX");
        intToRoman.put(30, "XXX");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(60, "LX");
        intToRoman.put(70, "LXX");
        intToRoman.put(80, "LXXX");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(200, "CC");
        intToRoman.put(300, "CCC");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(600, "DC");
        intToRoman.put(700, "DCC");
        intToRoman.put(800, "DCCC");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");
        intToRoman.put(2000, "MM");
        intToRoman.put(3000, "MMM");
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        return intToRoman.get(num / 1000 * 1000) +
          intToRoman.get(num / 100 % 10 * 100) +
          intToRoman.get(num / 10 % 10 * 10) +
          intToRoman.get(num % 10);
    }
}
