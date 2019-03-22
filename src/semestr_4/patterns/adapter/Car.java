package semestr_4.patterns.adapter;

public class Car {

    public String name;

    public Car (String name) {
        this.name = name;
    }

    public String go() {
        return "vrrrrrrrrrrrrr" + name;
    }

    //Alt + insert - gettr setter
    public String getName() {
        return name;
    }
}
