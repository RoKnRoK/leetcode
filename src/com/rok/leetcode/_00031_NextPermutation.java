package com.rok.leetcode;

import java.util.Arrays;

@SuppressWarnings({"unused", "WeakerAccess"})
public class _00031_NextPermutation {

    public static void main(String[] args) {
        nextPermutation(new int[]{10, 3});
        nextPermutation(new int[]{2, 10, 3});
        nextPermutation(new int[]{1,2,3,4});
        nextPermutation(new int[]{1,3,4,2});
        nextPermutation(new int[]{2,4,3,1});
        nextPermutation(new int[]{4,3,2,1});
        nextPermutation(new int[]{1,1,1});
        nextPermutation(new int[]{2,1,1});
        nextPermutation(new int[]{1,5,1});
    }

    public static void nextPermutation(int[] nums) {
        int swap = 0;
        int tmp;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i-1]) {
                        swap = j;
                    }
                }
                tmp = nums[i-1];
                nums[i-1] = nums[swap];
                nums[swap] = tmp;
                Arrays.sort(nums, i, nums.length);
                System.out.println(Arrays.toString(nums));
                return;
            } else if (i == 1) {
                Arrays.sort(nums);
                System.out.println(Arrays.toString(nums));
            }
        }
    }
}
