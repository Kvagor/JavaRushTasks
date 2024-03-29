package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        return students.stream().filter(x->x.getAverageGrade()==averageGrade)
                .findFirst()
                .get();
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        List<Double> collect = students.stream().map(x -> x.getAverageGrade()).collect(Collectors.toList());
        Double max = Collections.max(collect);
        return students.stream().filter(x->x.getAverageGrade()==max)
                .findFirst()
                .get();
    }


    public Student getStudentWithMinAverageGrade() {
        //TODO:
        List<Double> collect = students.stream().map(x -> x.getAverageGrade()).collect(Collectors.toList());
        Double min = Collections.min(collect);
        return students.stream().filter(x->x.getAverageGrade()==min)
                .findFirst()
                .get();
    }

    public void expel(Student student) {
        students.remove(student);


    }

}