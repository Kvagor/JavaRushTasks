package com.javarush.task.task26.task2603;

/*
Убежденному убеждать других не трудно
*/

import java.util.Comparator;

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int a = 0;
            for (Comparator<T> t : comparators) {
                a = t.compare(o1, o2);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
