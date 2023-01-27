package com.rok.leetcode;

import java.util.*;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00001_TwoSum {
    public static void main(String[] args) {
        int[] nums = {7, 8, 2, 15};
//        int[] nums = {0,4,3,0};
//        int[] nums = {2,7,11,15};
        int target = 9;
        int[] indices = twoSum(nums, target);
        System.out.println(Arrays.toString(indices));
    }

    public static int[] twoSum1(int[] nums, int target) {
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
        int difference;

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

    public static int[] twoSum(int[] nums, int target) {

        int length = nums.length;
        int[] resultIndicesInSortedArray = new int[2];
        int[] resultIndices = {Integer.MIN_VALUE,Integer.MIN_VALUE};
        int [] copyOfNums = Arrays.copyOf(nums, length);
        Arrays.sort(copyOfNums);

        int difference;
        Integer secondIndex;
        for (int i = 0; i < length; i++) {
            difference = target - copyOfNums[i];
            secondIndex = Arrays.binarySearch(copyOfNums, i+1, length, difference);
            if (secondIndex > 0) {
                resultIndicesInSortedArray[0] = i; resultIndicesInSortedArray[1] = secondIndex;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == copyOfNums[resultIndicesInSortedArray[0]] && (resultIndices[0] < 0)) {
                resultIndices[0] = i;
            }
            else if (nums[i] == copyOfNums[resultIndicesInSortedArray[1]] && (resultIndices[1] < 0)) {
                resultIndices[1] = i;
            }
            if (resultIndices[0] + resultIndices[1] > 0) {break;}
        }
        return resultIndices;
    }

}
