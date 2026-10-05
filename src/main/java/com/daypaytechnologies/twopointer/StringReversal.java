package com.daypaytechnologies.twopointer;

public class StringReversal {

    private static String reverseLettersOnly(String arg) {
        char[] chars = arg.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right) {
            if(!Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            else if(!Character.isLetterOrDigit(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String testStr2 = "Ab,c,de!$";
        System.out.println("\nOriginal: " + testStr2);
        System.out.println("Reversed: " + reverseLettersOnly(testStr2));
    }
}
