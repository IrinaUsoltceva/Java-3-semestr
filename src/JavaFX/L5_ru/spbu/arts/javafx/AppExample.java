package JavaFX.L5_ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//НИЧЕГО НЕ ИМПОРТИРОВАТЬ ИЗ vom.sun
//все может поломаться после обновления

public class AppExample extends Application {
    //абстрактный класс реализует не все
    //ругается, что нет start(Stage), нужно создать

    /*реализуем метод start, который объясняет, как запускается
    приложение. В качестве аргумента в этот метод передается
    Stage - ссылка на коно приложения. У окна есть заголовок,
    конпки закрытия окна, бордюр для изменения размеров окна и тд

    */
    @Override
    public void start(Stage primaryStage) {
        //установить заголовок окна
        primaryStage.setTitle("Hello World JAVAFX Application");

        Parent root = initInterface();
        //Задаем сцену, сцена содержит информаицю о Parent, т.е. о том, что
        //показывать на экране.  И информацию о том, как показывать.
        //Это размер окна и другие параметры
        primaryStage.setScene(new Scene(root/*, width, height*/));

        //отобразить окно на экране
        primaryStage.show();
    }

    private Parent initInterface() {
        //В конструкторе можно сразу указать детей, т.е. все подузлы.
        //И еще можно сразу указать внешний отступ (padding из css)
        HBox root = new HBox();

        root.setSpacing(10); //можно указать отступ позже

        //шмпортируем жава.фх
        Button b1 = new Button("Hello");
        Label l1 = new Label("Just a text");
        TextField tf1 = new TextField("enter something");

        //чтобы добавить детей, обращаемся к списку детей
        //и пользуемся методом, который позволяет добавить в список
        //сразу несколько элементов. Можно использовать метод add,
        //но он добавит один элемент
        //В JavaFx чуть-чуть другие коллекции, не такие, как мы привыкли
        //Коллекции в JavaFX позволяют следить за своим содержимым, т.е.
        //root сразу поймет, что ему добавили детей и перерисуется
        root.getChildren().addAll(b1, l1, tf1);

        //еще можно при создании указать детей
        //HBox root1 = new Hbox(b1, l1, tf1);

        return root;
    }

}
