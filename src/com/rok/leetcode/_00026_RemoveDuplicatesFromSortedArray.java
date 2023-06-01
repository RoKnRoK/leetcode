package com.rok.leetcode;


import java.util.Arrays;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00026_RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }

    public static int removeDuplicates(int[] nums) {
        int end = 0;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == nums[end]) continue;

            /*int tmp = nums[i];
            nums[i] = nums[end+1];
            nums[end+1] = tmp;
            end += 1;*/

            //or official solution:
            nums[++end] = nums[i];
        }

        System.out.println(Arrays.toString(nums));
        return end + 1;
    }


}
