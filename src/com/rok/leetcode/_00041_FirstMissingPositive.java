package com.rok.leetcode;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00041_FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{0}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{2}));
        System.out.println(firstMissingPositive(new int[]{1, 2}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3, 4}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{6, 5, 3, 2, -1, -1, -1, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            return nums[0] < 1 ? 1 : (nums[0] > 1 ? 1 : 2);
        }
        int answer = 1;
        int iter = 0;
        int direction = -1;
        int current;
        boolean found = true;
        do {
            current = nums[iter];
            if (current == answer) {
                answer++;
                found = true;
            }
            if (iter == nums.length - 1 || iter == 0) {
                if (!found) {
                    return answer;
                }
                found = false;
                direction = -direction;
            }
            iter += direction;
        } while (true);
    }
}
