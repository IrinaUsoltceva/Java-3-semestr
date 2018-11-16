package ljavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Observable;

public class T7_images extends Application {

    private SplitPane root = new SplitPane();
    private ListView<Image> images = new ListView<>();
    private Button chooseButton = new Button("выбрать");
    private TextField pathToCatalog = new TextField("путь до каталога");

    private ImageView fullImage = new ImageView();
    private Pane paneForImageView = new Pane(fullImage);

    ObservableList<Image> pictures;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("изображения");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction();
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox chooseAndPath = new HBox(pathToCatalog, chooseButton);

        chooseAndPath.setAlignment(Pos.TOP_RIGHT);
        HBox.setHgrow(pathToCatalog, Priority.ALWAYS);

        VBox rightWithChooseAndFullImage = new VBox(chooseAndPath, paneForImageView);

        VBox.setVgrow(paneForImageView, Priority.ALWAYS);
        HBox.setHgrow(paneForImageView, Priority.ALWAYS);
        fullImage.fitWidthProperty().bind(paneForImageView.widthProperty());
        fullImage.fitHeightProperty().bind(paneForImageView.heightProperty());
        fullImage.setPreserveRatio(true);

//временно, чтобы картинка была
        URL pickURL = L7_ResourcesExamples.class.getResource("cat.jpg");
        Image img = new Image(pickURL.toExternalForm());
        fullImage.setImage(img);

        root.getItems().addAll(images, rightWithChooseAndFullImage);

        return root;
    }

    private void initInteraction() {
        //Для начала выберите какой-то фиксированный каталог с изображениями,

        //Path directoryWithImages = Paths.get("P:\\фотошоп");
        String directoryWithImages = "P:\\фотошоп";
        File dirImagesFile = new File(directoryWithImages);

        ObservableList<File> listOfImages = FXCollections.observableArrayList();

        // напишите код, который находит все файлы в этом каталоге
        if (dirImagesFile.isDirectory()) {
            File[] imageFiles = dirImagesFile.listFiles();
            if (imageFiles != null) {
                listOfImages.addAll(Arrays.asList(imageFiles));
                // и добавляет их в список ObservableList.
            }
        }


    }
}