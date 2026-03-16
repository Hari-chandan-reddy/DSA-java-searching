package com.dsa.binarysearch.onedarray;

/*
* // This is MountainArray's API interface.
* // You should not implement it, or speculate about its implementation
* interface MountainArray {
*     public int get(int index) {}
*     public int length() {}
* }
*/

interface MountainArray {
    int get(int index);
    int length();
}

class MountainArrayImpl implements MountainArray {

    private int[] arr;

    MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}

public class FindInMountainArray {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 6, 4, 2};
        int target = 8;

        MountainArray mountainArr = new MountainArrayImpl(arr);

        Solution sol = new Solution();

        int result = sol.findInMountainArray(target, mountainArr);

        System.out.println("Target index: " + result);
    }
}

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peakIndex = peakIndexInMountainArray(mountainArr);

        int isAsc = orderAgnosticBS(mountainArr, target, 0, peakIndex);

        if (isAsc != -1) {
            return isAsc;
        }

        return orderAgnosticBS(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
    }

    int peakIndexInMountainArray(MountainArray mountainArr) {

        int low = 0;
        int high = mountainArr.length() - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int orderAgnosticBS(MountainArray mountainArr, int target, int low, int high) {

        boolean isAsc = mountainArr.get(low) < mountainArr.get(high);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (isAsc) {

                if (value < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            } else {

                if (value > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}