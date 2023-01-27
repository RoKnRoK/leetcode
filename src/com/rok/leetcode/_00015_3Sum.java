package com.rok.leetcode;


import java.util.*;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00015_3Sum {


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{-4, -1, -1,0,1,2}));
        System.out.println(threeSum(new int[]{1,1,-2}));
        System.out.println(threeSum(new int[]{-1,-1,-1}));
        System.out.println(threeSum(new int[]{-1,-1,2}));
        System.out.println(threeSum(new int[]{0,0,0}));
        System.out.println(threeSum(new int[]{0,0,0,0,0,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        int i = 0, j, k;

        int first = - Integer.MAX_VALUE;
        int second = - Integer.MAX_VALUE;

        while (nums[i] <= 0){
            if (i == nums.length - 2) {
                break;
            }
            if (nums[i] == first) {
                i++;
                continue;
            } else {
                first = nums[i];
            }
            j = i + 1;
            while (j < nums.length - 1){
                if (nums[j] == second) {
                    j++;
                    continue;
                } else {
                    second = nums[j];
                }
                k = Arrays.binarySearch(nums, j+1, nums.length,  - (nums[i] + nums[j]));
                if (k >= 0) {
                    first = nums[i];
                    second = nums[j];
                    result.add(Arrays.asList(first, second, nums[k]));
                    continue;
                }
                j++;
            }
            i++;
        }
        return result;
    }
}
