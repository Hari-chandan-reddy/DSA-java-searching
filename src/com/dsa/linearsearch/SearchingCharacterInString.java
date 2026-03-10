package com.dsa.linearsearch;

public class SearchingCharacterInString {
    public static void main(String[] args) {
        String str = "Hello Java";
        char c = 'H';
        //char c = 'h';
        boolean found = false;

        for(int index = 0; index < str.length(); index++) {
            if(str.charAt(index) == c) {
                found = true;
                System.out.println("Found at " + index + " position.");
                break;
            }
        }

        if(found == false) {
            System.out.println("Not found.");
        }
    }
}
