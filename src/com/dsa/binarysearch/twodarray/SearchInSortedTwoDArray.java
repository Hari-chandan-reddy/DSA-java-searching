package com.dsa.binarysearch.twodarray;

import java.util.Arrays;

public class SearchInSortedTwoDArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int target = 7;

        System.out.println(Arrays.toString(search(arr, target)));
    }


    public static int[] search(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return new int[]{-1, -1};
        }

        int rows = arr.length;
        int cols = arr[0].length;

        // If only one row → normal binary search
        if(rows == 1) {
            return binarySearch(arr, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // reduce rows until only 2 rows remain
        while (rStart < (rEnd - 1)) {
            int mid = rStart + (rEnd - rStart) / 2;

            if(arr[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }

            if(arr[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // check middle column of remaining two rows
        if(arr[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }

        if(arr[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        // search in 4 parts
        // part 1
        if(arr[rStart][cMid] > target) {
            return binarySearch(arr, rStart, 0, cMid - 1, target);
        }

        // part 2
        if(arr[rStart][cMid] < target && target <= arr[rStart][cols - 1]) {
            return binarySearch(arr, rStart, cMid + 1, cols - 1, target);
        }

        // part 3
        if(arr[rStart + 1][cMid] > target) {
            return binarySearch(arr, rStart + 1, 0, cMid - 1, target);
        }

        // part 4
        return binarySearch(arr, rStart + 1, cMid + 1, cols - 1, target);
    }

    public static int[] binarySearch(int[][] arr, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;

            if(arr[row][mid] == target) {
                return new int[]{row, mid};
            }

            if(arr[row][mid] > target) {
                cEnd = mid -1;
            } else {
                cStart = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
