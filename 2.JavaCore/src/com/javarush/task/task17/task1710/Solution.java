package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        if (args[0].equals("-c")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person person = null;
            if(args[2].equals("м")){
                 person = Person.createMale(args[1],dateFormat.parse(args[3]));
            } else if (args[2].equals("ж")) {
                 person = Person.createFemale(args[1],dateFormat.parse(args[3]));
            }
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));

        } else if (args[0].equals("-r")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            String dateParse = dateFormat.format(person.getBirthDate());
            if (person.getSex() == Sex.MALE) {
                System.out.println(person.getName() + " м " + dateParse);
            } else if (person.getSex() == Sex.FEMALE) {
                System.out.println(person.getName() + " ж " + dateParse);
            }


        } else if (args[0].equals("-u")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
           person.setName(args[2]);
           if(args[3].equals("м")){
               person.setSex(Sex.MALE);
           }else if (args[3].equals("ж")){
               person.setSex(Sex.FEMALE);
           }
            person.setBirthDate(dateFormat.parse(args[4]));
           allPeople.set(index,person);

        } else if (args[0].equals("-d")) {
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.set(index, person);
        }
    }
}
