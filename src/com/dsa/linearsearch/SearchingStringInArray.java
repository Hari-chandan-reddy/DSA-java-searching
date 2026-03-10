package com.dsa.linearsearch;

public class SearchingStringInArray {
    public static void main(String[] args) {
        String[] strArray = {"a", "c", "e", "b", "y"};
        String str = "e";
        //String str = "f";
        boolean found = false;

        for(String str1: strArray) {
            if(str1.equals(str)) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "found" : "Not found");
    }
}
