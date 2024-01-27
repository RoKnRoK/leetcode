package com.rok.leetcode;

import java.util.*;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00045_JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,4}));
        System.out.println(jump(new int[]{2,6,1,1,1,1,1,4}));
        System.out.println(jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }

    public static int jump(int[] nums) {
        int[] map = new int[nums.length];
        Arrays.fill(map, 0);
        List<Integer> indices = new LinkedList<>();
        indices.add(0);
        int jumpNum = 0;
        for(int i = 0; i < indices.size(); i++)
        {
            int index = indices.get(i);
            if (map[index] != jumpNum - 1) {
                jumpNum++;
            }
            int end = Math.min(nums[index], nums.length - 1 - index);
            for (int j = 1; j <= end; j++) {
                if (map[index + j] == 0) {
                    map[index + j] = jumpNum;
                    indices.add(index + j);
                }
            }

            if (map[nums.length - 1] != 0) {
                return map[nums.length - 1];
            }
        }
        return map[nums.length - 1];
    }

    /**
     * intuitive recursive solution, TLE
     */
    private static int doJump(int from, int[] nums, int[] map, int jumpNum) {

        int jumpResult = Integer.MAX_VALUE;
        int end = Math.min(nums[from], nums.length - 1 - from);
        for (int i = 1; i <= end; i++){
            if (map[from + i] == 0) {
                map[from + i] = jumpNum;
            }
        }
        if (map[nums.length - 1] != 0) {
            return map[nums.length - 1];
        }
        for (int i = 1; i <= end; i++){
            if (map[from + i] == jumpNum) {
                 jumpResult = Math.min(doJump(from + i, nums, map, jumpNum + 1), jumpResult);
            }
        }
        return jumpResult;
    }
}
