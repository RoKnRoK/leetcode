package com.rok.leetcode;

/**
 * Created by RoK.
 * All rights reserved =)
 */
@SuppressWarnings("unused")
public class _00011_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));

    }

    //intuitive solution - time limit exceeded
    public static int maxAreaIntuintive(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    //better, accepted solution: each line i produces two areas, and these areas will be maximized,
    // when j is farthest from i in both directions, and height[j] >= height[i].
    // So I'm searching for j starting from the end and the beginning of array, calculating area and comparing with maxArea,
    //stopping the search when j is found.
    private static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] >= height[i]) {
                    maxArea = Math.max(maxArea, (j - i) * height[i]);
                    break;
                }
            }
            for (int j = 0; j < i; j++) {
                if (height[j] >= height[i]) {
                    maxArea = Math.max(maxArea, (i - j) * height[i]);
                    break;
                }
            }
        }
        return maxArea;
    }

    // Official solution.
    // Initially we consider the area constituting the exterior most lines.
    // Now, to maximize the area, we need to consider the area between the lines of larger lengths.
    // If we try to move the pointer at the longer line inwards, we won't gain any increase in area,
    // since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial,
    // as per the same argument, despite the reduction in the width.
    // This is done since a relatively longer line obtained by moving the shorter line's pointer
    // might overcome the reduction in area caused by the width reduction.
    //  1 2 3 4 5 6
    //1 x ------- o
    //2 x x - o o o
    //3 x x x o | |
    //4 x x x x | |
    //5 x x x x x |
    //6 x x x x x x
    public int maxAreaOptimal(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
