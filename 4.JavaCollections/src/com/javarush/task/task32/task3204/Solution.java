package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

public class Solution {
    private static final String ALPHABET = "1234567890" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputByte = new ByteArrayOutputStream();
        String password = "";
        while (true) {
            if (isUpper(password)&&isNumeric(password)&&isLower(password)) {
                try {
                    outputByte.write(password.getBytes());
                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                password = "";
                for (int i = 0; i < 8; i++) {
                    password += ALPHABET.charAt(random());
                }
            }
        }
        return outputByte;
    }

    public static int random() {
        return (int) (Math.random() * ALPHABET.length());
    }

    public static boolean isNumeric(String str) {
        boolean hasDigits = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                hasDigits = true;
                break;
            }
        }
        return hasDigits;
    }

    public static boolean isUpper(String str) {
        boolean hasUpper = false;
        char[] array = str.toCharArray();
        for (char x : array) {
            if (Character.isUpperCase(x)) {
                hasUpper = true;
                break;
            }
        }
        return hasUpper;
    }

    public static boolean isLower(String str) {
        boolean hasLower = false;
        char[] array = str.toCharArray();
        for (char x : array) {
            if (Character.isUpperCase(x)) {
                hasLower = true;
                break;
            }
        }
        return hasLower;
    }
}
