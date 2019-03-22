package semestr_4.patterns.adapter;

import semestr_4.patterns.factory.Animal;

public class AdapterExample {
    public static void main(String[] args) {
        Car c = new Car("Lada");
        System.out.println(c.go());

        Animal a = new CarAdapter(c);
        System.out.println(a.greet());
    }
}
