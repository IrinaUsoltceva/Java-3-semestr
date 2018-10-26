package LJavafx;

import javafx.application.Application;

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

        TextArea dialog = new TextArea("dialog");

        HBox textAndButton = new HBox();
        Button send = new Button("send");
        TextField message = new TextField("message");
        HBox.setHgrow(message, Priority.ALWAYS);
        textAndButton.getChildren().addAll(message, send);

        VBox left = new VBox();
        left.getChildren().addAll(dialog, textAndButton);

        Label kontakti = new Label("kontakti");
        ListView<String> kontaktiList = new ListView<>();
        VBox right = new VBox();
        right.getChildren().addAll(kontakti, kontaktiList);

        root.getChildren().addAll(left, right);

        VBox.setVgrow(kontaktiList, Priority.ALWAYS);
        VBox.setVgrow(dialog, Priority.ALWAYS);
        HBox.setHgrow(left, Priority.ALWAYS);

        /*

        //давайте теперь добавим Constraint для элементов
        //было бы естественно сделать так
        //b1.setConstraint (какой, значение)

        //HBox - означает, что констрейнт понимают все HBox-ы
        //HGrow - название constraint, это тот, который говорит, растягивать
        //        ли элемент. Always - всегда
        HBox.setHgrow(tf1, Priority.ALWAYS);
        HBox.setMargin(b1, new Insets(8));

        //а это уже не constraint, а свойства HBox,
        //все элементы должны располагаться снизу по центру
        root.setAlignment(Pos.BOTTOM_CENTER);*/

        return root;
    }

}
