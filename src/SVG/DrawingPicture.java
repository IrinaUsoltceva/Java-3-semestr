package SVG;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DrawingPicture extends Application {

    private Pane root = new Pane();



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Картинка");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root, 400, 400));

        initInteraction();
        primaryStage.show();


    }

    private Parent initInterface() {
        root.getChildren().addAll();
        return root;
    }

    private void initInteraction() {

    }



}
