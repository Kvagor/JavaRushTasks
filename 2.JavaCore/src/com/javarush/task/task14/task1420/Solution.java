package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bf.readLine());
        int num2 = Integer.parseInt(bf.readLine());
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 1; i <= num1; i++) {
            if (num1%i==0){
                arrayList1.add(i);
            }
        }
        for (int i = 1; i <= num2; i++) {
            if (num2%i==0){
                arrayList2.add(i);
            }
        }
        ArrayList<Integer> copyArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            for (int j = 0; j < arrayList2.size() ; j++) {
                if (arrayList1.get(i)==arrayList2.get(j)){
                    copyArrayList.add(arrayList1.get(i));
                    break;
                }
            }
        }
        System.out.println(Collections.max(copyArrayList));
    }
}
