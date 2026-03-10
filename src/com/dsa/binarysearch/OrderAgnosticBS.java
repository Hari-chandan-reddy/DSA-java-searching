package com.dsa.binarysearch;

public class OrderAgnosticBS {
	public static void main(String[] args) {
		int[] arr = {-2, 0, 12, 23, 26, 31, 51, 72};
		int target = 23;
		
		int ans = searchElement(arr, target);
		System.out.println(ans);
	}
	
	public static int searchElement(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		
		boolean isAsc = arr[low] < arr[high];
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			if(target == arr[mid]) {
				return mid;
			}
			
			if(isAsc) {
				if(arr[mid] < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if(arr[mid] < target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}