package com.rok.leetcode;

import java.util.Arrays;

@SuppressWarnings({"unused", "WeakerAccess"})
public class _00034_FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2,2,2,2,8,8,8,8,8,8,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)  {return new int[]{-1, -1};}
        if (nums.length == 1)  {return new int[]{ nums[0] == target ? 0 : -1, nums[0] == target ? 0 : -1};}
        if (nums.length == 2)  {
            if (nums[0] == target && nums[1] != target) {
                return new int[]{ 0, 0};
            }
            if (nums[0] != target && nums[1] == target) {
                return new int[]{ 1, 1};
            }
            if (nums[0] == target && nums[1] == target) {
                return new int[]{ 0, 1};
            }
            return new int[]{ -1, -1};
        }
        int start = 0;
        int end = nums.length - 1;
        int middle = start + (end - start) / 2;
        return new int[]{
            searchBinaryMin(nums, start, end, target),
            searchBinaryMax(nums, start, end, target)
        };
    }

    private static int searchBinaryMin(int[] nums, int start, int end, int target) {
        if (end == start) { return nums[end] == target ? end : -1;}
        if (end - start == 1) {
            return nums[start] == target ? start : (nums[end] == target ? end : -1);
        }
        int middle = start + (end - start) / 2;
        return target <= nums[middle]
                ? searchBinaryMin(nums, start, middle, target)
                : searchBinaryMin(nums, middle, end, target);
    }

    private static int searchBinaryMax(int[] nums, int start, int end, int target) {
        if (end == start) { return nums[end] == target ? end : -1;}
        if (end - start == 1) {
            return nums[end] == target ? end : (nums[start] == target ? start : -1);
        }
        int middle = start + (end - start) / 2;
        return target >= nums[middle]
                ? searchBinaryMax(nums, middle, end, target)
                : searchBinaryMax(nums, start, middle, target);
    }
}
