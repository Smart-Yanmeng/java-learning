package com.mashang.chater01.q03;

public class Solution {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("He11ll00d323o  w1232154304343or8ld!");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                str.deleteCharAt(i);

                i--;
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
}
