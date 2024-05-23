package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        String line = "";
        for (int i = 0; i < s.length(); i++) {
            if (line.indexOf(s.charAt(i)) >= 0) {
                set.add(line);
                int i1 = s.lastIndexOf(s.charAt(i),i-1);
                line = "";
                i = i1;
            } else {
                line += s.charAt(i);
            }
        }
        set.add(line);
        String max = Collections.max(set, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return max.length();
    }

}
