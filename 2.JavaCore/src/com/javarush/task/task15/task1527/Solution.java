package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String afterQuestion = url.substring(url.indexOf("?")+1);
        String[] array1 = afterQuestion.split("&");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i].indexOf("=")==-1?array1[i]+" ":array1[i].substring(0, array1[i].indexOf("="))+" ");
        }
        System.out.println();
        for (String s : array1) {
            String line = s.indexOf("=") == -1 ? null : s.substring(0, s.indexOf("="));
            if (line!=null) {
                if (line.equals("obj")) {
                    String obj = s.substring(s.indexOf("=") + 1);
                    try {
                        alert(Double.parseDouble(obj));
                    } catch (NumberFormatException e) {
                        alert(obj);
                    }
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
