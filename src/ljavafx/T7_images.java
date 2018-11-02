package ljavafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class T7_images extends Application {

    private SplitPane root = new SplitPane();
    ListView<Image> images = new ListView<>();
    Button chooseButton = new Button("выбрать");
    TextField pathToCatalog = new TextField("путь до каталога");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("изображения");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox chooseAndPath = new HBox(chooseButton, pathToCatalog);
        root.getItems().addAll(images, chooseAndPath);

        return root;
    }

    private void initInteraction() {
    }
}