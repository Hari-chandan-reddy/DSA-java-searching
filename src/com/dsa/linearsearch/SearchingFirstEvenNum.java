package com.dsa.linearsearch;

public class SearchingFirstEvenNum {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,2};

        for(int index = 0; index < arr.length; index++) {
            if(arr[index] % 2 == 0) {
                System.out.println("Frist even number is: " + arr[index]);
                break;
            }
        }
    }
}