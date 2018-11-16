package ljavafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;

public class T7_images extends Application {

    private SplitPane root = new SplitPane();
    private ListView<File> images = new ListView<>();
    private Button chooseButton = new Button("выбрать");
    private TextField pathToCatalog = new TextField("путь до каталога");

    private ImageView fullImage = new ImageView();
    private Pane paneForImageView = new Pane(fullImage);

    private ObservableList<File> listOfImages = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
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
        /*URL pickURL = L7_ResourcesExamples.class.getResource("cat.jpg");
        Image img = new Image(pickURL.toExternalForm());
        fullImage.setImage(img);*/
        fullImage.setImage(new Image(L7_ResourcesExamples.class.getResource("cat.jpg").toExternalForm()));

        root.getItems().addAll(images, rightWithChooseAndFullImage);

        return root;
    }

    private void initInteraction() {
        //1
        //Для начала выберите какой-то фиксированный каталог с изображениями,
        String directoryWithImages = "P:\\фотошоп";
        File dirImagesFile = new File(directoryWithImages);

        //2
        // напишите код, который находит все файлы в этом каталоге
        if (dirImagesFile.isDirectory()) {
            File[] imageFiles = dirImagesFile.listFiles();
            if (imageFiles != null) {
                listOfImages.addAll(Arrays.asList(imageFiles));
                // и добавляет их в список ObservableList.
            }
        }
        images.setItems(listOfImages);

        //3
        //Сделайте так, что при выборе изображения в списке (images),
        // оно бы отображалось в ImageView (fullImage).
        images.getSelectionModel().selectedItemProperty().addListener(
                prop -> {
                    File selectedImage = images.getSelectionModel().getSelectedItem();
                    String imageURL = selectedImage.toURI().toString();
                    Image img = new Image(imageURL);
                    fullImage.setImage(img);
                }
        );

        //4
        //сделайте так, что ListView (images) при отображении элемента показывает картинку и имя файла.
        // Используйте CellFactory
        images.setCellFactory(
                (lv) -> new ListCell<File>() {
                    @Override
                    protected void updateItem(File item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty)
                            setText("");
                        else {
                            String i = item.toString();
                            setText(i.substring(directoryWithImages.length() + 1));

                            String imageURL = item.toURI().toString();
                            Image img = new Image(imageURL, 64, 64, true, false);
                            setGraphic(new ImageView(img));
                        }
                    }
                });

        //5
        //Сделайте так, что каталог можно выбирать.
        // Используйте класс Directory Chooser.
        // Это должен быть один DirectoryChooser на всю программу,
        // созадйте его один раз при запуске программы,
        // тогда он будет запоминать, какой каталог открывал в прошлый раз.

    }
}