package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i += 3) {
                        Person person = null;
                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], dateFormat.parse(args[i + 2]));
                        } else if (args[i + 1].equals("ж")) {
                            person = Person.createFemale(args[i], dateFormat.parse(args[i + 2]));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;

            case ("-u"):
                synchronized (allPeople) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i += 4) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        person.setName(args[i + 1]);
                        if (args[i+2].equals("м")) {
                            person.setSex(Sex.MALE);
                        } else if (args[i+2].equals("ж")) {
                            person.setSex(Sex.FEMALE);
                        }
                        person.setBirthDate(dateFormat.parse(args[i+3]));
                        allPeople.set(index, person);
                    }
                }
                break;
            case ("-d"):
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        Person person = allPeople.get(index);
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(index, person);
                    }
                }
                break;

            case ("-i"):
                synchronized (allPeople) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        String date = dateFormat.format(person.getBirthDate());
                        if (person.getSex() == Sex.MALE) {
                            System.out.println(person.getName() + " м " + date);
                        } else if (person.getSex() == Sex.FEMALE) {
                            System.out.println(person.getName() + " ж " + date);
                        }
                    }
                }
        }
    }
}
