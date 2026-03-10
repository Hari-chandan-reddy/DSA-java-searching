package com.dsa.binarysearch;

public class SearchingElement {
	public static void main(String[] args) {
		int[] arr = {16, 24, 31, 47, 51, 63, 78};
		int target = 24;
		
		int low = 0, high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] == target) {
				System.out.println("Found at: " + mid);
				return;
			} else if(arr[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		System.out.println("Not found.");
	}
}
