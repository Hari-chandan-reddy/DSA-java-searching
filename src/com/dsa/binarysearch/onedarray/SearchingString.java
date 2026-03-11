package com.binarysearch;

public class SearchingString {

	public static void main(String[] args) {
		String[] strArray = {"abc", "bcd", "cde", "def", "efg", "fgh"};
		String target = "fgh";
		int low = 0, high = strArray.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			int compare = strArray[mid].compareTo(target);
			
			if(compare == 0) {
				System.out.println("Element found at: " + mid);
				return;
			} else if(compare < 0) {
				low = mid + 1;
			} else {
				high = mid -1;
			}
		}
		
		System.out.println("Element not found.");
	}

}
