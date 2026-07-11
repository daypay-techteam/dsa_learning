package com.daypaytechnologies.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static void computeThroughMap(String arg) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        int start = 0;
        for(int windowEnd = 0; windowEnd < arg.length();windowEnd++) {
            Character c = arg.charAt(windowEnd);
            if(characterIntegerMap.containsKey(c)) {
                windowStart = characterIntegerMap.get(c) + 1;
            }
            characterIntegerMap.put(c, windowEnd);

            int currentLength = windowEnd - windowStart + 1; // Note: sliding window formula (end - start + 1) like Maths;
            if(currentLength > maxLength) {
                maxLength = currentLength;
                start = windowStart;
            }
        }
        System.out.println(arg.substring(start, start + maxLength));
    }

    public static void computeThroughArray(String arg) {
        int[] lastSeen = new int[256];
        Arrays.fill(lastSeen, -1); // important otherwise last seen index get lost
        int windowStart = 0;
        int maxLength = 0;
        int start = 0;
        for(int windowEnd = 0; windowEnd < arg.length();windowEnd++) {
            char c = arg.charAt(windowEnd);
            if(lastSeen[c] >= windowStart) {
                windowStart = lastSeen[c] + 1;
            }
            lastSeen[c] = windowEnd;
            int currentLength = windowEnd - windowStart + 1;
            if(currentLength > maxLength) {
                maxLength = currentLength;
                start = windowStart;
            }
        }
        System.out.println(arg.substring(start, start + maxLength));
    }

    public static void main(String[] args) {
        String a = "abcabcdef";
        computeThroughMap(a);
        computeThroughArray(a);
    }
}
