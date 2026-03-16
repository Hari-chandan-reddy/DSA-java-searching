package com.dsa.binarysearch.onedarray;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 8, 9, 12, 15, 21, 0, 1, 3, 5};
        int target = 3;

        int pivot = findPivot(arr) - 1;

        int ans = searchInRotatedSortedArray(arr, target, 0, pivot);

        if(ans == -1) {
            ans = searchInRotatedSortedArray(arr, target, pivot + 1, arr.length);
        }

        System.out.println(ans);
    }

    public static int findPivot(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int searchInRotatedSortedArray(int[] arr, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
    public static int searchInRotatedSortedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return mid;
            }

            if(arr[low] <= arr[mid]) {
                if(arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    */
}