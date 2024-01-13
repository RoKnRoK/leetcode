package com.rok.leetcode;

public class _00035_SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{5, 7, 8, 9, 11, 100}, 7));
        System.out.println(searchInsert(new int[]{5, 7, 8, 9, 11, 100}, 99));
        System.out.println(searchInsert(new int[]{5, 7, 8, 9, 11, 100}, 100));
        System.out.println(searchInsert(new int[]{5, 7, 8, 9, 11, 100}, 101));
        System.out.println(searchInsert(new int[]{5, 7, 8, 9, 11, 100}, 4));
        System.out.println(searchInsert(new int[]{10, 20, 30, 40}, 25));
        System.out.println(searchInsert(new int[]{}, 0));
        System.out.println(searchInsert(new int[]{5}, 4));
        System.out.println(searchInsert(new int[]{5}, 5));
        System.out.println(searchInsert(new int[]{5}, 6));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return searchBinary(nums, 0, nums.length - 1, target);
    }

    private static int searchBinary(int[] nums, int start, int end, int target) {
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        if (target < nums[start]) {
            return Math.max(0, start - 1);
        }
        if (start == end) {
            return start;
        }
        if (start == end - 1) {
            return end;
        }
        int middle = start + (end - start) / 2;
        return target > nums[middle]
                ? searchBinary(nums, middle, end, target)
                : searchBinary(nums, start, middle, target);
    }
}
