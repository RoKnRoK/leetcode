package com.rok.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00017_LetterCombinationsOfPhoneNumber {

    private static Map<Character, List<String>> numbers = new HashMap<>();

    static {
        numbers.put('1', new ArrayList<>());
        numbers.put('2', Arrays.asList("a", "b", "c"));
        numbers.put('3', Arrays.asList("d", "e", "f"));
        numbers.put('4', Arrays.asList("g", "h", "i"));
        numbers.put('5', Arrays.asList("j", "k", "l"));
        numbers.put('6', Arrays.asList("m", "n", "o"));
        numbers.put('7', Arrays.asList("p", "q", "r", "s"));
        numbers.put('8', Arrays.asList("t", "u", "v"));
        numbers.put('9', Arrays.asList("w", "x", "y", "z"));
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("378"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        List<List<String>> lists = new ArrayList<>();
        for (char digit : digits.toCharArray()) {
            lists.add(numbers.get(digit));
        }
        return cartesianProduct(lists).stream().filter(f -> !f.isEmpty()).collect(Collectors.toList());
    }

    protected static List<String> cartesianProduct(List<List<String>> lists) {
        if (lists.size() == 0) {
            return Collections.singletonList("");
        }

        List<String> resultList = new ArrayList<>();
        List<String> firstList = lists.get(0);
        List<String> remainingLists = cartesianProduct(lists.subList(1, lists.size()));
        for (String string1 : firstList) {
            for (String string2 : remainingLists) {
                resultList.add(string1 + string2);
            }
        }
        return resultList;
    }
}
