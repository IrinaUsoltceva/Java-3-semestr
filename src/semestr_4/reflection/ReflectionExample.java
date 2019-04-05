package semestr_4.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;

public class ReflectionExample {
    //будем пытаться делать что-то с классом, зная только его имя

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String className = "semestr_4.reflection.A";
        Class<?> aClass = Class.forName(className);

        //Lest<String>
        //еще один способ получить ссылку на класс: String.class, - если точно знаем
        //то аналогично Class.forName("java.lang.String") - если в процессе узнаем, или от пользователя

        Class<String> stringClass = String.class;
        //т.е. тип Class параметризован тем классом, который он представляет
        // Но при использовании Class.forName мы, когда пишем программу, не знаем, какой там будет тип, поэтому приходится писать
        //Class<?> или Class<? extends Object>

        //итак, в переменной aClass мы храним информацию о классе A
        Object a1 = aClass.newInstance(); //ouputs 'constructor1'
        System.out.println(a1 instanceof A); //true

        //вызовем другой конструктор
        Constructor<?>[] aConstructor = aClass.getConstructors();
        Constructor<?> secondConstructor = aConstructor[1];
        Object a2 = secondConstructor.newInstance("Irya");
        //System.out.println(((A) a2).getName()); - хдесь надо заранее занать А
        Method getName = aClass.getMethod("getName"); //getName без параметров
        System.out.println(getName.invoke(a2)); //Irya

        Method sayHello = aClass.getMethod("sayHello", int.class);
                                            //метод SayHello с int аргументом
        sayHello.invoke(a2, 42); //a2.sayHello(42)

    }

}
