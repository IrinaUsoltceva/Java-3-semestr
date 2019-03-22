package semestr_4.patterns.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalFactory {

    //фабрика нужна. ЧТОБЫ СЛЕДИТЬ ЗА ПРОЦЕССОМ СОЗДАНИЯ ОБЪЕКТОВ
    private List<Cat> cats = new ArrayList<>();
    private List<Dog> dogs = new ArrayList<>();

    public Cat createCat(String name) {
        Cat cat = new Cat(name);
        cats.add(cat);
        return cat;
    }

    public Dog createDog(String name) {
        Dog dog = new Dog(name);
        dogs.add(dog);
        return dog;
    }

    public List<Cat> getAllCats() {
        return Collections.unmodifiableList(cats);
    }

    public List<Dog> getAllDogs() {
        return Collections.unmodifiableList(dogs);
    }
}
