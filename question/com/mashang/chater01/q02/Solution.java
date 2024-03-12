package com.mashang.chater01.q02;

public class Solution {
    public static void main(String[] args) {
        String str = "nnnnnnnnnn";
        String subStr = "n";

        int index = 0;
        int res = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            index += subStr.length();

            res++;
        }

        System.out.println(res);
    }
}
