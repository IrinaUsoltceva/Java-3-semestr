package semestr_4.patterns.adapter;

import semestr_4.patterns.factory.Animal;

public class CarAdapter extends Animal {
    //позволяет создавать объект-наследник какого-то класса
    //(у нас - живтоных anima) на основе объекта, который к
    //этому классу не относится
    //важно, что адаптер сам этим животным и является

    //адаптер создается на основе машинки, чтобы превратить ее в животное

    public CarAdapter(Car car) {
        super(car.getName());
    }
}
