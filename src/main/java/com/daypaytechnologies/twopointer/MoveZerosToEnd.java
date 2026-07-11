package com.daypaytechnologies.twopointer;

import java.util.Arrays;

public class MoveZerosToEnd {

    /**
     * This uses the Two-Pointer Technique with a single-pass array traversal.
     * One pointer reads every element, while the other writes only the non-zero elements.
     * Since the output array is initialized with zeros, the remaining positions naturally contain zeros.
     */
    public static void main(String[] args) {
        int[] arr = {1, 0, -4, 0, 2, 3, 0, 5};
        int[] result = new int[arr.length]; // In Java, every element of an int[] is automatically initialized to 0.
        int resultIdx = 0;
        for(int n: arr) {
            if(n != 0) {
                result[resultIdx++] = n;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
