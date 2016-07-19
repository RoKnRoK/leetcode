package com.rok.leetcode;

import java.util.Arrays;

/**
 * Created by RoK on 18.07.2016.
 * All rights reserved =)
 */
public class _004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {1, 5, 8, 12, 17};
//        int[] nums2 = {1, 2, 13, 14, 15, 16, 17, 18, 19, 20};

//        int[] nums1 = {1, 2, 3};
//        int[] nums2 = {1, 2};

//        int[] nums1 = {1,2};
//        int[] nums2 = {1,2};

        int[] nums1 = {1};
        int[] nums2 = {2,3,4};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] nums1_d = new double[nums1.length], nums2_d = new double[nums2.length];
        double[] nums1_orig = new double[nums1.length], nums2_orig = new double[nums2.length];

        for (int i=0; i< nums1.length; i++){
            nums1_d[i] = nums1[i];
            nums1_orig[i] = nums1[i];
        }

        for (int i=0; i< nums2.length; i++){
            nums2_d[i] = nums2[i];
            nums2_orig[i] = nums2[i];
        }

        int a1 = 0, a2= 0;
        int b1 = nums1.length, b2 = nums2.length;

        double median1 = findArrayMedian(nums1_d);
        double median2 = findArrayMedian(nums2_d);
//        System.out.println(median1+", " + median2);

        double medianOfMedians = findMedianOfMedians(median1, median2);
//        System.out.println("medianOfMedians = " + medianOfMedians);
        boolean medianInArray1, medianInArray2;

        int arr1LessCount = Arrays.binarySearch(nums1_orig, medianOfMedians);
        medianInArray1 = arr1LessCount >= 0;
        if (!medianInArray1) {arr1LessCount = -arr1LessCount - 1;}

        int arr2LessCount = Arrays.binarySearch(nums2_orig, medianOfMedians);
        medianInArray2 = arr2LessCount >= 0;
        if (!medianInArray2) {arr2LessCount = -arr2LessCount - 1;}

        int arr1GreaterCount = nums1.length - arr1LessCount - (medianInArray1 ? 1 : 0);
        int arr2GreaterCount = nums2.length - arr2LessCount - (medianInArray2 ? 1 : 0);

//        System.out.println(arr1LessCount);
//        System.out.println(arr2LessCount);


        int totalLessCount = arr1LessCount + arr2LessCount;
        int totalGreaterCount = arr1GreaterCount + arr2GreaterCount;
        while (totalLessCount != totalGreaterCount) {
            if (totalLessCount < totalGreaterCount) {
                a1 = arr1LessCount;
                a2 = arr2LessCount;
            }
            else {
                b1 = arr1LessCount;
                b2 = arr2LessCount;
            }
            nums1_d = Arrays.copyOfRange(nums1_orig, a1, b1);
            nums2_d = Arrays.copyOfRange(nums2_orig, a2, b2);

            median1 = findArrayMedian(nums1_d);
            median2 = findArrayMedian(nums2_d);

            medianOfMedians = findMedianOfMedians(median1, median2);



            arr1LessCount = Arrays.binarySearch(nums1_orig, medianOfMedians);
            medianInArray1 = arr1LessCount >= 0;
            if (!medianInArray1) {arr1LessCount = -arr1LessCount - 1;}

            arr2LessCount = Arrays.binarySearch(nums2_orig, medianOfMedians);
            medianInArray2 = arr2LessCount >= 0;
            if (!medianInArray2) {arr2LessCount = -arr2LessCount - 1;}

            arr1GreaterCount = nums1.length - arr1LessCount - (medianInArray1 ? 1 : 0);
            arr2GreaterCount = nums2.length - arr2LessCount - (medianInArray2 ? 1 : 0);


            if (arr1LessCount < nums1_orig.length && arr2LessCount < nums2_orig.length
            && nums1_orig[arr1LessCount] == nums2_orig[arr2LessCount] && nums1[arr1LessCount] == medianOfMedians){
                return medianOfMedians;
            }

            totalLessCount = arr1LessCount + arr2LessCount;
            totalGreaterCount = arr1GreaterCount + arr2GreaterCount;
        }

        return medianOfMedians;
    }

    private static double findArrayMedian(double[] array){
        int len = array.length;
        if (len == 0) {return 0;}
        int mod = len % 2;
        int div = len / 2;
        return mod == 1 ?(array[div]) : 0.5*(1 - mod)*(array[div] + array[div -1]);
    }


    private static double findMedianOfMedians(double median1, double median2){
        if (median1 == 0) {return median2;}
        if (median2 == 0) {return median1;}
        return median1*0.5 + median2*0.5;
    }
    private static double findArrayMedian(int[] array){
        int len = array.length;
        int mod = len % 2;
        int div = len / 2;
        return mod == 1 ?(array[div]) : 0.5*(1 - mod)*(array[div] + array[div -1]);
    }
}
