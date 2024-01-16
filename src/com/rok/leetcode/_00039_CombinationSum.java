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
        printAnswer(combinationSum(new int[]{1,2}, 10));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>(20);
        inner(result, candidates, target);
        return result;
    }

    private static void inner(List<List<Integer>> result, int[] candidates, int target) {
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] > target) {
                continue;
            }
            int newTarget = target - candidates[i];
            if (newTarget == 0) {
                result.add(new ArrayList<>(List.of(candidates[i])));
            } else {
                List<List<Integer>> previous = combinationSum(
                        Arrays.copyOf(candidates, i+1), newTarget
                );
                int finalI = i;
                previous.forEach(list -> list.add(candidates[finalI]));
                result.addAll(previous);
            }
        }
    }

    public static void printAnswer(List<List<Integer>> answer){
        answer.forEach(System.out::print);
        System.out.println();
    }

}
