package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line= console.readLine()).equals("exit")){
            new ReadThread(line).start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName=fileName;

        }

        @Override
        public void run() {
            byte[] array = new byte[256];
            try(FileInputStream fis = new FileInputStream(fileName)){
                while (fis.available()>0){
                    int bytes = fis.read();
                    array[bytes]++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int max = array[0];
            int temp=0;
            for (int i = 0; i < array.length; i++) {
                if(array[i]>max){
                    max=array[i];
                    temp = i;
                }
            }
            resultMap.put(fileName,temp);
        }
    }
}
