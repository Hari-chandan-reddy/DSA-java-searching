package com.dsa.binarysearch;

public class SearchInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 10, 11, 8, 5, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
