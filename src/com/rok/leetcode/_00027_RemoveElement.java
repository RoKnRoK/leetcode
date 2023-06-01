package com.rok.leetcode;


import java.util.Arrays;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class _00027_RemoveElement {


    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1}, 2));
        System.out.println(removeElement(new int[]{1}, 1));
        System.out.println(removeElement(new int[]{5,4}, 4));
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 5));
    }

    public static int removeElement(int[] nums, int val) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                /*int tmp = nums[i];
                nums[i] = nums[end];
                nums[end] = tmp;
                end++; */

                //official
                nums[end++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return end;
    }


}
