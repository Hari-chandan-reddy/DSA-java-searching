package com.dsa.linearsearch;

public class SearchingElementInArray {
    public static void main(String[] args) {
        int[] arr = {5,6,3,9,4,7};
        int targetElement = 9;
        //int targetElement = 8;
        boolean found = false;

        for(int index = 0; index < arr.length; index++) {
            if(arr[index] == targetElement) {
                found = true;
                break;
            }
        }

        System.out.println((found) ? "Found" : "Not found");
    }
}
