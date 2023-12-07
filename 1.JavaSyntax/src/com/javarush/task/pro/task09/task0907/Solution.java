package com.javarush.task.pro.task09.task0907;

import java.util.regex.Pattern;

/* 
Шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber = "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    public static String toHex(int decimalNumber) {
        //напишите тут ваш код
        String line = "";
        if (decimalNumber <= 0) {
            return line;
        } else {
            while (decimalNumber != 0) {
                line = HEX.charAt(decimalNumber % 16) + line;
                decimalNumber = decimalNumber / 16;
            }
        }
        return line;
    }

    public static int toDecimal(String hexNumber) {
        //напишите тут ваш код
        int num = 0;
        if (hexNumber == null || hexNumber == "") {
            return 0;
        } else {
            for (int i = 0; i < hexNumber.length(); i++) {
                num = 16 * num + HEX.indexOf(hexNumber.charAt(i));
            }
        }
        return num;
    }
}
