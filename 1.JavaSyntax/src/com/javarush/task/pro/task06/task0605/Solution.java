package com.javarush.task.pro.task06.task0605;

/* 
Правильный порядок
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        printArray(array);
        reverseArray(array);
        printArray(array);
    }

    public static void reverseArray(int[] array) {
        //напишите тут ваш код
        /*int rev = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            array[rev] = array[i];
            rev++;
        }*/
        int[] array2 = Arrays.copyOf(array, array.length);
        int count=array2.length-1;
        for (int i = 0; i < array.length; i++) {
            array[i]=array2[count];
            count--;
        }
    }


    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
