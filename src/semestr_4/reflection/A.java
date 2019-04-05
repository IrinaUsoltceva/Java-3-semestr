package semestr_4.reflection;

public class A {
    private String name;

    public A() {
        System.out.println("constructor1");
    }

    public A (String name) {
        System.out.println("cinstructor2");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello(int x) {
        System.out.println("Hello, " + x);
    }
}
