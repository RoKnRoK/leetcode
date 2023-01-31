package com.rok.leetcode;


import java.util.Arrays;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00016_3SumClosest {


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(threeSumClosest(new int[]{-1,0,1,2,-1,-4}, 1));
        System.out.println(threeSumClosest(new int[]{-4, -1, -1,0,1,2}, 2));
        System.out.println(threeSumClosest(new int[]{1,1,-2}, 2));
        System.out.println(threeSumClosest(new int[]{-1,-1,-1}, 3));
        System.out.println(threeSumClosest(new int[]{-1,-1,2}, 1));
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(threeSumClosest(new int[]{0,0,0,0,0,0}, 2));
        System.out.println(threeSumClosest(new int[]{1,1,1,1}, 0));
        System.out.println(threeSumClosest(new int[]{-1000,-5,-5,-5,-5,-5,-5,-1,-1,-1}, -14));
    }

    public static Integer threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int i = 0, j, k;

        int minDistance = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        int first = - Integer.MAX_VALUE;
        while (i < nums.length - 2){
            if (nums[i] == first) {
                i++;
                continue;
            } else {
                first = nums[i];
            }
            j = i + 1;
            int second = - Integer.MAX_VALUE;
            while (j < nums.length - 1){
                if (nums[j] == second) {
                    j++;
                    continue;
                } else {
                    second = nums[j];
                }
                k = Arrays.binarySearch(nums, j+1, nums.length,  target - (nums[i] + nums[j]));
                if (k >= 0) {
                    first = nums[i];
                    second = nums[j];
                    return first + second + nums[k];
                } else {
                    int insertPoint = -k - 1;
                    int distance;
                    if (insertPoint == nums.length) {
                        distance = nums[i] + nums[j] + nums[insertPoint-1];
                    } else if (insertPoint == j + 1) {
                        distance = nums[i] + nums[j] + nums[insertPoint];
                    } else {
                        int candidate1 = nums[i] + nums[j] + nums[insertPoint];
                        int candidate2 = nums[i] + nums[j] + nums[insertPoint - 1];
                        if (Math.abs(candidate1 - target) < Math.abs(candidate2 - target)) {
                            distance = candidate1;
                        } else {
                            distance = candidate2;
                        }

                    }
                    if (Math.abs(distance - target) < minDistance) {
                        minDistance = Math.abs(distance - target);
                        minSum = distance;
                    }
                }
            }
            i++;
        }
        return minSum;
    }
}
