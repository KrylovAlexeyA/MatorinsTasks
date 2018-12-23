package ru.sbt.mipt.oop.person;





public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public boolean isMan(){
        return man;
    }
    public Person getSpouse(){
        return spouse;
    }

    public void setSpouseNull(){
        this.spouse = null;
    }

    public void setSpouse(Person person){
        this.spouse = person;
    }

    public String getName() {
        return name;
    }

    public Person(boolean man, String name){
        this.man = man;
        this.name = name;
    }

    public static void main(String[] args) {
        Person alex = new Person(true, "alex");
        Person vika = new Person(false,"vika");
        Person petr = new Person(true,"petr");
        Person nelly = new Person(false,"nelly");

        System.out.println(alex.marry(vika));

        System.out.println(alex.marry(nelly));
        System.out.println(alex.getSpouse().getName());

    }



    public boolean marry(Person person){
        if (this.isMan() != person.isMan()) {
            if (person.getSpouse() == null) {
                if (this.spouse == null) {
                    this.spouse = person;
                    person.setSpouse(person);
                    return true;
                } else {
                    this.divorce();
                    this.spouse = person;
                    person.setSpouse(person);
                    return true;
                }
            } else {
                if (this.spouse == null) {
                    person.divorce();
                    this.spouse = person;
                    person.setSpouse(person);
                    return true;
                } else {
                    person.divorce();
                    this.divorce();
                    this.spouse = person;
                    person.setSpouse(person);
                    return true;
                }
            }
        }else {
            return false;
        }

    }


    public void divorce(){
        this.getSpouse().setSpouseNull();
        this.spouse = null;
    }

}
