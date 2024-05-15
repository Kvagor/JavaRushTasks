package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            String char1 = String.valueOf(s.charAt(i));
            Integer i1 = map.get(char1);
            if (i == 0) {
                num = num + i1;
                break;
            } else {
                String charSled = String.valueOf(s.charAt(i - 1));
                Integer iSled = map.get(charSled);
                if (i1 > iSled) {
                    num = num + (i1 - iSled);
                    i--;
                } else {
                    num = num + i1;
                }
            }
        }
        return num;

    }
}
