package semestr_4.patterns;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesFileExample {

    //удобный способ хранить настройки в файле
    public static void main(String[] args) throws IOException {
        //класс properties - удобный способ хранить настройки программя, сохранять, загружать их из файла

        Properties p = new Properties();
        //метод load позволяет загрузить настройки
        //FileInputStream - значит, читаем сз файла
        //getResourceAsStream - загрузить из ресурсов шаблон
        p.load(new FileInputStream(("example.properties")));
        p.load(new InputStreamReader(
                new FileInputStream("example.properties"),
                StandardCharsets.UTF_8
        ));

        String name = p.getProperty("name");
        String age = p.getProperty("age");
        String city = p.getProperty("city", "MOSKOW");
        System.out.println(name + " " + age + " " + city);
    }
}
