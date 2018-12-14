package ekzamen;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadanie extends Application {

    private Label title = new Label("здесь будут вопросы");
    private ImageView picture = new ImageView();
    //private String url = "https://i.pinimg.com/474x/ac/6f/15/ac6f155f97200d7da7c1672fe7955d76.jpg";
    private String fileQuest = "quest.txt";

    private int questionNumber = 0;
    private ArrayList<String> questions = new ArrayList<>();
    private int[][] answers = {{50, 101, 360, 200},
            {300, 80, 100, 160},
            {300, 80, 50, 180},
            {40, 130, 80, 70},
            {30, 220, 400, 110}};
    //x y wx wy
    //473 x 409
    private int result = 0;

    private Scanner scannerIn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("зачет");

        fillQuestions();
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction(primaryStage);
        primaryStage.show();
    }

    private Parent initInterface() {
        title.setText("где сам осленок");
        loadImage();
        loadText();
        return new VBox(title, picture);
    }

    private void initInteraction(Stage primaryStage) {
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                clicked(event.getSceneX(), event.getSceneY())
        );
    }

    private void loadImage() {
        try (
                InputStream image = Zadanie
                        .class
                        .getResourceAsStream("oselik.jpg")
        ) {
            Image img = new Image(image);
            picture.setImage(img);

        } catch (IOException e) {
        }
    }

    private void loadText() {
        try (
                InputStream textIS = Zadanie
                        .class
                        .getResourceAsStream("quest")
        ) {
            scannerIn = new Scanner(textIS);
        } catch (IOException e) {
        }
    }

    private void fillQuestions() {
        questions.add("где сам осленок");
        questions.add("где голова");
        questions.add("где уши");
        questions.add("где хвост");
        questions.add("где лапы");
    }

    private void clicked(double x, double y) {
        if (
                answers[questionNumber][0] <= x &&
                x <= answers[questionNumber][0] + answers[questionNumber][2] &&
                answers[questionNumber][1] <= y &&
                y <= answers[questionNumber][1] + answers[questionNumber][3]
        )
            result++;
        System.out.println(questionNumber + " " + result);
        questionNumber++;

        if (questionNumber == 5) {
            new Alert(Alert.AlertType.INFORMATION, "Конец! Итого: " + result + "/" + questionNumber).showAndWait();
            questionNumber = 0;
            result = 0;
        }
        title.setText(questions.get(questionNumber));
    }

    /*
    пять вопросов наподобие "где у осла уши"
    ткнуть на уши - правильный ответ, следующий вопрос

    после пяти вопросов
        - сообщение "3/5"
        - все с начала начинаем

    событие mouse.click - там значение в координатах

    картинка - ресурс
    вопросы и ответы - ресурс, текстовый файл
    30 50 100 100 где уши?
    100 200 100 100 где носик?

    scanner нормально работает с (IS)
    один трай открывает ресурс, не перемудривать
    можно попробовать текстовый файл на конец
     */


}
