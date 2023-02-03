package com.rok.leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00018_4Sum {


    public static void main(String[] args) {
//        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
//        System.out.println(fourSum(new int[]{2,2, 2, 2, 2}, 8));
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] numsInt, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(numsInt);
        long[] nums = Arrays.stream(numsInt).mapToLong(i -> i).toArray();

        int i = 0, j, k, l;


        long first = -Integer.MAX_VALUE;
        while (i < nums.length - 3) {
            if (nums[i] == first) {
                i++;
                continue;
            } else {
                first = nums[i];
            }
            j = i + 1;
            long second = -Integer.MAX_VALUE;
            while (j < nums.length - 2) {
                if (nums[j] == second) {
                    j++;
                    continue;
                } else {
                    second = nums[j];
                }
                k = j + 1;
                long third = -Integer.MAX_VALUE;
                while (k < nums.length - 1) {
                    if (nums[k] == third) {
                        k++;
                        continue;
                    } else {
                        third = nums[k];
                    }
                    l = Arrays.binarySearch(nums, k + 1, nums.length, target - ((long) nums[i] + (long) nums[j] + (long) nums[k]));
                    if (l >= 0) {
                        first = nums[i];
                        second = nums[j];
                        third = nums[k];
                        result.add(Arrays.asList(numsInt[i], numsInt[j], numsInt[k], numsInt[l]));
                        continue;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return result;
    }
}
