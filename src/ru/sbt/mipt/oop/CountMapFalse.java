package ru.sbt.mipt.oop;


import java.util.ArrayList;

public class CountMapFalse {
    String txt;
    ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String txt = "abb egggg tttttt";
        CountMapFalse countMap = new CountMapFalse(txt);
        countMap.parse();
        countMap.printText();

    }

    public CountMapFalse(String txt){
        this.txt = txt;
    }

    public void parse(){
        for (String str : txt.split(" ")){
            list.add(str);
        }
        //for (String lst : list){
          //  System.out.println(lst);
        //}
    }
    public int count() {
        int counter = 0;
        for (String str : list) {
            counter += 1;
        }
        return counter;
    }

    public void printText(){

        for (String lst : list) {
            System.out.println(lst);
        }

    }
}
