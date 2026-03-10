package com.dsa.binarysearch;

public class SearchingElementInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 6, 10, 16, 21, 25, 27, 32, 36, 45, 52, 53};
        int target = 60;

        System.out.println(indexRange(arr, target));
    }

    public static int indexRange(int[] arr, int target) {
        int low = 0;
        int high = 1;

        while(high < arr.length && arr[high] < target) {
            int newLow = high + 1;
            high = high  * 2;
            low = newLow;
        }

        high = Math.min(high, arr.length - 1);

        return binarySearch(arr, target, low, high);
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}