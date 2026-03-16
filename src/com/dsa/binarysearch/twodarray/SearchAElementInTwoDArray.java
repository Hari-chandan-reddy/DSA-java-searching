package com.dsa.binarysearch.twodarray;

import java.util.Arrays;

public class SearchAElementInTwoDArray {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40}, {15, 25, 35, 45}, {28, 29, 37, 49}, {33, 34, 38, 50}};

        int target = 28;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int[] res = searchInTwoDArray(arr, target);

        System.out.println(Arrays.toString(res));

        /*
        if(res[0] == -1) { 
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at row " + (res[0] + 1) + " and column " + (res[1] + 1));
        }
        */
    }

    public static int[] searchInTwoDArray(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return new int[]{-1, -1};
        }

        int row = 0;
        int column = arr[0].length - 1;

        while(row < arr.length && column >= 0) {
            if(arr[row][column] == target) {
                return new int[]{row, column};
            }

            if(target < arr[row][column]) {
                column--;
            } else {
                row++;
            }
        }


        return new int[]{-1, -1};
    }
}
