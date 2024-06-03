package com.javarush.task.jdk13.task43.task4306;

/* 
В поиске ботана
*/

//import org.apache.commons.lang3.ObjectUtils;

import org.apache.commons.lang3.ObjectUtils;

public class Solution {

    public static void main(String[] args) {
        Student studentOne = new Student("Joe", 10, 8, 7, 7, 5, 6, 9);
        Student studentTwo = new Student("Jane", 8, 9, 5, 6, 7, 7, 8);

        String result = compareStudentGrades(studentOne, studentTwo);
        System.out.println(result);
    }

    public static String compareStudentGrades(Student studentOne, Student studentTwo) {
        if (ObjectUtils.anyNull(studentOne, studentTwo)) {
            return "Make sure there are no null objects";
        }
        int compare = ObjectUtils.compare(studentOne.getAllScore(),studentTwo.getAllScore());
        if (compare != 0) {
            return (compare > 0 ? studentOne.getName() : studentTwo.getName()) + " has a higher grades score";
        }
        return "Student grades scores are equal";
    }


}


