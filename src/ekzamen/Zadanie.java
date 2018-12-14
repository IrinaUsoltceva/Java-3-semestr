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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Zadanie extends Application {

    private Label title = new Label("здесь будут вопросы");
    private ImageView picture = new ImageView();

    private int questionNumber = 0;
    private Question[] questions = new Question[5];
    private int result = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("зачет");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction(primaryStage);
        primaryStage.show();
    }

    private Parent initInterface() {
        title.setText("Где сам осленок?");
        loadImage();
        title.setFont((Font.font(40)));
        return new VBox(title, picture);
    }

    private void initInteraction(Stage primaryStage) {
        loadQuest();
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->
                clicked(event.getX(), event.getY())
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
            e.printStackTrace();
        }
    }

    private void loadQuest() {
        try (
                InputStream textIS = Zadanie
                        .class
                        .getResourceAsStream("quest")
        ) {
            Scanner scannerIn = new Scanner(textIS);
            for (int i = 0; i < 5; i++) {
                questions[i] = new Question(
                        scannerIn.nextInt(), scannerIn.nextInt(), scannerIn.nextInt(), scannerIn.nextInt(),
                        scannerIn.nextLine()
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clicked(double x, double y) {
        Question question = questions[questionNumber];
        if (
                question.getX() <= x && x <= question.getX() + question.getWx() &&
                question.getY() <= y && y <= question.getY() + question.getWy()
        )
            result++;
        questionNumber++;
        System.out.println(question.getX() + " " + x + " " + (question.getX() + question.getWx()));
        System.out.println(question.getY() + " " + y + " " + (question.getY() + question.getWy()));

        if (questionNumber == 5) {
            new Alert(Alert.AlertType.INFORMATION, "Конец! Итого: " + result + "/" + questionNumber).showAndWait();
            questionNumber = 0;
            result = 0;
        }
        title.setText(questions[questionNumber].getQuestionString());
    }
}