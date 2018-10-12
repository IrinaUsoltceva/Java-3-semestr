package JavaFX.L5_ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class L6_PropertiesListenersAndBindingss extends Application {

    //поля класса. Живут и доступны все время, пока жив класс, т.е. окно нашей программы
    private TextField textField1;
    private Button button1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Properties, Listeners, and Bindings");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction(); //наш новый метод, в нем будет описываться поведение элементов интерфейса

        primaryStage.show();
    }

    private Parent initInterface() {
        FlowPane root = new FlowPane();

        //----------------------------------------
        VBox example1 = new VBox();
        //стараться давать переменным осмысреллные названия. button1
        //означает только то, что эта кнопка для первого примера
        textField1 = new TextField();
        button1 = new Button("Пример 1");
        example1.getChildren().addAll(textField1, button1);

        //давайте раскрасим панель example1
        example1.setBackground( //фон
                new Background(
                        new BackgroundFill(
                                Color.web("#FF0000"), //цвет может выступать заполнителем фона
                                new CornerRadii(0),//радиус закругления угла
                                Insets.EMPTY //пустой отступ для закраски
                        ) //заполнитель для фона
                )

        );
        example1.setStyle("-fx-background-color: #00FF00"); //другой способ, чуть короче
                                                            //пользуемся CSS со стилями из JavaFX
        //----------------------------------------------------

        root.getChildren().addAll(example1);

        return root;
    }

    private void initInteraction() {
        //-----------------------------пример 1------
        //как заставить кнопку что-то делать
        //способ 1 - универсальный, но сложный
        //в жаваФХ реализована работа с событиями, разные объекты генерируют события
        //можно добавлять слушателей (обработчиков), которые реагируют на интересующие их события
        //кнопка генерирует события типа ActionEvent.ACTION, это происходит в момент нажатия на кнопку.
        //Нажатие может быть разным, мышкой, кнопкой ентер, пробел, касание экрана и т.п.
        //В принципе, все Node, включая кнопку, генерируют еще и события мыши, т.е. можно реагировать на событие
        //что на кнопку наведена, нажата, отпущена мыш
        button1.addEventHandler(
                ActionEvent.ACTION, //какое событие кнопки нас интересует
                a -> System.out.println("pressed"));
                //второе - действие, в виде лямбда выражения
                //а - информация о событии. в этой информации всегда можно найти
                //источник события. если бы у нас было событие от мыши, мы бы дополнительно
                //могли получить информацию о положнии курсора

    }
}