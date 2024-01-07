package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static
    {
        map.put(12, "двенадцать");
        map.put(11, "одиннадцать");
        map.put(10, "десять");
        map.put(9, "девять");
        map.put(8, "восемь");
        map.put(7, "семь");
        map.put(6, "шесть");
        map.put(5, "пять");
        map.put(4, "четыре");
        map.put(3, "три");
        map.put(2, "два");
        map.put(1, "один");
        map.put(0, "ноль");
    }
//           C:\Users\Acer\Desktop\text1.txt
    public static void main(String[] args) throws IOException{
       try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       BufferedReader br = new BufferedReader(new FileReader(bf.readLine()))){
           while(br.ready()){
               String line = br.readLine();
               String[] buff = line.split("\\b");
               ArrayList<String> list = new ArrayList<>();
               for (int i = 0; i < buff.length; i++) {
                   list.add(buff[i]);
               }
               for (Integer key: map.keySet())
               {
                   String num = String.valueOf(key);
                   String value = map.get(key);
                   for (int i = 0; i < list.size(); i++) {
                       if(num.equals(list.get(i))){
                           list.set(i,value);
                       }
                   }
               }
               for (int i = 0; i < list.size(); i++) {
                   System.out.print(list.get(i));
               }
               System.out.println();
           }
       }
    }
}
