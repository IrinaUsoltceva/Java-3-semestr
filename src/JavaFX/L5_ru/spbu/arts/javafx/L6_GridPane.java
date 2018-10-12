package JavaFX.L5_ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class L6_GridPane extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GridPane JavaFX Application");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    private Parent initInterface() {
        //реализуем интерфейс месседжера с помощью GridPane
        //начнем с создания элементов интерфейса

        TextArea history = new TextArea();
        TextField message = new TextField();
        Button send = new Button("send");
        Label contactsLabel = new Label("контакты");
        ListView<String> contacts = new ListView<>();
        //ListView имеет типовый параметр, тип содержимого списка

        GridPane root = new GridPane();

        //констраинты для элементов можно указать традиционно
        GridPane.setColumnIndex(history, 0); //в каком столбце элемент
        GridPane.setRowIndex(history, 0); //в какой строка
        GridPane.setColumnSpan(history, 2);//сколько занимает
        GridPane.setRowSpan(history, 2);//сколько строк
        root.getChildren().add(history);

        //но можно делать проще
        root.add(message, 0, 2);
        root.add(send,1,2);
        root.add(contactsLabel,2,0);
        root.add(contacts,2,1,1,2);
        //для contacts дополнительно указали количество строк и столбцов

        //заставим элементы растягиваться. нужно указать, как растягиваются строки и столбцы.

        //нужно указать, как растягиваются строки и столбцы.
        //будем растягивать столбец 0 и строку 1

        ColumnConstraints cc0 = new ColumnConstraints();
        cc0.setHgrow(Priority.ALWAYS);
        //HGrow аналогичен HGrow для HBox
        //есть много других полезных constraint в cc0

        RowConstraints rc0 = new RowConstraints();
        RowConstraints rc1 = new RowConstraints();
        rc1.setVgrow(Priority.ALWAYS);

        //column/riw constraints - изначально пустые списки
        root.getColumnConstraints().add(cc0);
        root.getRowConstraints().addAll(rc0, rc1);

        return root;
    }
}
