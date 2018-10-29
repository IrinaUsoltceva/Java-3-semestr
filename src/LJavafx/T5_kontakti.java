package LJavafx;

import javafx.application.Application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class T5_kontakti extends Application {
    //абстрактный класс реализует не все
    //ругается, что нет start(Stage), нужно создать

    /*реализуем метод start, который объясняет, как запускается
    приложение. В качестве аргумента в этот метод передается
    Stage - ссылка на коно приложения. У окна есть заголовок,
    конпки закрытия окна, бордюр для изменения размеров окна и тд

    */
    private TextArea dialog = new TextArea();
    private Button send = new Button("send");
    private TextField message = new TextField();
    private Label kontakti = new Label("kontakti");
    private ListView<String> kontaktiList = new ListView<>();


    @Override
    public void start(Stage primaryStage) {
        //установить заголовок окна
        primaryStage.setTitle("Hello World JAVAFX Application");

        Parent root = initInterface();
        //Задаем сцену, сцена содержит информаицю о Parent, т.е. о том, что
        //показывать на экране.  И информацию о том, как показывать.
        //Это размер окна и другие параметры
        primaryStage.setScene(new Scene(root/*, width, height*/));
        initInteraction();

        //отобразить окно на экране
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox root = new HBox();
        HBox textAndButton = new HBox(message, send);
        HBox.setHgrow(message, Priority.ALWAYS);

        kontaktiList.getItems().addAll("mom", "dad", "sis", "grandma", "jane");

        VBox left = new VBox(dialog, textAndButton);
        VBox right = new VBox(kontakti, kontaktiList);

        root.getChildren().addAll(left, right);

        VBox.setVgrow(kontaktiList, Priority.ALWAYS);
        VBox.setVgrow(dialog, Priority.ALWAYS);
        HBox.setHgrow(left, Priority.ALWAYS);

        return root;
    }

    private void initInteraction() {
        send.addEventHandler(
                ActionEvent.ACTION,
                a -> {
                    dialog.appendText(message.getText() + "\n");
                    message.textProperty().setValue("");
                }
        );
        dialog.setEditable(false);
    }
}
