package com.dsa.binarysearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 8, 4, 7, 0};
        int k = 2;

        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // define search space
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // total sum
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays <= k;
    }
}