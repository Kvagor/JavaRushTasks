package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        if (date.contains(":") && !date.contains(".")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
            LocalTime parse = LocalTime.parse(date, formatter);
            System.out.println("AM или PM: " + parse.format(DateTimeFormatter.ofPattern("a")));
            System.out.println("Часы: " + parse.format(DateTimeFormatter.ofPattern("K")));
            System.out.println("Часы дня: " + parse.getHour());
            System.out.println("Минуты: " + parse.getMinute());
            System.out.println("Секунды: " + parse.getSecond());
        } else if (date.contains(".") && !date.contains(":")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println("День: "+localDate.getDayOfMonth());
            System.out.println("День недели: "+localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: "+localDate.getDayOfMonth());
            System.out.println("День года: "+localDate.getDayOfYear());
            System.out.println("Неделя месяца: "+localDate.format(DateTimeFormatter.ofPattern("W")));
            System.out.println("Неделя года: "+localDate.format(DateTimeFormatter.ofPattern("w")));
            System.out.println("Месяц: "+localDate.getMonth().getValue());
            System.out.println("Год: "+localDate.getYear());
        } else if (date.contains(":") && date.contains(".")) {
          String[] mass = date.split(" ");
            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d.M.y");
            DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:m:s");
            LocalDate localDate = LocalDate.parse(mass[0],formatterDate);
            LocalTime localTime = LocalTime.parse(mass[1],formatterTime);
            System.out.println("День: "+localDate.getDayOfMonth());
            System.out.println("День недели: "+localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: "+localDate.getDayOfMonth());
            System.out.println("День года: "+localDate.getDayOfYear());
            System.out.println("Неделя месяца: "+localDate.format(DateTimeFormatter.ofPattern("W")));
            System.out.println("Неделя года: "+localDate.format(DateTimeFormatter.ofPattern("w")));
            System.out.println("Месяц: "+localDate.getMonth().getValue());
            System.out.println("Год: "+localDate.getYear());
            System.out.println("AM или PM: " + localTime.format(DateTimeFormatter.ofPattern("a")));
            System.out.println("Часы: " + localTime.format(DateTimeFormatter.ofPattern("K")));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
    }
}
