package JavaFX.L5_ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class L6_PropertiesListenersAndBindingss extends Application {

    //поля класса. Они живут и доступны все время, пока жив класс, т.е.
    //окно нашей программы
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

        //----------------------------------------------------
        VBox example1 = new VBox();
        //Старайтесь давать переменным осмысленные названия. Здесь button1 означает
        //только, что это кнопка для первого примера.
        textField1 = new TextField();
        button1 = new Button("Пример 1");
        example1.getChildren().addAll(textField1, button1);

        //давайте раскрасим панель example1
        example1.setBackground( //фон
                new Background(
                        new BackgroundFill(
                                Color.web("#FF0000"), //Цвет может выступать запонителем фона
                                new CornerRadii(0), //радиус закругления углов
                                Insets.EMPTY //пустой отступ для закраски
                        ) //заполнитель для фона
                )
        );
        example1.setStyle("-fx-background-color: #00FF00"); //другой способ, чуть короче
        //пользуемся CSS со стилями из javafx
        //----------------------------------------------------

        root.getChildren().addAll(example1);

        return root;
    }

    private void initInteraction() {
        //-------------Пример 1-------------
        //как заставить кнопку что-то делать

        //1) универсальный, но сложный способ
        //В JavaFX реализована работа с событями. Разные объекты генерируют события
        //можно добавлять слушателей (обработчиков), которые реагируют на интерующие
        //их события.
        //Кнопка генерирует событие типа ActionEvent.ACTION, это происходит
        //в момент нажатия на кнопку. Нажатие может быть разным, мышкой, кнопкой Enter,
        //пробелом, касанием экрана и т.п.
        //В принципе, все Node, включая кнопку, генерируют еще и события мыши, т.е.
        //можно реагировать на событие, что на кнопку наведена/нажата/отпущена мышь.
        //Но в этой программе нам это не инетресно
        button1.addEventHandler(
                ActionEvent.ACTION, //какое именно событие кнопки нас интересует
                a -> System.out.println("pressed: " + a)
                //второе - это действие, в виде лямбда выражения.
                //a - информация о событии. В этой информации всегда можно найти
                //источник события. Если бы у нас было событие от мыши, мы бы
                //дополнительно могли получить информацию о положении курсора.
        );

        //другой способ обработки события нажатия на кнопку
        button1.setOnAction(a -> System.out.println("pressed (onAction): " + a));
        //этот способ проще, чаще всего его достаточно
        //этим способом можно связать с кнопкой только одно действие
        //А addEventHandler - любое количество обработчиков

        //другие варианты события
        //MouseEvent.MOUSE_CLICKED - нажали мыш
        //MouseEvent.MOUSE_ENTERED - навели мыш

        //Свойства. В жаваФХ объекты имеют свойства. Это данные, которые
        //связаны с объектами. Например, у кнопки - это текст который на ней
        //написан (это свойство называется text). Или действие, которое выполняется
        //при нажатии. (это свойство называется onAction)
        // у текстового поля тоже есть свойство text  - это тот текст, который в него введен
        //Свойства хранятся в полях объекта. Но если данные оформлены в виду свойства,
        //то появляется возможность следить за изменениями этого свойства
        //и еще управлять изменением (см. связывание - bindings)

        //к примеру, у текстового поля есть свойства text, тогда с ним можно работать так:
        textField1.textProperty() // обращение к свойству text
            .set("Text for Textfield1"); //метод set устанавливает значение для св-ва
        System.out.println(
                textField1.textProperty().get() //узнать значение свойства
        );

        textField1.textProperty().addListener( //можно добавлять слушателей об изменении св-ва
                prop -> System.out.println(
                        "Значение изменилось на " + textField1.textProperty().get()
                )
                //это InvalidatoinListener
        );

        //prop - это ссылка на тот property, который изменился
        //в нашем случае это тот же самый textField1.textProperty
        //но бывает так, что один  и тот же слушатель добавляется на разные
        //свойства, в этом случае  бывает важно знать, какое именно свойство изменилось.

        textField1.textProperty().addListener(
                (prop, oldValue, newValue) -> System.out.println(
                        "Значение изменилось с " + oldValue + " на " + newValue
                )
                //это changeListener, в нем можно дополнительно узнать,
                //какое значение было
        );

        //вместо textField1.textproperty().get() можно писать
        textField1.getText(); //т.е. get[Имя свойства]
        //аналогично
        textField1.setText("41"); //т.е. set[имя свойства]

        //итого, если у объекта о есть свойство abc, то есть методы:
        //o.abcProperty(), o.getAbc(), o.setABC() - последнего нет для readonly свойств


        //-------------Пример 2-------------
    }
}