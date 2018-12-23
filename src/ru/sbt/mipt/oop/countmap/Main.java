package ru.sbt.mipt.oop.countmap;

public class Main {

    public static void main(String[] args) {
        ICountMap<Integer> map = new CountMap<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count1 = map.getCount(5); // 2 раза
        int count2 = map.getCount(6); // 1 раз
        int count3 = map.getCount(10); // 3 раза

        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);

    }
}