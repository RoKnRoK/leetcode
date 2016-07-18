package com.rok.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsAsSet = new HashMap<>();
        Map<Integer, Integer> duplicates = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (numsAsSet.get(number) != null) {
                if (duplicates.get(number) == null) {
                    duplicates.put(number, i);
                }
            }
            numsAsSet.put(number, i);
        }
        int difference = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            difference = target - nums[i];
            Integer possibleIndex = numsAsSet.get(difference);
            if (possibleIndex == null) { continue;}
            if (possibleIndex == i) {
                Integer duplicateIndex = duplicates.get(difference);
                if (duplicateIndex == null) {continue;}
                else {
                    result[0] = i;
                    result[1] = duplicateIndex;
                    return result;
                }
            }

            result[0] = i;
            result[1] = possibleIndex;
            return result;
        }
        return result;
    }

}
