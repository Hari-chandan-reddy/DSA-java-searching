package com.dsa.binarysearch.onedarray;

import java.util.Scanner;

public class CeilingAndFloorElement {
    public static void main(String[] args) {
        int[] arr = {3, 7, 9, 13, 17, 25, 34};
        int target = 15;

        int ceilingElement = findCeilingElement(arr, target);
        if(ceilingElement != -1) {
            System.out.println("Ceiling element is: " + arr[ceilingElement]);
        } else {
            System.out.println("Ceiling element not found");
        }

        int floorElement = findFloorElement(arr, target);
        if(floorElement != -1) {
            System.out.println("Floor element is: " + arr[floorElement]);
        } else {
            System.out.println("Floor element not found");
        }
    }

    public static int findCeilingElement(int[] arr, int target) {
        if(arr.length == 0) return -1;

        if(target > arr[arr.length - 1]) return -1;

        int low = 0;
        int high = arr.length - 1;

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

        return low;
        }

    public static int findFloorElement(int[] arr, int target) {
        if(arr.length == 0) return  -1;

        if (target < arr[0]) return -1;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target) {
                return  mid;
            }

            if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}