package com.rok.leetcode;

import java.util.*;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00039_CombinationSum {
    public static void main(String[] args) {
        printAnswer(combinationSum(new int[]{2, 3, 6, 7}, 7));
        printAnswer(combinationSum(new int[]{2, 3, 5}, 8));
        printAnswer(combinationSum(new int[]{2}, 3));
        printAnswer(combinationSum(new int[]{2}, 1));
        printAnswer(combinationSum(new int[]{1}, 10));
        printAnswer(combinationSum(new int[]{1, 2}, 10));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return inner(candidates, 0, target);
    }

    private static List<List<Integer>> inner(int[] candidates, int from, int target) {
        List<List<Integer>> result = new ArrayList<>(20);
        for (int i = from; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return result;
            }
            if (candidates[i] == target) {
                result.add(new ArrayList<>(List.of(candidates[i])));
                return result;
            }
            List<List<Integer>> previous = inner(candidates, i , target - candidates[i]);
            if (previous.isEmpty()) {
                continue;
            }
            int finalI = i;
            previous.forEach(list -> list.add(candidates[finalI]));
            result.addAll(previous);
        }
        return result;
    }

    public static void printAnswer(List<List<Integer>> answer) {
        answer.forEach(System.out::print);
        System.out.println();
    }

}
