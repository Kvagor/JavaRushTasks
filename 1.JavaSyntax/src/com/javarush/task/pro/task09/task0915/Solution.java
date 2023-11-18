package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        //напишите тут ваш код

        StringTokenizer str = new StringTokenizer(query,delimiter);
        String[] line = new String[str.countTokens()];
        int count=0;
        while (str.hasMoreTokens()){
            String token= str.nextToken();
            line[count]=token;
            count++;

        }

        return line;
    }
}
