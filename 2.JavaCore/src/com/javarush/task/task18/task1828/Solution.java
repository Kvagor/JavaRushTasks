package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class Crud {
        int id;
        String productName;
        String price;
        String quantity;

        public Crud(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length==0){
            return;
        }
        List<Crud> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String line = reader.readLine();
                int id = Integer.parseInt(line.substring(0, 8).trim());
                String productName = line.substring(8, 38);
                String price = line.substring(38, 46);
                String quantity = line.substring(46, 50);
                list.add(new Crud(id, productName, price, quantity));
            }
        }
        if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            for (Crud cruds : list) {
                if (cruds.id == id){
                    cruds.productName = args[2];
                    cruds.price = args[3];
                    cruds.quantity = args[4];
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
                for (Crud cruds : list) {
                    cruds = new Crud(cruds.id, emptiness(cruds.productName, 30), emptiness(cruds.price, 8), emptiness(cruds.quantity, 4));
                    writer.write(emptiness(String.valueOf(cruds.id), 8) + cruds.productName + cruds.price + cruds.quantity + "\n");
                }
            }
        } else if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            for (Crud cruds : list) {
                if (cruds.id == id) {
                    list.remove(cruds);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                for (Crud cruds : list) {
                    cruds = new Crud(cruds.id, emptiness(cruds.productName, 30), emptiness(cruds.price, 8), emptiness(cruds.quantity, 4));
                    writer.write(emptiness(String.valueOf(cruds.id), 8) + cruds.productName + cruds.price + cruds.quantity + "\n");
                }
            }
        }
    }


    public static String emptiness(String string, int i) {
        StringBuilder sb = new StringBuilder(string);
        for (int j = sb.length() - 1; j < i - 1; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
