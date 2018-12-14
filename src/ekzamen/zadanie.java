package ekzamen;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class zadanie extends Application {

    private Label title = new Label("здесь будут вопросы");
    private ImageView picture = new ImageView();
    private String url = "https://i.pinimg.com/474x/ac/6f/15/ac6f155f97200d7da7c1672fe7955d76.jpg";

    private int questionNumber = 0;
    private ArrayList<String> questions = new ArrayList<>();
    private int[][] answers = {{157, 136, 200, 150},
                               {354, 136, 60, 140},
                               {354, 136, 60, 140},
                               {354, 136, 60, 140},
                               {354, 136, 60, 140}};
                                 //x y wx wy
    //473 x 409
    private int result = 0;

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
        title.setText(questions.get(questionNumber));
        Image img = new Image(url);
        picture.setImage(img);
        return new VBox(title, picture);
    }

    private void initInteraction(Stage primaryStage) {
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                clicked(event.getSceneX(), event.getSceneY())
        );
    }

    private void fillQuestions() {
        questions.add("где сам осленок");
        questions.add("где голова1");
        questions.add("где голова2");
        questions.add("где голова3");
        questions.add("где голова4");
    }

    private void clicked (double x, double y) {
        if (questionNumber != 5) {
            if (answers[questionNumber][0] <= x &&
                    x <= answers[questionNumber][0] + answers[questionNumber][2] &&
                    answers[questionNumber][1] <= y &&
                    y <= answers[questionNumber][1] + answers[questionNumber][3])
                result++;
            questionNumber++;
            System.out.println(result + " " + questionNumber);
            title.setText(questions.get(questionNumber));
        }
        else
            System.out.println("конец");

        /*
        if (questionNumber == 5)
            title.setText(questions.get(questionNumber));
        else {
            new Alert(Alert.AlertType.INFORMATION, "конец!" + result + "/" + questionNumber).showAndWait();
            questionNumber = 0;
            result = 0;
            title.setText(questions.get(questionNumber));
        }
     */
    }
        /*
        идея:
        завести массив с 4 цифрами и вопросами
        при считывании использовать делимитер пробел? и берем 4+ элемент

        [i]-тый элемент - итый вопрос
        итый вопрос на метку, обработка события клик
        если кликнули и соответствует итым координатам - itog + 1
        иначе итог не меняется
        после этого меняется общий индекс и все обновляется

        таким образом, все зависит от индекса-номера вопроса
         */



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
