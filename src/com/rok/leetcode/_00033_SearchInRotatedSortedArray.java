package com.rok.leetcode;

@SuppressWarnings({"unused", "WeakerAccess"})
public class _00033_SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{5,1,2,3,4}, 1));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 6));
        System.out.println(search(new int[]{4,5,6,7,8,0,1,2}, 8));
        System.out.println(search(new int[]{7,8,0,1,2,4,5,6}, 8));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{0,1,2,4,5,6,7}, 6));
        System.out.println(search(new int[]{0}, 6));
        System.out.println(search(new int[]{5}, 5));
        System.out.println(search(new int[]{5, 2}, 2));
        System.out.println(search(new int[]{5, 2}, 5));
        System.out.println(search(new int[]{5, 2}, 3));
        System.out.println(search(new int[]{5, 2}, 6));
        System.out.println(search(new int[]{5, 2}, 0));
        System.out.println(search(new int[]{3,5,1}, 3));

    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return nums[start] > nums[end]
                ? searchFlipped(nums, start, end, target)
                : searchBinary(nums, start, end, target);
    }

    private static int searchFlipped(int[] nums, int start, int end, int target) {
        if (end == start) { return nums[end] == target ? end : -1;}
        if (end - start == 1) {
            return nums[end] == target ? end : (nums[start] == target ? start : -1);
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] == target) return middle;
        if (nums[middle] > nums[end]) {
            return target >= nums[start] && target <= nums[middle]
                    ? searchBinary(nums, start, middle, target)
                    : searchFlipped(nums, middle, end, target);
        } else {
            return target >= nums[middle] && target <= nums[end]
                    ? searchBinary(nums, middle, end, target)
                    : searchFlipped(nums, start, middle, target);
        }
    }

    private static int searchBinary(int[] nums, int start, int end, int target) {
        if (end == start) { return nums[end] == target ? end : -1;}
        if (end - start == 1) {
            return nums[end] == target ? end : (nums[start] == target ? start : -1);
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] == target) return middle;
        return target > nums[middle]
                ? searchBinary(nums, middle, end, target)
                : searchBinary(nums, start, middle, target);
    }
}
