package com.dsa.binarysearch;

public class NumberOfRotations {
    public static void main(String[] args) {
        int[] arr = {7, 9, 1, 2, 4, 5};
        System.out.println(numberOfRotations(arr));
    }

    public static int numberOfRotations(int[] arr) {
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
}