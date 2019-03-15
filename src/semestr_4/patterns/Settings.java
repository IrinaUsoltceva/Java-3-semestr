package semestr_4.patterns;

import javafx.scene.paint.Color;

public class Settings {

    //в этом поле хранится тот самый единственный объект класса Settings
    private static Settings instance = new Settings();

    public static Settings getInstance() {
        return instance;
    }

    private Settings() {
        //загрущить настройки. неважно как, например, из файла, из интернета, из БД
    }

    //пример полезной информации, содержащейся в сиглтоне
    public Color getBackground() {
        return Color.RED;
    }

    public String getUserName() {
        return "me";
    }
}
