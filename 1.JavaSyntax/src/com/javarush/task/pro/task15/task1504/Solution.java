package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws  IOException{
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String src =sc.nextLine();
        try(InputStream input = Files.newInputStream(Paths.get(src));
            OutputStream output = Files.newOutputStream(Paths.get(sc.nextLine())))
        {
            byte[] bufferIn = input.readAllBytes();
            byte[] bufferOut = new byte[bufferIn.length];
            for (int i = 0; i < bufferIn.length; i+=2) {
                if(i< bufferIn.length-1){

                    bufferOut[i] = bufferIn[i+1];
                    bufferOut[i+1] = bufferIn[i];
                }else bufferOut[i]=bufferIn[i];
            }
            output.write(bufferOut);
        }
    }
}

